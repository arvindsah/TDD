package com.application.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.application.base.BasePage;
import com.application.page.HomePage;
import com.application.page.LoginPage;
import com.application.util.Credentials;

public class BaseTest {
	BasePage basePage;
	Properties prop;
	//WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	Credentials credential ;
	

	@BeforeMethod(alwaysRun = true)
	@Parameters(value = { "browser" })
	public  void setup(@Optional String browser) {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browserName = null;

		if (browser== null) {
			browserName = prop.getProperty("browser");
		} else {
			browserName = browser;
		}

		String url = prop.getProperty("url");
		WebDriver driver = basePage.init_driver(browserName);
		driver.get(url);
		System.out.println("starting browser instance" +  driver.toString() +"-----------"+ Thread.currentThread().getId());
	}
	

	protected WebDriver getDriver() {
		return BasePage.getDriver();
	}
	@AfterMethod
	public void tearDown() {
		System.out.println("closing browser instance" +  BasePage.getDriver().toString()+"++++++++++++" + Thread.currentThread().getId());
		getDriver().quit();
	}
}
