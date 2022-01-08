package com.application.tests;



import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.application.page.InputsPage;
import com.application.page.LoginPage;
import com.application.util.AppConstants;
import com.application.util.Credentials;
import com.application.util.ExcelUtil;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

public class InputsPageTest extends BaseTest{
	
	

	LoginPage loginPage;
	Credentials credential;
	InputsPage inputPage;

	
	
	@Test(priority=1, enabled=false, groups = { "sanity", "smoke", "regression" })
	public void checPageTitle() {
		loginPage= new LoginPage(getDriver());
		inputPage=loginPage.doInputsPageNav();
		
		
		credential= new Credentials(prop.getProperty("name"), 
				prop.getProperty("pass"));
		System.out.println("running method inside inputs----- " + this.getClass().getName());
		String pageTitle=inputPage.getPageTitle();
		Assert.assertEquals(pageTitle, AppConstants.INPUTS_PAGE_TITLE);
	}
	
	
	@Test(priority=2, description = "Verify the page header of the INPUT Screen", enabled=false)
	public void checkPageHeder() {
		
		loginPage= new LoginPage(getDriver());
		inputPage=loginPage.doInputsPageNav();
		
		
		credential= new Credentials(prop.getProperty("name"), 
				prop.getProperty("pass"));
		String pageHeader=inputPage.getPageHeader();
		//Assert.assertEquals(pageHeader, AppConstants.INPUTS_PAGE_HEADER);
		Assert.assertTrue(false);
	}

	
	@DataProvider
	public Object[][] dataForInputField(){
		Object[][] obj=ExcelUtil.readDataFromExcelSheet("inputSheet");
		//Object[][] obj = {{"5"}, {"3"}, {"3"}};
		return obj;
	}
	
	@Test(priority=3, dataProvider="dataForInputField", enabled=false)
	@Epic("testing epics")
	@Feature("feature name- testing feature")
	public void eneterInputsAsNumber(String numberInput) throws InterruptedException {
		loginPage= new LoginPage(getDriver());
		inputPage=loginPage.doInputsPageNav();
		
		
		credential= new Credentials(prop.getProperty("name"), 
				prop.getProperty("pass"));
		
		inputPage.enterNumber(numberInput);
	}
	
	@Test
	public void dataForInputField1(){
		
		Object[][] obj=ExcelUtil.readDataFromExcelSheetToCompare("inputSheet");
		System.out.println("completed ");
		//Object[][] obj = {{"5"}, {"3"}, {"3"}};
	}


}
