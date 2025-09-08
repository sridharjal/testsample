package com.deposit.D2E2EMobileFramework.D2E2ESparkMobileFramework.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.deposit.D2E2EMobileFramework.D2E2ESparkMobileFramework.StepDefinition.ListenerImplementation;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindAll;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.iOSXCUITBy;
import io.appium.java_client.pagefactory.AndroidBy;

public class LoginPage {
	
	public static String tokenValue="";
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	
	@FindBy(xpath = "//strong[contains(text(),'Log In')]")
	private WebElement loginBtnHomeScvreen;

	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Sign up\"]")
	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Username\"]")
	private WebElement usernameTextField;
	
	
	
	public void getToken() {
		try {
			System.out.println("captured token from browser");
			tokenValue = "abdced";
			ListenerImplementation.testResultUtils.logger.log(LogStatus.PASS, "captured token from browser");
		}catch(Throwable e) {
			ListenerImplementation.testResultUtils.logger.log(LogStatus.FAIL, "Unable to capture token from browser");
		}
		
		
	}
	
	public void enterTokenInMobile() {
		try {
			
			usernameTextField.sendKeys(tokenValue);
			Thread.sleep(6500);
			System.out.println("entered token in the mobile app");
			ListenerImplementation.testResultUtils.logger.log(LogStatus.PASS, "entered token in the mobile app");
		}catch(Throwable e) {
			ListenerImplementation.testResultUtils.logger.log(LogStatus.FAIL, "Unable to enter token in the mobile app");
		}
		
	}
	

}
