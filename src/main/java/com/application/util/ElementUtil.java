package com.application.util;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.application.base.BasePage;

public class ElementUtil {
	
	WebDriver driver;
	WebDriverWait wait;
	JSUtil jsUtil;
	String highlghtFlag;
	Actions actions;	
	
	public ElementUtil(WebDriver driver)
	{ this.driver=driver;
	wait= new WebDriverWait(driver, AppConstants.DEFAULT_TIME_OUT);
	jsUtil=new JSUtil(driver);
	actions = new Actions(driver);  
	// lookout for some solution for webdriverwait
	//wait= new WebDriverWait(driver, AppConstants.DEFAULT_TIME_OUT);
	//new WebDriverWait(driver, (long) 20.0);
	}
	
	
	/**
	 * this method is used for creating the webElement on the 
	 * bases of By locator
	 * @param locator
	 * @return webElement
	 */
	
	public WebElement getElement(By locator)
	{
		WebElement element=null;
		try {

			//if(waitForElementPresent(locator))
			{
				element=driver.findElement(locator);
				if(BasePage.highlightElement)
				{
					//System.out.println("higlight flag value  --- "+ BasePage.highlightElement) ;
					jsUtil.flash(element);
					}
				
			}
		}
		catch(Exception e) {
			System.out.println("enable to find the webelement :" +  locator);
		}
		return element;
	}
	 
	
	public boolean waitForTitlePresent(String title) {
		//System.out.println("element located");
		wait.until(ExpectedConditions.titleIs(title));
		return true;
	}


	public boolean waitForElementPresent(By loctor) {
		//System.out.println("element located");
		wait.until(ExpectedConditions.presenceOfElementLocated(loctor));
		return true;
	}
	
	public boolean waitForElementVisibility(By loctor) {
		//System.out.println("element located");
		wait.until(ExpectedConditions.visibilityOfElementLocated(loctor));
		return true;
	}
	
	
	/**
	 * this method will return the title of the screen 
	 * @return string
	 */
	public String doGetPageTitle()
	{
		try {
		return driver.getTitle();
		}
		catch(Exception e) {
			System.out.println("enable to find the title of the page ");
		}
		return null;
	}

	
	
	


	/**
	 * this method is used to click on the webElement
	 * @param locator
	 */
	public void doClick(By locator) {
		try {
		getElement(locator).click();
		}
		catch(Exception e) {
			System.out.println("exception occured while clicking on the webElement");
		}
	}
	
	
	
	
	
	/**
	 * this method is used for sending the keys
	 * @param locator
	 * @param value
	 */
	public void doSentKeys(By locator, String value) {
		
		try{
			WebElement element=getElement(locator);
		
		element.clear();
		element.sendKeys(value);
		}
		catch(Exception e) {
			System.out.println("exception occured while sending the the keys");	
		}
	}

	
	/**
	 * 
	 * @param locator
	 * @return
	 */
	
	public boolean doIsDisplayed(By locator) {
		try{
			return getElement(locator).isDisplayed();
		}
		catch(Exception e) {
			System.out.println("exception occured while checking if webelement is displayed");	
		}
		return false;


	}
	
	
	public String doGetText(By locator) {
		try{
			return getElement(locator).getText();
		}
		catch(Exception e) {
			System.out.println("exception occured while getting the text");	
		}
		return null;
	}
	
	
	public void doPageLoadTimeout(int waitTime) {
		try{
			driver.manage().timeouts().pageLoadTimeout(waitTime, TimeUnit.SECONDS);
					}
		catch(Exception e) {
			System.out.println("exception occured while loading the page even after waiting for :" +waitTime+ " secs" );	
		}
	}

	
	//---------------------------------------------Actions class-------------------------------
	
	public void doMoveToElement(By locator) {
		
		WebElement ele=getElement(locator);
		actions.moveToElement(ele, 100, 100);
		
		if(BasePage.highlightElement)
		{
			jsUtil.scrollIntoView(ele);
			jsUtil.flash(ele);
			}
		
	}
	
}
