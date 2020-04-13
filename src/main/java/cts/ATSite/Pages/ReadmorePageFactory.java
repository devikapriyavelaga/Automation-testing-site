package cts.ATSite.Pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 *class to readmore about testcases
 */ 
public class ReadmorePageFactory {
	/**
	 *locating shop button
	 */ 
	@FindBy(xpath="/html/body/div[1]/div[1]/header/div[2]/nav/ul/li[1]/a")
	public WebElement cshop;

	/**
	 *method to click shop
	 */ 
	public void Shopp() {
		cshop.click();
	}


}
