package com.application.tests;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.application.page.HomePage;
import com.application.page.LoginPage;
import com.application.util.Credentials;

public class HomePageTest extends BaseTest{
	
	LoginPage loginPage;
	HomePage homePage;



	@Test(priority = 1)
	public void verifyHomePageTitle() {
		loginPage = new LoginPage(getDriver());
		credential= new Credentials(prop.getProperty("name"), 
				prop.getProperty("pass"));
		homePage = loginPage.doHomePageNav(credential);
		String title = homePage.getHomePageTitle();
		System.out.println("Home page Title is : " + title);
		Assert.assertEquals(title, "The Internet");

	}

	@Test(priority = 2)
	public void verifyHeaderTitle() {
		loginPage = new LoginPage(getDriver());
		credential= new Credentials(prop.getProperty("name"), 
				prop.getProperty("pass"));
		homePage = loginPage.doHomePageNav(credential);
		String headerText = homePage.getHeaderText();
		System.out.println("Header Text is : " + headerText);
		//Assert.assertEquals(headerText, "A/B Test Control");
		homePage.getHeaderText();
 
	}


}
