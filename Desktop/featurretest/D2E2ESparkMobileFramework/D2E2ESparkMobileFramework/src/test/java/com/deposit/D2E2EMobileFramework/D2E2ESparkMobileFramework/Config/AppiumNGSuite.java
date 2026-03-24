package com.deposit.D2E2EMobileFramework.D2E2ESparkMobileFramework.Config;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.deposit.D2E2EMobileFramework.D2E2ESparkMobileFramework.Constants.*;
import com.deposit.D2E2EMobileFramework.D2E2ESparkMobileFramework.Exceptions.*;
import com.deposit.D2E2EMobileFramework.D2E2ESparkMobileFramework.Utilities.*;

/**
 * The Class SeleniumNGSuite.
 */
public class AppiumNGSuite {

	/** The logger. */
	private static final Logger LOG = LoggerFactory.getLogger(AppiumNGSuite.class);

	/** The base project path. */
	public static String baseProjectPath = System.getProperty(Constants.USER_DIR);

	/** The configprops. */
	public static PropertyUtils configprops = new PropertyUtils(baseProjectPath.concat(Constants.CONFIG_PROPERTY));

	/** The browser type. */
	public static String browserType = configprops.getProperty("browser_name");

	/** The url. */
	public static String url = configprops.getProperty(Constants.URL);

	/** The execution OS. */
	public static String executionOperatingSystem = configprops.getProperty("executionOS");
	
	/** The current suite. */
	public static String currentSuite = "";

	/** The creating object to DriverConfig. */
	public DriverConfig config = new DriverConfig();
	

	/**
	 * Sets the up suite.
	 *
	 * @throws Throwable
	 *             the throwable
	 */
	public void setUpSuite(String inputInstance) throws Throwable {
	/*	
		if(executionType.equals("Web")) {
			config.setup(browserType, url);
		}else {
			switch(executionOperatingSystem){
			case "Android":
			config.setUp(androidPlatformName,androidPlatformVersion,androidDeviceName,browserType,appiumServerURL);
			break;
			case "iOS":
			config.setUp(iOSPlatformName,iOSPlatformVersion,iOSDeviceName,browserType,appiumServerURL);
			break;	
			
	}
		} */
		
		if(inputInstance.equals("web")) {
			config.setup(browserType, url);
		}else if(inputInstance.equals("mobileapp")) {
			config.setUp(executionOperatingSystem);
		}
			
		
	}

	/**
	 * Tear down.
	 *
	 */
	public static void tearDown() throws D2E2ESparkMobileFrameworkException {

		try {
			if(LocalDriverManager.getDriver()!=null) {
				LocalDriverManager.getDriver().quit();
			}else if(LocalDriverManager.getAppiumDriver()!=null) {
				LocalDriverManager.getAppiumDriver().quit();
			}
				
			LOG.info("Successfully closed the browser ");
		}catch (Exception exception) {
			LOG.error("Error in closing the browser:: {}", exception.getMessage());
			exception.printStackTrace();
			throw new D2E2ESparkMobileFrameworkException(exception);
		}

	}
	
	
}