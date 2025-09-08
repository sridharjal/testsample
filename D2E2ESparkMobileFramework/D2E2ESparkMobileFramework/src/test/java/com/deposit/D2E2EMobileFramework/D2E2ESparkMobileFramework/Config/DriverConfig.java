package com.deposit.D2E2EMobileFramework.D2E2ESparkMobileFramework.Config;

import java.io.File;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import com.deposit.D2E2EMobileFramework.D2E2ESparkMobileFramework.Constants.*;
import com.deposit.D2E2EMobileFramework.D2E2ESparkMobileFramework.Exceptions.*;
import com.deposit.D2E2EMobileFramework.D2E2ESparkMobileFramework.Utilities.*;


/**
 * The Class DriverConfig.
 *
 */
public class DriverConfig {

	/** The base project path. */
	public static String baseProjectPath = System.getProperty(Constants.USER_DIR);
	
	/** The configprops. */
	public static PropertyUtils configprops = new PropertyUtils(baseProjectPath.concat(Constants.CONFIG_PROPERTY));

	/** The logger. */
	private static final Logger LOG = LoggerFactory.getLogger(DriverConfig.class);
	
	public static File folder;
	
	public DesiredCapabilities capabilities = new DesiredCapabilities();
	
	public MutableCapabilities mobileCapabilities = new MutableCapabilities();
	
	public MutableCapabilities sauceOptions = new MutableCapabilities();
	
	public URL url ;
	
	
	
	/**
	 * This method returns the driver object for the given browser type with the
	 * page loaded with the given url.
	 *
	 * @param browserType
	 *   the browser type
	 * @param url
	 *   the url
	 * @throws Throwable
	 *    the throwable
	 */

	public void setup(String browserName, String applicaionURL) throws Throwable {
		WebDriver driver = null ;
		try {
			
			switch(browserName) {
			case "Chrome":
				driver= new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
				break;
			case "safari":
				driver = new SafariDriver();
				break;
			}
			LocalDriverManager.setWebDriver(driver);
			LocalDriverManager.getDriver().manage().window().maximize();
			LocalDriverManager.getDriver().get(applicaionURL);
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}


	public void setUp(String executionOS) throws Throwable {
		 AppiumDriver driver = null;
		try {
			
			switch(executionOS){
			case "Android":
				/* Uncomment this if we want to run on realdevice
				UiAutomator2Options options = new UiAutomator2Options();
				options.setPlatformName(platformName);
				options.setPlatformVersion(platformVersion);
				options.setDeviceName(deviceName);
				options.setApp(Constants.APK_FILES_PATH);
				options.setAutomationName(Constants.ANDROID_AUTOMATION_NAME);
				options.setAppActivity("com.swaglabsmobileapp.MainActivity");
				
				
				driver = new AndroidDriver(
					    new URL(appiumServerURL), options
					); */
				
				mobileCapabilities.setCapability("platformName", "Android");
				mobileCapabilities.setCapability("appium:app", "storage:filename=Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");  // The filename of the mobile app
				mobileCapabilities.setCapability("appium:deviceName", "Android GoogleAPI Emulator");
				mobileCapabilities.setCapability("appium:platformVersion", "15.0");
				mobileCapabilities.setCapability("appium:automationName", "UiAutomator2");
				mobileCapabilities.setCapability("appium:appActivity", "com.swaglabsmobileapp.MainActivity");
				sauceOptions.setCapability("appiumVersion", "2.11.0");
				sauceOptions.setCapability("username", "oauth-sridhar.jaltaru-68766");
				sauceOptions.setCapability("accessKey", "81f0b9cd-2bcc-4127-87e8-684a1e57d945");
				sauceOptions.setCapability("deviceOrientation", "PORTRAIT");
				mobileCapabilities.setCapability("sauce:options", sauceOptions);

				// Start the session
				url = new URL("https://oauth-sridhar.jaltaru-68766:81f0b9cd-2bcc-4127-87e8-684a1e57d945@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
				 driver = new AndroidDriver(url, mobileCapabilities);
				Thread.sleep(6500);
				break;
			case "iOS":
				/* Uncomment this if we want to run on realdevice
				XCUITestOptions iOSOptions = new XCUITestOptions();
				iOSOptions.setUdid(Constants.IOS_DEVICE_UDID);
				iOSOptions.setApp(baseProjectPath+Constants.IPA_FILES_PATH);
				 driver = new IOSDriver(
					    new URL("http://127.0.0.1:4723"), iOSOptions);
					    */
				
				
				mobileCapabilities.setCapability("platformName", "iOS");
				mobileCapabilities.setCapability("appium:deviceName", "iPhone Simulator");
				mobileCapabilities.setCapability("appium:platformVersion", "16.1");
				mobileCapabilities.setCapability("appium:automationName", "XCUITest");
				
				sauceOptions.setCapability("appiumVersion", "2.0.0-flutter2");
				sauceOptions.setCapability("username", "oauth-sridhar.jaltaru-68766");
				sauceOptions.setCapability("accessKey", "81f0b9cd-2bcc-4127-87e8-684a1e57d945");
//				sauceOptions.setCapability("build", "<your build id>");
//				sauceOptions.setCapability("name", "<your test name>");
				sauceOptions.setCapability("deviceOrientation", "PORTRAIT");
				mobileCapabilities.setCapability("sauce:options", sauceOptions);

				// Start the session
				url = new URL("https://oauth-sridhar.jaltaru-68766:81f0b9cd-2bcc-4127-87e8-684a1e57d945@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
				driver = new IOSDriver(url, mobileCapabilities);
				
				Thread.sleep(6500);
				break;
			}
			
//			driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
			LocalDriverManager.setWebDriver(driver);
			LocalDriverManager.setAppiumDriver(driver);

		}catch (Throwable throwable) {
		LOG.error("Error Occured in Getting the driver object ::{}", throwable.getMessage());
		throw new D2E2ESparkMobileFrameworkException(throwable);
	}
		
	}
}
