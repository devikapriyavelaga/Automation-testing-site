package stepDefination;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.PageFactory;

import cts.ATSite.Libraries.BrowserFactory;
import cts.ATSite.Libraries.ExcelData;
import cts.ATSite.Pages.DemoSitePageFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * launching the browser and navigating to demo site filling the registration form and
 * to retrive any data from Cruises table
 */
public class  DemoSiteTest extends BrowserFactory{
	static DemoSitePageFactory dpom;
	static String[] data = null;
	Logger logger;
	/**
	 * Launching the chrome browser
	 */
	@Given("^the user launches the application in browser$")
	public void the_user_launches_the_application_in_browser() throws Throwable {
		startBrowser("chrome", "http://practice.automationtesting.in");
		logger=Logger.getLogger("stepDefination");
		PropertyConfigurator.configure("Log4j.properties");
		logger.info("Launced browser");
	}
	/**
	 * navigating to the demo site
	 */
	@Then("^click DemoSite$")
	public void click_DemoSite() throws Throwable {
		dpom =PageFactory.initElements(driver, DemoSitePageFactory.class);
		dpom.account();
		logger.info("DemoSite is opened");
	}

	/**
	 * taking the credentials from the excel and entering in to the text boxs
	 */
	@Then("^user fills all the details$")
	public void user_fills_all_the_details() throws Throwable {
		ExcelData xl=new ExcelData();
		int j=0;
		data=new String[10]; 
		for(int i=9;i<=17;i++)
		{
			data[j]=xl.readXL("C:\\Users\\user\\eclipse-workspace\\AutomationTestingSite\\src\\test\\resources\\XLSX\\TestData.xlsm", i, 1);
			System.out.println(data[j]);
			j++;
		}
		dpom.details(data);
		logger.info("Credentials are entered ");
	}


	/**
	 * clicking on the submit button
	 */
	@Then("^Clicks Register button$")
	public void clicks_Register_button() throws Throwable {
		dpom.submit();
		Thread.sleep(5000);
		logger.info("Clicked on submit button");
	}



	/**
	 * checking the details and  retrieving any data from Cruises table
	 */
	@Then("^I validate the results$")
	public void i_validate_the_results() throws Throwable {
		String ar=driver.getTitle();
		System.out.println(ar);
		String er="Web Table";
		if(ar.equals(er))
			System.out.println("pass");
		else
			System.out.println("fail");

		logger.info("Application is closed");

		driver.quit();

	}
}





