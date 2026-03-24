package com.deposit.D2E2EMobileFramework.D2E2ESparkMobileFramework.Runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(features = "src/test/resources/features", glue = "com/deposit/D2E2EMobileFramework/D2E2ESparkMobileFramework/StepDefinition", tags ="@demoe2eflow")
	public class TestRunner extends AbstractTestNGCucumberTests{
		
		private TestNGCucumberRunner testNGCucumberRunner;
		
		@BeforeClass(alwaysRun = true)
		public void setupClass() {
			testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());	
			System.out.println("before class mobile runner");
			}
		
		@AfterClass(alwaysRun = true)
		public void tearDwonClass() {
			System.out.println("finish execution");
			testNGCucumberRunner.finish();
			}	

}
