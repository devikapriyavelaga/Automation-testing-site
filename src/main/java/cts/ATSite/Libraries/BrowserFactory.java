package cts.ATSite.Libraries;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * initialize the requested browser for the test i.e., chromedriver, firefoxdriver.
 *
 */
public class BrowserFactory {
	public WebDriver driver;

	public WebDriver startBrowser(String browserName,String url) {

		if(browserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\eclipse-workspace\\AutomationTestingSite\\src\\test\\resources\\Binaries\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\user\\eclipse-workspace\\AutomationTestingSite\\src\\test\\resources\\Binaries\\gechodriver.exe");
			driver=new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
	/**
	 * Method to get timeunit sleep
	 * @param timeout
	 * @throws InterruptedException
	 */
	public static void sleep(int timeout) throws InterruptedException
	{
		TimeUnit.SECONDS.sleep(timeout);
	}
	/**
	 * To close the browser
	 */
	public void quit()
	{
		driver.quit();
	}
}
