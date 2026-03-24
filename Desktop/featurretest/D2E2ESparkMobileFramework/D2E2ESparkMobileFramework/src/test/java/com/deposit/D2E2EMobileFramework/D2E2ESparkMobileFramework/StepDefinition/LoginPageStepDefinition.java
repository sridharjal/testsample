package com.deposit.D2E2EMobileFramework.D2E2ESparkMobileFramework.StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import com.relevantcodes.extentreports.LogStatus;
import com.deposit.D2E2EMobileFramework.D2E2ESparkMobileFramework.Config.*;
import com.deposit.D2E2EMobileFramework.D2E2ESparkMobileFramework.Exceptions.D2E2ESparkMobileFrameworkException;
import com.deposit.D2E2EMobileFramework.D2E2ESparkMobileFramework.PageObjects.*;
import com.deposit.D2E2EMobileFramework.D2E2ESparkMobileFramework.Utilities.*;
import com.deposit.D2E2EMobileFramework.D2E2ESparkMobileFramework.StepDefinition.ListenerImplementation;

public class LoginPageStepDefinition {
	
	public static String scenarioName;
	Scenario sce;
	
	AppiumNGSuite instance = new AppiumNGSuite();
	
	

	@Before
	public void beforeHook(Scenario scenario) throws Throwable {
	this.sce= scenario;
	scenarioName = scenario.getName();
	ListenerImplementation.testResultUtils.logger = ListenerImplementation.testResultUtils.extent.startTest(scenarioName);
	ListenerImplementation.testResultUtils.logger.log(LogStatus.PASS, "Started Execution :: "+scenarioName);
	}
	
	@After()
	public void afterHook() throws Throwable {
		ListenerImplementation.testResultUtils.logger.log(LogStatus.PASS, "Ended Execution :: "+scenarioName);
		scenarioName=null;
		
	}

	@Given("^Launch the portal and mobile app using (.+)$")
	public void launchWebPortalMobileApp(String web) throws Throwable {
		try {
		instance.setUpSuite(web);
		ListenerImplementation.testResultUtils.logger.log(LogStatus.PASS, "Successfully launched " +web);
		}catch(Throwable e) {
			ListenerImplementation.testResultUtils.logger.log(LogStatus.FAIL, "Unable to launch " +web);
		}
		
	}
	
	@Then("close the browser or app instance")
	public void closeBrowserAppInstance() throws Exception {
		try {
		AppiumNGSuite.tearDown();
		ListenerImplementation.testResultUtils.logger.log(LogStatus.PASS, "Successfully closed the instance");
		}catch(Throwable e) {
			ListenerImplementation.testResultUtils.logger.log(LogStatus.FAIL, "Unable to close instance");
		}
	}
	
	@When("Capture token from the browser")
	public void captureToken() {
		instanceToLoginPage("web").getToken();
	}
	
	@And("Enter token on the Mobile App")
	public void enterTokenInMobile() {
		instanceToLoginPage("mobile").enterTokenInMobile();
	}
	
	
	private LoginPage instanceToLoginPage(String appInstance) {
		LoginPage lp = null ;
		if(appInstance.equals("web")) {
			lp = new LoginPage(LocalDriverManager.getDriver());
		}else if(appInstance.equals("mobile")) {
			lp = new LoginPage(LocalDriverManager.getAppiumDriver());	
		}
		
		return lp;
		
	}

	
	
	
	
	
	
}
