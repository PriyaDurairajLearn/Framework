package com.POMProject.Test;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.POMProject.Utilities.BrowserFactory;
import com.POMProject.Utilities.CaptureScreenshot;
import com.POMProject.Utilities.ConfigDataProvider;
import com.POMProject.Utilities.ExcelDataConfig;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
WebDriver driver;
ConfigDataProvider config;
ExcelDataConfig excel;
ExtentReports report;
ExtentTest logger;

	@BeforeSuite
	public void setUpA()
	{
	Reporter.log("Setting up the System Variabes",true);
	config=new ConfigDataProvider();
	excel=new ExcelDataConfig();
	ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM.html"));
	report=new ExtentReports();
	report.attachReporter(extent);
	
	}
	
	@BeforeMethod
	public void startApplication()
	{
		driver=BrowserFactory.startApp(driver, config.getBrowser(),config.getAppURL());
		Reporter.log("Starting the Application");
	}
	
	@AfterMethod
	public void quitBrowser(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			//CaptureScreenshot.CapturSS(driver, result.getName());
			try {
				logger.fail("Failed", MediaEntityBuilder.createScreenCaptureFromPath(CaptureScreenshot.CapturSS(driver, result.getName())).build());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}else if(result.getStatus()==ITestResult.SUCCESS)
		{
			try {
				logger.pass("Passed", MediaEntityBuilder.createScreenCaptureFromPath(CaptureScreenshot.CapturSS(driver, result.getName())).build());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		report.flush();
		BrowserFactory.closeApp(driver);
	}

}
