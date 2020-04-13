package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\user\\eclipse-workspace\\AutomationTestingSite\\src\\test\\resources\\features\\ValidAndInvalid.feature",
tags= { "  @TC_03,@TC_04"},
glue= {"stepDefination"},
plugin= {"html:target/cucumber-html.report"})
/**
 * class created to run valid and invalid credentials
 */
public class ValidInvalidTestRunner {

	private TestNGCucumberRunner testRunner;
	/**
	 * method to method for Initializing the Objects
	 */
	@BeforeClass
	public void setUP()
	{
		testRunner = new TestNGCucumberRunner(ValidInvalidTestRunner.class);			
	}

	@Test(description="login",dataProvider="features")
	public void login(CucumberFeatureWrapper cFeature)
	{
		testRunner.runCucumber(cFeature.getCucumberFeature());
	}
	/**
	 * method to read the test data from features
	 * @return data
	 */
	@DataProvider(name="features")
	public Object[][] getFeatures()
	{
		return testRunner.provideFeatures();
	}
	/**
	 * method to close the page
	 * @throws InterruptedException
	 */
	@AfterClass
	public void tearDown() throws InterruptedException
	{		
		testRunner.finish();
	}
}


