package com.application.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.application.base.BasePage;

public class TestParallel2 extends BaseTest{

	//WebDriver driver;
	
	@Test
	public void test1(){
		WebDriver driver=BasePage.getDriver();
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
	}
	
	@Test
	public void test2(){
		WebDriver driver=BasePage.getDriver();
	//	driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
	}
	
	
	@Test()
	public void test3(){
		WebDriver driver=BasePage.getDriver();
		driver.get("https://www.linkedin.com/messaging/thread/6631317547700584448/");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
	}
	
	
	@Test()
	public void test4(){
		WebDriver driver=BasePage.getDriver();
		driver.get("https://www.youtube.com/");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
	}
}
