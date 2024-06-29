package com.OrangeHRM.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop = new Properties();
	
	public ReadConfig() {
		File source = new File("./Configurations/Config.properties");
		
		try {
			FileInputStream fip = new FileInputStream(source);
			prop.load(fip);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		
	}
	public String gettestautourl() {
		String testurl = prop.getProperty("testautomationurl");
		return testurl;
	}
	
	public String getapprul() {
		String url = prop.getProperty("baseurl");
		return url;
	}
	public String getusername() {
		String username = prop.getProperty("username");
		return username;
	}
	public String getpassword() {
		String password = prop.getProperty("password");
		return password;
	}
	public String getchromepath() {
		String chromepath = prop.getProperty("Chromepath");
		return chromepath;
	}
	public String getfirefoxpath() {
		String firefoxpath = prop.getProperty("Firefoxpath");
		return firefoxpath;
	}
	public String getedgepath() {
		String edgepath = prop.getProperty("Edgepath");
		return edgepath;
	}


}
