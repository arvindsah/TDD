package com.application.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.application.page.HomePage;
import com.application.page.LoginPage;
import com.application.util.AppConstants;
import com.application.util.Credentials;


/**
 * 
 * @author Arvind
 *
 */
public class LoginPageTest  extends BaseTest{

	LoginPage loginPage;
	Credentials credential;
	String browserName;
	
	
	
	@Test(priority = 1, enabled =true)
	public void verifyTitleOfPage() {
		loginPage= new LoginPage(getDriver());
		credential= new Credentials(prop.getProperty("name"), 
				prop.getProperty("pass"));
		
		String pageTitle=loginPage.getPageTitle();
		System.out.println("Title of the Login page : "+pageTitle);
		//Assert.assertEquals(pageTitle, "Amway India");
		Assert.assertEquals(pageTitle, AppConstants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority = 2, enabled=true)
	public void verifyABLinkPresent() {
		loginPage= new LoginPage(getDriver());
		credential= new Credentials(prop.getProperty("name"), 
				prop.getProperty("pass"));
		
		boolean abLinkPresent=loginPage.checkABTestingLink();
		System.out.println("AB link present : "+abLinkPresent);
		Assert.assertTrue(abLinkPresent);
		//Assert.assertEquals(abLinkPresent, true);
	}
	
	
	/**
	 * this methoed will help you naviagte to home page
	 * if required get the logged user name 
	 * which is displayed at home from prop file
	 * 
	 */
	@Test(priority = 3, enabled=true)
	public void homePageNav() {
		loginPage= new LoginPage(getDriver());
		credential= new Credentials(prop.getProperty("name"), 
				prop.getProperty("pass"));
		
		
		HomePage homePage=loginPage.doHomePageNav(credential);
		String homePageTile=homePage.getHomePageTitle();
		System.out.println("Home page title is :" +homePageTile);
		Assert.assertEquals(homePageTile, AppConstants.HOME_PAGE_TITLE);
	}
	
	@DataProvider
	public Object[][] getinvalidLoginCred() {
		
		Object obj[][] = {
				{"login1","pass1"},
				{"login2","pass2"},
				{"login3","pass3"}
		};
		
		return obj;
	}
	
	@Test(priority=4, dataProvider = "getinvalidLoginCred", enabled=true)
	public void invalidLoginTest(String username, String pass) {
		loginPage= new LoginPage(getDriver());
		credential= new Credentials(prop.getProperty("name"), 
				prop.getProperty("pass"));
		
		credential.setName(username);
		credential.setPassword(pass);
		
		HomePage homePage=loginPage.doHomePageNav(credential);
		String homePageTile=homePage.getHomePageTitle();
		System.out.println("Home page title is :" +homePageTile);
		Assert.assertEquals(homePageTile, AppConstants.HOME_PAGE_TITLE);
				
	}
	
	
	@Test(priority=5, enabled=true)
	public void verifyPageTitle()
	{
		loginPage= new LoginPage(getDriver());
		credential= new Credentials(prop.getProperty("name"), 
				prop.getProperty("pass"));
		
		String pageTitle= loginPage.getPageTitleUsingJS();
		System.out.println("page title using JS :"+pageTitle );
		Assert.assertEquals(pageTitle, AppConstants.LOGIN_PAGE_TITLE);
	}
	
}
