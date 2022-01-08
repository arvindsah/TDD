package com.application.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.application.base.BasePage;

public class TestParallel extends BaseTest{
	
	@Test
	public void test1() throws InterruptedException {
		WebDriver driver=getDriver();
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		System.out.println("Test Case One with Thread Id:- "
				+ Thread.currentThread().getId());
		
		Thread.sleep(5000l);
	}
	
	@Test
	public void test2() throws InterruptedException{
		WebDriver driver=getDriver();
		driver.get("https://www.linkedin.com/messaging/thread/6631317547700584448/");
		System.out.println(BasePage.getDriver().getTitle());
		System.out.println("Test Case One with Thread Id:- "
				+ Thread.currentThread().getId());
		Thread.sleep(5000l);
	}
	@Test
	public void test3() throws InterruptedException{
		WebDriver driver=getDriver();
		driver.get("https://www.youtube.com/");
		
		System.out.println("Test Case One with Thread Id:- "
				+ Thread.currentThread().getId());
		Thread.sleep(5000l);
	}
	@Test
	public void test4() throws InterruptedException{
		WebDriver driver=getDriver();
		driver.get("https://www.swtestacademy.com/local-parallel-testing-selenium/");
		
		System.out.println("Test Case One with Thread Id:- "
				+ Thread.currentThread().getId());
		Thread.sleep(5000l);
	}
	@Test
	public void test5() throws InterruptedException{
		WebDriver driver=getDriver();
		driver.get("https://martinfowler.com/bliki/PageObject.html");
		driver.get("https://github.com/naveenanimation20/March2020POMSeries/blob/master/Jenkinsfile");
		System.out.println("Test Case One with Thread Id:- "
				+ Thread.currentThread().getId());
		Thread.sleep(5000l);
	}
	@Test
	public void test6() throws InterruptedException{
		WebDriver driver=getDriver();
		System.out.println("Test Case One with Thread Id:- "
				+ Thread.currentThread().getId());
		Thread.sleep(5000l);
	}
	

}
