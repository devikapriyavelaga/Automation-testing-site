package stepDefination;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cts.ATSite.Libraries.BrowserFactory;
import cts.ATSite.Libraries.ConfigReader;
import cts.ATSite.Libraries.ExcelDataConfig;
import cts.ATSite.Libraries.Screenshot;
import cts.ATSite.Pages.LoginPageWithPageFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Automation Testing site is launched and login with valid credentials and added items to
 *  basket and proceeded to checkout
 */
public class ValidUsernameAndPasswordTest   {

	WebDriver driver;
	Logger logger;
	ConfigReader config=new ConfigReader();
	ExcelDataConfig configExcel=new ExcelDataConfig("C:\\Users\\user\\eclipse-workspace\\AutomationTestingSite\\src\\test\\resources\\XLSX\\Data.xlsm");
	LoginPageWithPageFactory s=new LoginPageWithPageFactory(driver);
	public static ExtentReports report = new ExtentReports("./Reports/ExtentReport.html");
	ExtentTest test = report.startTest("logintest");
	/**
	 *Launching the chrome browser and navigating to myaccount page
	 */
	@Given("^Open chrome and start application$")
	public void open_chrome_and_start_application() throws Throwable {

		BrowserFactory b=new BrowserFactory();
		logger=Logger.getLogger("stepDefination");
		PropertyConfigurator.configure("Log4j.properties");
		driver=b.startBrowser("chrome","http://practice.automationtesting.in/");

		test.log(LogStatus.PASS,"launched automation testing site");
		driver.navigate().to("http://practice.automationtesting.in/my-account/"); 
		logger.info("myaccount");
	}

	/**
	 *Entering valid credentials using data driven concept
	 */
	@When("^I enter valid \"([^\"]*)\"$")
	public void i_enter_valid_and_valid(String usernameNumber) throws Throwable {
		LoginPageWithPageFactory obj=PageFactory.initElements(driver,LoginPageWithPageFactory.class);

		Object[][] data=configExcel.passData();
		String username="";
		String password="";

		if(null!= usernameNumber ) {

			int userCount = Integer.parseInt(usernameNumber.trim());
			username = (String )data[userCount-1][0];
			password = (String )data[userCount-1][1];	

		}
		obj.userlogin(username,password);

	}

	/**
	 *Clicking login button
	 */
	@When("^user should be able to login$")
	public void user_should_be_able_to_login() throws Throwable {
		LoginPageWithPageFactory obj=PageFactory.initElements(driver,LoginPageWithPageFactory.class);

		obj.clickOnLoginButton();	
		test.log(LogStatus.PASS,"Login successful");
		logger.info("loginsuccessful");
	}
	/**
	 *User navigates to shopping page
	 */
	@When("^user should  navigate to shop$")
	public void user_should_navigate_to_shop() throws Throwable {

		driver.navigate().to("http://practice.automationtesting.in/shop/");
		test.log(LogStatus.PASS,"opened shopping site");
		logger.info("selected shop");
	}

	/**
	 *Products are added to basket and are viewed in cart
	 */
	@When("^user should add to cart$")
	public void user_should_add_to_cart() throws Throwable {

		LoginPageWithPageFactory obj=PageFactory.initElements(driver,LoginPageWithPageFactory.class);
		obj.opencart();
		test.log(LogStatus.PASS,"Added items to cart and viewed it");
		logger.info("Added to cart and viewed items");

	}

	/**
	 *User proceeds to checkout
	 */
	@When("^user should checkout$")
	public void user_should_checkout() throws Throwable {

		LoginPageWithPageFactory obj=PageFactory.initElements(driver,LoginPageWithPageFactory.class);
		obj.checkout();
		test.log(LogStatus.PASS,"Proceed to checkout");
		logger.info("proceed to checkout");

	}
	/**
	 *Application is closed successfully
	 */
	@Then("^application should be closed$")
	public void application_should_be_closed() throws Throwable {

		Screenshot ob=new Screenshot();
		ob.getScreenshot(driver);
		test.log(LogStatus.PASS,"Placed order successfully");
		logger.info("placed order");
		driver.quit();
		report.endTest(test);
		report.flush();

	}
}
