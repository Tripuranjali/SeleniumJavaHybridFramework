package com.OrangeHRM.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	@FindBy(name="username")
	WebElement textusername;
	@FindBy(name="password")
	WebElement textpassword;
	@FindBy(xpath="//button[@type='submit']")
	WebElement SubmitLogin;
	
	public void setusername(String uname) {
		textusername.sendKeys(uname);
		
	}
	public void setpassword(String pword) {
		textpassword.sendKeys(pword);
		
	}
	public void clicklogin() {
		SubmitLogin.click();
		
	}
	
	
	

}
