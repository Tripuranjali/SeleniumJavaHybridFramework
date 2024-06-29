package com.OrangeHRM.PageObjects;

import java.time.Duration;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddAdminPage {
	
	// //div[@class='oxd-select-option']
	// (//div[@class='oxd-select-text--after'])[2]
	// //button[@class='oxd-button oxd-button--medium oxd-button--secondary']
	WebDriver driver;
	
	public AddAdminPage (WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@id='app']/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a[1]")
	WebElement navigateadmin;
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement AddAdmin;
	@FindBy(xpath="(//div[@class='oxd-select-text--after'])[1]")
	WebElement ArrowDropdown;
	@FindBy(xpath="//div[@class='oxd-select-option']")
	List<WebElement> elements;
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	WebElement Empname;
	@FindBy(xpath="//div[@role='option']")
	List<WebElement> empnames;
	@FindBy(xpath="(//div[@class='oxd-select-text--after'])[2]")
	WebElement ArrowDropdowntwo;
	@FindBy(xpath="//div[@class='oxd-select-option']")
	List<WebElement> elementsstatus;
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement username;
	@FindBy(xpath="(//input[@type='password'])[1]")
	WebElement password;
	@FindBy(xpath="(//input[@type='password'])[2]")
	WebElement Confirmpassword;
	@FindBy(xpath="//button[text()=' Save ']")
	WebElement SaveButton;
	
	public void clickadminpage() {
		navigateadmin.click();

	}

	public void AddAdminClick() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(AddAdmin));
		AddAdmin.click();		
		
	}	
	
	public void ArrowDropdownclick() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(ArrowDropdown));
		ArrowDropdown.click();
		
	}
	
	public void selectoptionrole() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
		try {
		for(WebElement ele: elements) {
			if(ele.getText().equalsIgnoreCase("Admin")) {
				ele.click();
			}
			
		}
		} catch (Exception e) {
			
			System.out.println("element changed");
		}
		
		
							
		}
	public void empname(String name) {
		Empname.click();
		Empname.sendKeys(name);
		
		
	}
	public void selectempname() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(empnames));
		try {
		for(WebElement ele: empnames) {
			if(ele.getText().equalsIgnoreCase("Peter Mac Anderson")) {
				ele.click();
				break;
			} else {
				ele.click();
			}
			
		} 
		} catch (Exception e) {
			
			System.out.println("InvalidName");
		} 
	}
	
		
	public void ArrowDropdownclicktwo() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(ArrowDropdowntwo));
		ArrowDropdowntwo.click();
		
	}	
	public void selectoptionstatus() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(elementsstatus));
		try {
		for(WebElement ele: elementsstatus) {
			if(ele.getText().equalsIgnoreCase("Enabled")) {
				ele.click();
			}
			
		} 
		} catch (Exception e) {
			
			System.out.println("element changed");
		} 
	}
		
	public void setusernameadmin() {
		String randomstring =RandomStringUtils.randomAlphabetic(7);
		username.sendKeys(randomstring);
		
		}
							
		
	public void setpasswordadmin(String passwordadmin) {
		password.sendKeys(passwordadmin);
	}
	public void setpasswordconfirmadmin(String confirmpasswordadmin) {
		Confirmpassword.sendKeys(confirmpasswordadmin);
	}
	public void clicksavebutton() {
		SaveButton.click();
	}
		
		
	}


	
	
	


