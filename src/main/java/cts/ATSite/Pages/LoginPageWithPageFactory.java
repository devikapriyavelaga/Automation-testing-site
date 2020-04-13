package cts.ATSite.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
/**
 *class for opening loginpage
 */ 
public class LoginPageWithPageFactory {
	WebDriver driver;
	/**
	 *locating myaccount
	 */ 
    @FindBy(how=How.XPATH,using="//a[contains(text(),'My Account')]")
	@CacheLookup
	WebElement myaccount;
    /**
	 *locating username
	 */ 
	@FindBy(how=How.ID,using="username")
	@CacheLookup
	WebElement username;
	/**
	 *locating password
	 */ 
	@FindBy(how=How.ID,using="password")
	@CacheLookup
	WebElement password;
	/**
	 *locating submit button
	 */ 
	@FindBy(how=How.XPATH,using="//input[@name='login']")
	@CacheLookup
	WebElement login;
	/**
	 *locating add to basket
	 */ 
	@FindBy(how=How.XPATH,using="//li[3]//a[2]")
	@CacheLookup
	WebElement addtobasket;
	/**
	 *locating proceed to checkout
	 */ 
	@FindBy(how=How.XPATH,using="//a[@class='checkout-button button alt wc-forward']")
	@CacheLookup
	WebElement proceedcheckout;
	/**
	 *locating place order button
	 */ 
	@FindBy(how=How.ID,using="place_order")
	@CacheLookup
	WebElement placeorder;
	/**
	 *method to open loginpage
	 */ 
	public LoginPageWithPageFactory(WebDriver driver) {
		this.driver=driver;
	}
	/**
	 * method to take username and password
	 */ 
	public void userlogin(String userid,String pass) {
		username.sendKeys(userid);
		password.sendKeys(pass);
	}
	/**
	 *method to click button
	 */ 
	public void clickOnLoginButton() {
		login.click();
	}
	/**
	 *method to click opencart
	 */ 
	public void opencart() {
		addtobasket.click();
	}
	/**
	 *method to checkout
	 */ 
	public void checkout() {

		driver.navigate().to("http://practice.automationtesting.in/basket/");
		proceedcheckout.click();


	}

}