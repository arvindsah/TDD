package com.application.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.application.base.BasePage;
import com.application.util.ElementUtil;

public class HomePage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil=new ElementUtil(driver) ;

	}

	By headerValue = By.xpath("//h3[text()='A/B Test Control']");
	By PoweredByLinkTest = By.linkText("Elemental Selenium");

	public String getHeaderText() 
	{
		//return driver.findElement(headerValue).getText();
		elementUtil.doPageLoadTimeout(5);
		return elementUtil.doGetText(headerValue);
	}

	public String getPoweredBylinkTest() 
	{
		//return driver.findElement(PoweredByLinkTest).getText();
		return elementUtil.doGetText(PoweredByLinkTest);
	}

	public String getHomePageTitle() 
	{
		//return driver.getTitle();
		return elementUtil.doGetPageTitle();
	}
}
