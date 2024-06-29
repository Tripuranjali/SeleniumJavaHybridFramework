package com.OrangeHRM.PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage {
	
	////*[@id="app"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a[1]
	
WebDriver driver;
	
	public AdminPage (WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	@FindBy(xpath="//*[@id='app']/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a[1]")
	WebElement navigateadmin;
	@FindBy(xpath="//span[contains(.,'Found')]")
	WebElement scrolltorecordsfound;
	@FindBy(xpath="//div[@class='orangehrm-container']")
	WebElement table;
	@FindBy(xpath="//div[@role='rowgroup'][2]//div[@role='row']/div[@role='cell'][2]")
	List <WebElement> rows;
	@FindBy(xpath="//div[@class='oxd-table-card'][1]//div[@class='oxd-table-cell oxd-padding-cell']")
	List <WebElement> cols;
	
	
	public void clickadmin() throws InterruptedException {
		navigateadmin.click();
		
		
	}
	
	
	public void scrolltorecordfound() {
		JavascriptExecutor je =(JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView();",scrolltorecordsfound);
		
	}
	
	public void readdatafromtable() {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		// rows = //div[@role='rowgroup'][2]//div[@role='row']
		// row group = //div[@role='rowgroup'][2]
		// 2coloum all elements = //div[@role='rowgroup'][2]//div[@role='row']/div[@role='cell'][2]
		// cols=//div[@class='oxd-table-card'][1]//div[@class='oxd-table-cell oxd-padding-cell']
		//String tabledata=findElement(By.xpath("//div[@class='oxd-table-card']["+i+"]//div[@class='oxd-table-cell oxd-padding-cell']["+j+"]")).
		int r = rows.size();
		int c= cols.size();
		for(int i=1;i<=r;i++) {
			for(int j=1;j<=c;j++) {
				String Table =wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='oxd-table-card']["+i+"]//div[@class='oxd-table-cell oxd-padding-cell']["+j+"]")))).getText();
				
				System.out.print(Table+"\t"+"\n");
							
		}
		
		
	}
		
		
	}


	
	
	
	


}
