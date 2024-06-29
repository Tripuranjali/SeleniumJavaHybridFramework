package com.OrangeHRM.TestCases;

import org.testng.annotations.Test;

import com.OrangeHRM.PageObjects.AddAdminPage;


public class TC_03 extends BaseClass {
	@Test
	public void HandlingBootstrapdropdown() throws Exception {
		AddAdminPage adp = new AddAdminPage(driver);
		TC_01 tc = new TC_01();
		tc.LoginTestVerification();
		Thread.sleep(3000);
		adp.clickadminpage();
		adp.AddAdminClick();		
		adp.ArrowDropdownclick();
		Thread.sleep(2000);
		adp.selectoptionrole();
		Thread.sleep(2000);
		adp.empname("A");
		Thread.sleep(3000);
		adp.selectempname();
		Thread.sleep(1000);
		adp.ArrowDropdownclicktwo();
		Thread.sleep(2000);
		adp.selectoptionstatus();
		adp.setusernameadmin();
		adp.setpasswordadmin("Anjali@2701#");
		adp.setpasswordconfirmadmin("Anjali@2701#");
		adp.clicksavebutton();
		Thread.sleep(3000);
		captureScreen(driver, "HandlingBootstrapdropdown");
		
		
		
		
	}
	
	
	

}
