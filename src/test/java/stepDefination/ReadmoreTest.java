package stepDefination;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import cts.ATSite.Libraries.BrowserFactory;
import cts.ATSite.Libraries.Screenshot;
import cts.ATSite.Pages.ReadmorePageFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Automation testing site is opened and goes to shop and then moves to testcases to read 
 * more about the site and takes the screenshot 
 *
 */

public class ReadmoreTest {
	static ReadmorePageFactory lpom;
	static String[] data = null;

	WebDriver driver;
	Logger logger;
	/**
	 * launches the browser
	 */
	@Given("^the user launches the app in browser$")
	public void the_user_launches_the_app_in_browser() throws Throwable {

		BrowserFactory b=new BrowserFactory();
		driver=b.startBrowser("chrome", "http://practice.automationtesting.in");
		logger=Logger.getLogger("stepDefination");
		PropertyConfigurator.configure("Log4j.properties");
		logger.info("launched browser");
	}
	/**
	 * clicks on shop and opens the page
	 */
	@When("^user clicks on Shop$")
	public void user_clicks_on_Shop() throws Throwable {
		lpom = PageFactory.initElements(driver, ReadmorePageFactory.class);
		lpom.Shopp();
		logger.info("Clicked on shopping page");
	}
	/**
	 * Then opens the testcases to readmore
	 * */
	@Then("^user clicks Read more$")
	public void user_clicks_Read_more() throws Throwable {

		driver.findElement(By.xpath("//a[contains(text(),'Test Cases')]")).click();
		logger.info("opens testcases to readmore");
	}
	/**
	 * Takes screenshot and closes the browser
	 */
	@Then("^I validate the outcomes of Read more$")
	public void i_validate_the_outcomes_of_Read_more() throws Throwable {
		Thread.sleep(1000);
		Screenshot ob=new Screenshot();
		ob.getScreenshot(driver);
		logger.info("Browser is closed");
		driver.quit();

	}
}