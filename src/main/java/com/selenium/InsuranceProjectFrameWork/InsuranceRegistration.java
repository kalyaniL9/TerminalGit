package com.selenium.InsuranceProjectFrameWork;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.selenium.InsuranceProject.Utilities.RegDataHandling;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InsuranceRegistration {

	public static void main(String[] args) throws Exception {
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://demo.guru99.com/insurance/v1/index.php");
		
		RegLocators locators = new RegLocators();
		RegDataHandling regData = new RegDataHandling();
		
		//Click on Registration button
		driver.findElement(By.xpath(locators.REGISTRATION_BUTTON)).click();
		String regpagetitle = driver.getTitle();
		Assert.assertEquals(regpagetitle, "Insurance Broker System - Register", "Registration Title Validation Pass");
		
		//Title Selection
		Select title = new Select(driver.findElement(By.id(locators.TITLE_SELECTION)));		
		title.selectByVisibleText(regData.getpropertiesvalues("NameTitle"));
		
		//Enter FirstName
		driver.findElement(By.xpath(locators.FIRST_NAME)).sendKeys(regData.getpropertiesvalues("FirstName"));
		
		//Enter LastName
		driver.findElement(By.xpath(locators.LAST_NAME)).sendKeys(regData.getpropertiesvalues("LastName"));
		
		//Enter PhoneNumber
		driver.findElement(By.xpath(locators.PHONE_NUMBER)).sendKeys(regData.getpropertiesvalues("PhoneNumber"));
		
		//Select DOB-Year
		Select year = new Select(driver.findElement(By.id(locators.DOB_YEAR)));
		year.selectByVisibleText(regData.getpropertiesvalues("DOB-Year"));
		
		//Select DOB-Month
		Select month = new Select(driver.findElement(By.id(locators.DOB_MONTH)));
		month.selectByValue(regData.getpropertiesvalues("DOB-Month"));
		
		//Select DOB-Date
		Select date = new Select(driver.findElement(By.id(locators.DOB_DATE)));
		date.selectByValue(regData.getpropertiesvalues("DOB-Date"));
		
		Thread.sleep(1000);
		//Full/Provisional option Selection
		driver.findElement(By.id(locators.PROVISIONAL)).click();
		
		//Select Occupation
		Select occupation = new Select(driver.findElement(By.id(locators.OCCUPATION)));
		occupation.selectByValue(regData.getpropertiesvalues("Occupation"));
		
		//Enter Address-Street 
		driver.findElement(By.xpath(locators.ADDRESS_STREET)).sendKeys(regData.getpropertiesvalues("Address-Street"));
		
		//Enter Address-City 
		driver.findElement(By.xpath(locators.ADDRESS_CITY)).sendKeys(regData.getpropertiesvalues("Address-City"));
		
		//Enter Address-County 
		driver.findElement(By.xpath(locators.ADDRESS_COUNTY)).sendKeys(regData.getpropertiesvalues("Address-County"));
		
		//Enter Postal Code
		driver.findElement(By.id(locators.POSTAL_CODE)).sendKeys(regData.getpropertiesvalues("Postal-Code")); 
		
		//Enter Email 
		driver.findElement(By.xpath(locators.EMAIL)).sendKeys(regData.getpropertiesvalues("Email"));
		
		//Enter Password 
		driver.findElement(By.xpath(locators.PASSWORD)).sendKeys(regData.getpropertiesvalues("Password"));
		
		//Enter Password 
		driver.findElement(By.xpath(locators.PWD_CONFIRMATION)).sendKeys(regData.getpropertiesvalues("Password-Confirm"));
		
		
		
		
		
		
		
		

	}

}
