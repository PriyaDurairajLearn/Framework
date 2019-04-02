package com.POMProject.Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import com.POMProject.Utilities.ConfigDataProvider;



public class BrowserFactory {

	WebDriver driver;
	
	public static WebDriver startApp(WebDriver driver,String appBrowser,String appURL)
	{
		if(appBrowser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(appBrowser.equalsIgnoreCase("FireFox"))
		{
			System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(appURL);
		
		return driver;
	}
	public static void closeApp(WebDriver driver) 
	{
		driver.quit();	
	}
	
}
