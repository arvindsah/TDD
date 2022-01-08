package com.automation.practice;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinksTesting {

	public static void main(String[] args) throws MalformedURLException, Exception {

		 String homePage = "https://www.fqa.amway.in/";
		//String homePage = "https://www.youtube.com/";
		String url = "";
		HttpURLConnection huc = null;
		int respCode = 200;
		System.setProperty("https.protocols", "SSLv3,TLSv1,TLSv1.1,TLSv1.2");
		SSLContext.getInstance("TLSv1.2");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.fqa.amway.in/");
		//driver.get("https://www.youtube.com/");
		// Thread.sleep(5000l);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		WebElement footerElement=driver.findElement(By.cssSelector("div.footer-container"));

		List<WebElement> links = footerElement.findElements(By.tagName("a"));

		System.out.println(links.size());

		Iterator<WebElement> it = links.iterator();
		int i = 0;
		WebElement element;
		 while (it.hasNext()) {
		//while (i < 1) {

			i++;
			element=it.next();
			System.out.print(element.getText() + " --- ");
			url = element.getAttribute("href");
			
			System.out.print(url +" -- ");

			if (url == null || url.isEmpty()) {
				System.out.println("URL is either not configured for anchor tag or it is empty");
				continue;
			}

			if (!url.startsWith(homePage)) {
				System.out.println("URL belongs to another domain, skipping it.");
				continue;
			}

			System.out.println("Response - "+isLinkBroken(new URL(url)));
			/*
			 * try {
			 * 
			 * huc = (HttpURLConnection) (new URL(url).openConnection());
			 * 
			 * huc.setRequestMethod("HEAD");
			 * 
			 * huc.connect();
			 * 
			 * respCode = huc.getResponseCode();
			 * 
			 * if (respCode >= 400) { System.out.println(url + " is a broken link"); } else
			 * { System.out.println(url + " is a valid link"); }
			 * 
			 * } catch (MalformedURLException e) { // 
			 * e.printStackTrace(); } catch (IOException e) {
			 * block e.printStackTrace(); }
			 */

		}
		driver.quit();

	}

	public static String isLinkBroken(URL url) throws Exception

	{
		String response = "";
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		try	{
			
			
			/*ProviderList providerList = Providers.getProviderList();
		    GetInstance.Instance instance = GetInstance.getInstance("SSLContext", SSLContextSpi.class, "TLS");
		    for (Provider provider : providerList.providers())
		    {
		        if (provider == instance.provider)
		        {
		            provider.put("Alg.Alias.SSLContext.TLS", "TLSv1.2");
		        }
		    }*/


		try {
		        SSLContext ctx = SSLContext.getInstance("TLSv1.2");
		        ctx.init(null, null, null);
		        SSLContext.setDefault(ctx);
		} catch (Exception e) {
		        System.out.println(e.getMessage());
		}
				
			
			
			connection.connect();
			System.out.print(connection.getResponseCode() + " --- ");
			response = connection.getResponseMessage();

			connection.disconnect();

			return response;

		}

		catch (Exception exp)

		{
			return exp.getMessage();

		}

	}

}
