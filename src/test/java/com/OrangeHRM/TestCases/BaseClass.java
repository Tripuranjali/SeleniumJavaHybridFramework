package com.OrangeHRM.TestCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.OrangeHRM.Utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig rd = new ReadConfig();
	
	public String baseurl=rd.getapprul();
	public String testautomationurl=rd.gettestautourl();
	public String username=rd.getusername();
	public String password=rd.getpassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String brow) {
		//ChromeOptions op = new ChromeOptions();
		//op.setAcceptInsecureCerts(true);

		logger = Logger.getLogger("SeleniumJavaHybridProject");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(brow.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", rd.getchromepath());
			driver = new ChromeDriver();
			
		} else if (brow.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", rd.getfirefoxpath());
			driver = new FirefoxDriver();
			
		} else if(brow.equalsIgnoreCase("msedge")) {
			System.setProperty("webdriver.msedge.driver", rd.getedgepath());
			driver = new EdgeDriver();
			
		}
	}
	

	
	public static String captureScreen(WebDriver driver, String tname) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destination =System.getProperty("user.dir")+"/ScreenShots/"+tname+".png";
		File Finaldestination = new File(destination);
		FileUtils.copyFile(source, Finaldestination);
		return destination;
	}

}
