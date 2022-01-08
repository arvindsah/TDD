package com.application.base;

import java.util.Collections;
import java.util.Properties;


import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {

	public ChromeOptions co;
	public FirefoxOptions fo;
	public Properties prop;

	public OptionsManager(Properties prop) {
		this.prop=prop;
		}
	
	public ChromeOptions getChromeOptions() {
		
			// silent chrome driver logs
			//System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			//OR
			System.setProperty("webdriver.chrome.silentOutput", "true");
			co = new ChromeOptions();
			
			co.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			co.setExperimentalOption("useAutomationExtension", false);
			
			if(prop.getProperty("incognito").equals("true")) {co.addArguments("--incognito");}
			if(prop.getProperty("headless").equals("true")) {co.addArguments("--headless");}
			
			
			//co.addArguments("--log-level=3");
			//System.setProperty("webdriver.chrome.args", "--disable-logging");
			//System.setProperty("webdriver.chrome.logfile", System.getProperty("user.dir") + "/chromedriver.log");
			//System.setProperty("webdriver.chrome.verboseLogging", "true");
			
			return co;
		}
	
	public FirefoxOptions getFirefoxOptions() {
		 fo = new FirefoxOptions();
		 if(prop.getProperty("incognito").equals("true")) fo.addArguments("--incognito");
     	 if(prop.getProperty("headless").equals("true")) fo.addArguments("--headless");
     	 return fo;
		}
	
}
