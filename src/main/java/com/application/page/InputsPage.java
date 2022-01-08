package com.application.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.application.base.BasePage;
import com.application.util.ElementUtil;
import com.application.util.JSUtil;

public class InputsPage extends BasePage{
	WebDriver driver;
	ElementUtil elementUtil;
	JSUtil jsUtil;
	
	//create all the locator using By technique
	By INPUTS_header = By.xpath("//h3[contains(text(),'Inputs')]");
	By Input_number_field = By.xpath("//div[@class='example']//input");

	public InputsPage(WebDriver driver) {
		this.driver= driver;
		elementUtil=new ElementUtil(driver) ;
		jsUtil= new JSUtil(driver);
	}
	
	public String getPageTitle()
	{
		return elementUtil.doGetPageTitle();
	}
	
	public String getPageHeader() {
		return elementUtil.doGetText(INPUTS_header);
	}
	
	public void enterNumber(String number) {
		 elementUtil.doSentKeys(Input_number_field, number);
	}
	
}
			