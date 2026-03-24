package com.deposit.D2E2EMobileFramework.D2E2ESparkMobileFramework.StepDefinition;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.deposit.D2E2EMobileFramework.D2E2ESparkMobileFramework.Config.*;
import com.deposit.D2E2EMobileFramework.D2E2ESparkMobileFramework.Exceptions.*;
import com.deposit.D2E2EMobileFramework.D2E2ESparkMobileFramework.Utilities.*;
import com.deposit.D2E2EMobileFramework.D2E2ESparkMobileFramework.StepDefinition.*;

public class ListenerImplementation implements ITestListener{
	
	public static TestResultsUtils testResultUtils = new TestResultsUtils(); 
	private static final Logger LOG = LoggerFactory.getLogger(LoginPageStepDefinition.class);
	
	@Override
	public void onStart(ITestContext Result) {
		try {
			TestResultsUtils.outputFolder();
//			AppiumServiceBuilder 
		} catch (D2E2ESparkMobileFrameworkException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult Result) {
		try {
			TestResultsUtils.extentReportInitialize();
			testResultUtils.logger = testResultUtils.extent.startTest(LocalTestDataManager.getFeaturename());
			LOG.info("in before step", LocalTestDataManager.getScenarioname());
		} catch (D2E2ESparkMobileFrameworkException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public void onTestFailure(ITestResult Result) {
		
		try {
			LOG.info("in before step", LocalTestDataManager.getScenarioStatus());
			testResultUtils.extentReportFlush();
			AppiumNGSuite.tearDown();
		} catch (D2E2ESparkMobileFrameworkException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void onTestSuccess(ITestResult Result) {
		
		try {
			LOG.info("in before step", LocalTestDataManager.getScenarioStatus());
			testResultUtils.extentReportFlush();
			AppiumNGSuite.tearDown();
		} catch (D2E2ESparkMobileFrameworkException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void onTestSkipped(ITestResult Result) {
		
		try {
			LOG.info("in before step", LocalTestDataManager.getScenarioStatus());
			testResultUtils.extentReportFlush();
			AppiumNGSuite.tearDown();
		} catch (D2E2ESparkMobileFrameworkException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
