package com.application.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BasePage {
	
	//intilize the driver and prop
	
	//public WebDriver driver;
	Properties prop;
	public static boolean highlightElement; 
	OptionsManager optionsManager;
	
	
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}
	
	
	
	public WebDriver init_driver(String browerName) {
		
		System.out.println("browser name is : " + browerName);
	
		highlightElement = prop.getProperty("highlight").equals("true") ? true : false;
		optionsManager= new OptionsManager(prop);
		
		switch(browerName.toLowerCase()) {
		
		case "chrome" :
			System.out.println("Chrome browser will start");
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
			break;
			
		case "firefox" :
			System.out.println("Firefox browser will start");
			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
			break;
			
		case "Edge" :
			System.out.println("Edge browser will start");
			WebDriverManager.edgedriver().setup();
			tldriver.set(new EdgeDriver());
			break;
			
		default:
				System.out.println("browser name : " + browerName + " not found");
				System.exit(0);
				//throw new RuntimeException("Unsupported browser");
		}
		
		

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		// driver.get(url);
		return getDriver();

	}

	
	public Properties init_properties() {
		prop= new Properties();
		//String path= ".\\src\\main\\java\\com\\application\\config\\config.properties";
		String env=null;
		String path=null;
		
		try {
			env=System.getProperty("env");
			if(env.equals("qa"))
			{
				path=".\\src\\main\\java\\com\\application\\config\\config.qa.properties";
			}
		}
		catch(Exception e)
		{
			path=".\\src\\main\\java\\com\\application\\config\\config.properties";
		}
		
		try {
			FileInputStream fileInputStream= new FileInputStream(path);
			prop.load(fileInputStream);
		} catch (FileNotFoundException e) {
			System.out.println("unable to read config properies");
		} catch (IOException e) {
			System.out.println("unable to load properties file");
		}
		return prop;
	}
	

	public String getScreenshot() {
		
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		
		//String path = System.getProperty("user.dir")+ "/screenshots/" + getTime(System.currentTimeMillis())+ ".png";
		System.out.println(getTime(System.currentTimeMillis()));
		String path = System.getProperty("user.dir")+ "/screenshots/" + System.currentTimeMillis()+ ".png";
		File destination = new File(path);
		
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			System.err.println("screenshot captured failed...");
		}
		
		return path;
	}

	
	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
}
