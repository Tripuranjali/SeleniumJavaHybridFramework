package com.OrangeHRM.TestCases;

import org.testng.annotations.Test;

import com.OrangeHRM.PageObjects.DatePickerPage;

public class TC_04 extends BaseClass {
	
	@Test
	public void Handlingdatepicker() throws InterruptedException {
		DatePickerPage dp = new DatePickerPage(driver);
		driver.get(testautomationurl);
		Thread.sleep(1000);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		dp.iframeswitch();
		Thread.sleep(1000);
		dp.scrollthepage();						
		Thread.sleep(1000);
		dp.clickcalendar();
		Thread.sleep(1000);
		dp.datepicker("2026","April");	
		dp.selectdate("26");
		
		
		
		
	}

}
