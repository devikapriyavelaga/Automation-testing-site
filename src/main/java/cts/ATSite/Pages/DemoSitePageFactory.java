package cts.ATSite.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 *class for opening demosite
 */
public class DemoSitePageFactory {
	/**
	 *locating demo
	 */
	@FindBy(xpath="/html/body/div[1]/div[1]/header/div[2]/nav/ul/li[5]/a")
	public WebElement demo;
	/**
	 *locating firstname
	 */
	@FindBy(xpath="/html/body/section/div/div/div[2]/form/div[1]/div[1]/input")
	public WebElement firstName;
	/**
	 *locating lastname
	 */
	@FindBy(xpath="/html/body/section/div/div/div[2]/form/div[1]/div[2]/input")
	public WebElement lastName;
	/**
	 *locating email
	 */
	@FindBy(xpath="/html/body/section/div/div/div[2]/form/div[3]/div[1]/input")
	public WebElement email;
	/**
	 *locating phone number
	 */
	@FindBy(xpath="/html/body/section/div/div/div[2]/form/div[4]/div/input")
	public WebElement phone;
	/**
	 *locating gender radio button 
	 */
	@FindBy(xpath="//label[2]//input[1]")
	public WebElement gender;
	/**
	 *locating country
	 */
	@FindBy(id="countries")
	public WebElement country;
	/**
	 *locating year
	 */
	@FindBy(id="yearbox")
	public WebElement year;
	/**
	 *locating month
	 */
	@FindBy(xpath="/html[1]/body[1]/section[1]/div[1]/div[1]/div[2]/form[1]/div[11]/div[2]/select[1]")
	public WebElement month;
	/**
	 *locating date
	 */
	@FindBy(id="daybox")
	public WebElement date;
	/**
	 *locating password
	 */
	@FindBy(xpath="/html/body/section/div/div/div[2]/form/div[12]/div/input")
	public WebElement pwd;
	/**
	 *locating confirm password
	 */
	@FindBy(xpath="/html/body/section/div/div/div[2]/form/div[13]/div/input")
	public WebElement cpwd;
	/**
	 *locating submit button
	 */
	@FindBy(xpath="/html/body/section/div/div/div[2]/form/div[14]/div/button[1]")
	public WebElement submit;
	/**
	 *method to click account
	 */ 
	public void account() {
		demo.click();
	}
	/**
	 *method to take test into textbox
	 */ 
	public void details(String[] data) {
		firstName.sendKeys(data[0]);
		lastName.sendKeys(data[1]);
		email.sendKeys(data[2]);
		phone.sendKeys(data[3]);
		gender.click();
		Select coun = new Select(country);
		coun.selectByVisibleText(data[4]);

		Select yea = new Select(year);
		yea.selectByVisibleText(data[5]);

		Select da = new Select(month);
		da.selectByVisibleText(data[6]);

		Select dat = new Select(date);
		dat.selectByVisibleText(data[7]);
		pwd.sendKeys(data[8]);
		cpwd.sendKeys(data[8]);
	}
	/**
	 *submit button
	 */ 
	public void submit() {
		submit.click();
	}


}




