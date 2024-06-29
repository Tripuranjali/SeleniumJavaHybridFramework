package com.OrangeHRM.TestCases;

import org.testng.annotations.Test;

import com.OrangeHRM.PageObjects.AdminPage;

public class TC_02 extends BaseClass {
	
	@Test
	public void HandlingWebTable() throws Exception {
		AdminPage ap = new AdminPage(driver);
		TC_01 tc = new TC_01();
		tc.LoginTestVerification();
		ap.clickadmin();
		Thread.sleep(3000);
		ap.scrolltorecordfound();
		captureScreen(driver, "HandlingWebTable");
		Thread.sleep(3000);
		ap.readdatafromtable();
		
		
	}
	


}
