package com.automation.practice;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.util.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShotBase64 {

	@SuppressWarnings("unused")
	public static void captureScreenshot(String TCName, String TSID) throws IOException, InterruptedException
	   {
	        TakesScreenshot driver =  new ChromeDriver();
			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File screenshotLocation = new File(System.getProperty("user.dir")+"\\screenshots+TCName"+"_"+TSID+".png");
	     FileUtils.copyFile(screenshot, screenshotLocation);
	     Thread.sleep(2000);
	     InputStream is = new FileInputStream(screenshotLocation);
	     byte[] imageBytes = IOUtils.toByteArray(is);
	     Thread.sleep(2000);
	     
		String base64 = Base64.getEncoder().encodeToString(imageBytes);
	     //Extent.log(LogStatus.INFO, "Snapshot below: " + extent.addBase64ScreenShot("data:image/png;base64,"+base64));       
	   }
	
	
	public String captureToBase64() {

	    Rectangle screenSize = new 
	    Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	    BufferedImage screenCapture = null;
	    String base64Encoded = "";

	    try {

	        screenCapture = new Robot().createScreenCapture(screenSize);
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        ImageIO.write(screenCapture, "jpg", baos);
	        baos.flush();
	       // byte[] encodeBase64 = Base64.encodeBase64(baos.toByteArray());
	        //base64Encoded = new String(encodeBase64);
	        baos.close();

	    } catch (AWTException e) {
	        e.getMessage();
	    } catch (IOException e) {
			e.printStackTrace();
		}

	    return base64Encoded;
	}
}
