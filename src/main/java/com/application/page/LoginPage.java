package com.application.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.application.base.BasePage;
import com.application.util.AppConstants;
import com.application.util.Credentials;
import com.application.util.ElementUtil;
import com.application.util.JSUtil;

public class LoginPage extends BasePage{
	WebDriver driver;
	ElementUtil elementUtil;
	JSUtil jsUtil;
	
	//create all the locator using By technique
	By AB_Testing = By.xpath("//a[@href='/abtest']");
	By AddRemoveElemnt = By.linkText("Add/Remove Elements");
	By InputsLink = By.xpath(("//a[contains(text(),'Inputs')]"));
	


	public LoginPage(WebDriver driver) {
		this.driver= driver;
		elementUtil=new ElementUtil(driver) ;
		jsUtil= new JSUtil(driver);
	}
	
	// Page actions
	
	public String getPageTitle() {
		elementUtil.waitForTitlePresent(AppConstants.LOGIN_PAGE_TITLE);
		return elementUtil.doGetPageTitle();
	}
	
	public String getPageTitleUsingJS() {
		return jsUtil.getTitleByJS();
	}
	
	public boolean checkABTestingLink() {
		//return driver.findElement(AB_Testing).isDisplayed();
		return elementUtil.doIsDisplayed(AB_Testing);
	}
	
	// return the home page reference when called
	
	public HomePage doHomePageNav( Credentials credentails) {
		System.out.println("username : "+credentails.getName());
		System.out.println("password : " +credentails.getPassword());
		
		elementUtil.doPageLoadTimeout(10);
		elementUtil.doClick(AB_Testing);
//		driver.findElement(AB_Testing).click();
				return new HomePage(driver);
	}

	public boolean checkLoginErrorMessage() {
		//elementUtil.doIsDisplayed(locator);
		return true;
	}


	public InputsPage doInputsPageNav() {
		elementUtil.doMoveToElement(InputsLink);
		elementUtil.doClick(InputsLink);
		return new InputsPage(driver);
	}
	
	
}
