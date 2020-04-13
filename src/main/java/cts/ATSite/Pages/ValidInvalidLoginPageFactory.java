package cts.ATSite.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 *class to check valid and invalid details
 */ 
public class ValidInvalidLoginPageFactory {
	/**
	 *locating myaccount
	 */ 
	@FindBy(xpath="/html/body/div[1]/div[1]/header/div[2]/nav/ul/li[2]/a")
	public WebElement my;
	/**
	 *locating email
	 */ 
	@FindBy(id="username")
	public WebElement email;
	/**
	 *locating password
	 */ 
	@FindBy(xpath="/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/div[1]/form/p[2]/input")
	public WebElement password;
	/** 
	 *locating login
	 */ 
	@FindBy(name="login")
	public WebElement login;
	/**
	 *locating invalid details
	 */ 
	@FindBy(xpath="/html/body/div[1]/div[2]/div/div/div/div/div[1]/ul/li")
	public WebElement invalid;
	/**
	 *method to click my account
	 */ 
	public void account() {
		my.click();
	}
	/**
	 *method to take username and password
	 */ 
	public void details(String[] data) {
		email.sendKeys(data[0]);
		password.sendKeys(data[1]);
	}
	/**
	 *method for login
	 */ 
	public void login() {
		login.click();
	}
	/**
	 *method for invalid
	 */ 
	public String invalid() {
		String str=invalid.getText();
		return str;
	}



}

