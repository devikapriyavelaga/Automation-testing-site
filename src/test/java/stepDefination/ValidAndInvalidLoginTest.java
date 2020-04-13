package stepDefination;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.PageFactory;

import cts.ATSite.Libraries.BrowserFactory;
import cts.ATSite.Libraries.ExcelData;
import cts.ATSite.Libraries.Screenshot;
import cts.ATSite.Pages.ValidInvalidLoginPageFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 *launching the browser and the entering the valid and invalid login credentials 
 *and taking the screenshot of it 
 */
public class ValidAndInvalidLoginTest   extends BrowserFactory{
	static ValidInvalidLoginPageFactory lpom;
	static String[] data = null;
	Logger logger;
	/**
	 * Launching the chrome browser
	 */
	@Given("^the user launch the application in browser$")
	public void the_user_launch_the_application_in_browser() throws Throwable {
		startBrowser("chrome", "http://practice.automationtesting.in");
		logger=Logger.getLogger("stepDefination");
		PropertyConfigurator.configure("Log4j.properties");
		logger.info("Launced browser");
	}

	/**
	 * navigating to the login page
	 */
	@When("^the user clicks on My Accounts$")
	public void the_user_clicks_on_My_Accounts() throws Throwable {
		lpom =PageFactory.initElements(driver, ValidInvalidLoginPageFactory.class);
		lpom.account();
		logger.info("Opened my account");
	}

	/**
	 * taking the valid credentials from the excel sheet
	 *  entering the credentials in to the text box
	 */
	@When("^the user Enters the valid username and password$")
	public void the_user_Enters_the_valid_username_and_password() throws Throwable {
		ExcelData xl=new ExcelData();
		int j=0;
		data=new String[2]; 
		for(int i=1;i<=2;i++)
		{
			data[j]=xl.readXL("C:\\Users\\user\\eclipse-workspace\\AutomationTestingSite\\src\\test\\resources\\XLSX\\TestData.xlsm", i, 1);
			System.out.println(data[j]);
			j++;
		}
		lpom.details(data);
	}

	/**
	 * clicking the login button
	 */
	@When("^click on signin button$")
	public void click_on_signin_button() throws Throwable {
		lpom.login();
	}

	/**
	 * checking the entered details are valid or not and taking the screenshot of it
	 */
	@Then("^I validate the outcomes of valid login$")
	public void i_validate_the_outcomes_of_valid_login() throws Throwable {
		String ar=driver.getTitle();
		String er="My Account – Automation Practice Site";
		if(ar.equals(er))
			System.out.println("fail");
		else
			System.out.println("pass");
		logger.info("entered valid credentials");
		Screenshot ob=new Screenshot();
		ob.getScreenshot(driver);
		Thread.sleep(100);
		driver.quit();
	}

	/**
	 * taking the invalid credentials from the excel sheet
	 *  entering the credentials in to the text box
	 */
	@When("^the user Enters the Invalid username and password$")
	public void the_user_Enters_the_Invalid_username_and_password() throws Throwable {
		ExcelData xl=new ExcelData();
		int j=0;
		data=new String[2]; 
		for(int i=5;i<=6;i++)
		{
			data[j]=xl.readXL("C:\\\\Users\\\\user\\\\eclipse-workspace\\\\AutomationTestingSite\\\\src\\\\test\\\\resources\\\\XLSX\\\\TestData.xlsm", i, 1);
			System.out.println(data[j]);
			j++;
		}

		lpom.details(data);
		logger.info("enters invalid credentials");
	}


	/**
	 * checking the entered details are invalid or not and taking the screenshot of it
	 */
	@Then("^I validate the outcomes of invalid login$")
	public void i_validate_the_outcomes_of_invalid_login() throws Throwable {
		String ar=lpom.invalid();
		String er="ERROR: Invalid username. Lost your password?";
		if(ar.equals(er))
			System.out.println("pass");
		else
			System.out.println("fail");
		Screenshot ob=new Screenshot();
		ob.getScreenshot(driver);
		logger.info("application is closed");
		Thread.sleep(100);
		driver.quit();
	}


}


