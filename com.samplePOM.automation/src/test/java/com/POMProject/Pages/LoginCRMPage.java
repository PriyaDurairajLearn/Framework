package com.POMProject.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginCRMPage {
	
	WebDriver driver;
	

	public LoginCRMPage(WebDriver ldriver)
	{
	this.driver=ldriver;	
	}
	
	//@FindBy(xpath="//span[contains(text(),'Log In')]") WebElement username;
	@FindBy(xpath="//span[contains(text(),'Log In')]") WebElement first_Login;
	@FindBy(xpath="//input[@placeholder='E-mail address']") WebElement username;
	@FindBy(xpath="//input[@placeholder='Password']") WebElement password;
	@FindBy(xpath="//div[@class='ui fluid large blue submit button'][contains(text(),'Login')]") WebElement login_button;
	@FindBy(xpath="//div[contains(text(),'wrong')]") WebElement error1;
	@FindBy(xpath="//div[contains(text(),'Invalid')]") WebElement error2;
	@FindBy(xpath="//span[contains(text(),'Home')]") WebElement elem;
	//@FindBy(xpath="") WebElement elem2;
	
	public void loginApplication(String appUsername,String appPassword) {
		
		//first_Login.click();
		username.sendKeys(appUsername);
		password.sendKeys(appPassword);
		login_button.click();	
	}
	
	
	
	
	
}
