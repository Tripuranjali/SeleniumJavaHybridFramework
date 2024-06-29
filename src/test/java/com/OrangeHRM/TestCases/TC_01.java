package com.OrangeHRM.TestCases;

import org.testng.annotations.Test;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.OrangeHRM.PageObjects.LoginPage;



public class TC_01 extends BaseClass {
	
	@Test
	public void LoginTestVerification() throws Exception {
		
		driver.get(baseurl);
		LoginPage lp = new LoginPage(driver);
		logger.info("URL Opened");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOf(lp.));
		
		lp.setusername(username);
		logger.info("Username Entered");
		lp.setpassword(password);
		logger.info("Password Entered");
		lp.clicklogin();
		logger.info("Clicked Login");
		Thread.sleep(3000);
		
		if(driver.getTitle().equals("OrangeHRM")) {
			logger.info("Title Verified");
			Assert.assertTrue(true);
			captureScreen(driver, "LoginTestVerification");
			
		}else {
			logger.info("Title NOT Verified");
			Assert.assertFalse(false);
			captureScreen(driver, "LoginTestVerification");
			
		}
		

		
		
	
		
	}

}
