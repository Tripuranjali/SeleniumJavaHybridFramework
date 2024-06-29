package com.OrangeHRM.PageObjects;

import java.time.Duration;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatePickerPage {
	WebDriver driver;
	
	public DatePickerPage (WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//public String Month="April";
	//public String date="19";
	@FindBy(xpath="//iframe[@id='frame-one796456169']")
	WebElement switchframe;

	@FindBy(xpath="//span[@class='icon_calendar']")
	WebElement calendaricon;
	
	@FindBy(xpath="//span[@class='ui-datepicker-month']")
	WebElement Currentmonth;
	
	@FindBy(xpath="//*[@class='ui-datepicker-year']")
	WebElement currentyear;
	
	@FindBy(xpath="//*[@title='Next']")
	WebElement nextbutton;
	
	@FindBy(xpath="//*[@title='Prev']")
	WebElement previousbutton;
	
	@FindBy(xpath="//*[@id='q2_label']")
	WebElement scrollelement;
	
	@FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody//tr//td//a")
	List <WebElement> dates;
	
	public void iframeswitch() {
		driver.switchTo().frame(switchframe);
	}
	
	public void scrollthepage() {
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(scrollelement));
			JavascriptExecutor je =(JavascriptExecutor) driver;
			je.executeScript("arguments[0].scrollIntoView();",scrollelement);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	public void clickcalendar() {
		calendaricon.click();
				
	}
	
	static Month convertmonth(String monthy) {
		HashMap<String, Month> map= new HashMap<String, Month>();
		map.put("January", Month.JANUARY);
		map.put("February", Month.FEBRUARY);
		map.put("March", Month.MARCH);
		map.put("April", Month.APRIL);
		map.put("May", Month.MAY);
		map.put("June", Month.JUNE);
		map.put("July", Month.JULY);
		map.put("August", Month.AUGUST);
		map.put("September", Month.SEPTEMBER);
		map.put("October", Month.OCTOBER);
		map.put("November", Month.NOVEMBER);
		map.put("December", Month.DECEMBER);
		
		Month m = map.get(monthy);
		if (m==null) {
			System.out.println("Invalid");
		}
		return m;
		
		
	}

	public void datepicker(String yr, String mon) {
		Select drpopt = new Select(currentyear);
		drpopt.selectByValue(yr);
		
		while(true) {
			Month ExpectedMonth = convertmonth(mon);
			Month DisplayMonth = convertmonth(Currentmonth.getText());
			
			int result=ExpectedMonth.compareTo(DisplayMonth);
			// 0 = months equal, >0= future month <=past month
			
			if(result<0) {
				previousbutton.click();				
			} 
			else if(result>0) {
				nextbutton.click();				
			}
			else {				
				break;
			}		
			
		}
				
	}
	
	public void selectdate(String d) {
		for (WebElement dt:dates) {
			if(dt.getText().equals(d)) {
				dt.click();
				break;
			}
		}
		
	}
	
	
	
	
	

}
