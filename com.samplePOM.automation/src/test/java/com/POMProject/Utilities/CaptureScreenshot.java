package com.POMProject.Utilities;

import java.io.File;
//import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class CaptureScreenshot {
	

	public static String CapturSS(WebDriver driver,String ssName) {
		
		TakesScreenshot screenShot=(TakesScreenshot)driver;
		File src=screenShot.getScreenshotAs(OutputType.FILE);
		String screenshotPath=System.getProperty("user.dir")+"/Screenshots/"+ssName+getCurrentDateTime()+".png";
		try {
			FileHandler.copy(src, new File(screenshotPath));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return screenshotPath;
	}
	
	public static String getCurrentDateTime() {
		
		DateFormat customFormat= new SimpleDateFormat();
		Date date=new Date();
		return customFormat.format(date);
	}
}
