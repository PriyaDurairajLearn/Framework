package com.POMProject.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.POMProject.Pages.LoginCRMPage;
//import com.POMProject.Utilities.BrowserFactory;





public class LoginCRMTest extends BaseClass {
	
	
	
	@Test(priority=1)
	public void loginApp()
	{
		logger=report.createTest("Login To CRM");
		LoginCRMPage loginPage=PageFactory.initElements(driver,LoginCRMPage.class );
		loginPage.loginApplication(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		logger.info("Starting Application");
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Home')]")).isDisplayed(),"Login Failed");
		System.out.println("The Page Title is "+driver.getTitle());
		logger.pass("Test Passed");
		System.out.println("Login Sucessful");
		//BrowserFactory.closeApp(driver);
	}
	@Test(priority=2)
	public void LoginWrongCredentials()
	{
		logger=report.createTest("Login To CRM with wrong Creds");
		LoginCRMPage loginPage=PageFactory.initElements(driver,LoginCRMPage.class );
		loginPage.loginApplication(excel.getStringData("Login", 1, 0), excel.getStringData("Login", 1, 1));
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'wrong')]")).isDisplayed(),"Problem exists");
		logger.info("Starting the Application");
		System.out.println("The Page Title is "+driver.getTitle());
		logger.pass("Test Failed");
		System.out.println("Login Failed");
	}
	
	

}
