package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_02_Apply_BasePage_III extends BasePage{
	WebDriver driver; 
	String projectPath = System.getProperty("user.dir");
	String emailAddress;
	
	 @BeforeClass
	  public void beforeClass() {
		 System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		 driver = new FirefoxDriver();
		 
		 emailAddress = "khan" + generateFakeNumber() + "@gmail.com";
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.get("https://demo.nopcommerce.com/");
	 }

	
 //@Test
  public void TC_01_Register_Empty_Data() {
	  waitForElementVisible(driver, "//a[@class='ico-register']");
	  clickToElement(driver, "//a[@class='ico-register']");
	  
	  waitForElementVisible(driver, "//button[@id='register-button']");
	  clickToElement(driver, "//button[@id='register-button']");
	  
	  Assert.assertEquals(getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
	  Assert.assertEquals(getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
	  Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
	  Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
	  Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");  
  }
  
   //@Test
  public void TC_02_Register_Invalid_Email() {
	  waitForElementVisible(driver, "//a[@class='ico-register']");
	  clickToElement(driver, "//a[@class='ico-register']");
	  
	  sendkeyToElement(driver, "//input[@id='FirstName']", "Automation");
	  sendkeyToElement(driver, "//input[@id='LastName']", "Testing");
	  sendkeyToElement(driver, "//input[@id='Email']", "2342342343");
	  sendkeyToElement(driver, "//input[@id='Password']", "123456");
	  sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
	  
	  waitForElementVisible(driver, "//button[@id='register-button']");
	  clickToElement(driver, "//button[@id='register-button']");
	  
	  Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Wrong email");  
	  
  }
  
 //@Test
  public void TC_03_Register_Success() {
	  waitForElementVisible(driver, "//a[@class='ico-register']");
	  clickToElement(driver, "//a[@class='ico-register']");
	  
	  sendkeyToElement(driver, "//input[@id='FirstName']", "Automation");
	  sendkeyToElement(driver, "//input[@id='LastName']", "Testing");
	  sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
	  sendkeyToElement(driver, "//input[@id='Password']", "123456");
	  sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
	  
	  waitForElementVisible(driver, "//button[@id='register-button']");
	  clickToElement(driver, "//button[@id='register-button']");
	  
	  Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");  
	  
  }
  
   //@Test
  public void TC_04_Register_Existing_Email() {
	  waitForElementVisible(driver, "//a[@class='ico-logout']");
	  clickToElement(driver, "//a[@class='ico-logout']");
	  
	  waitForElementVisible(driver, "//a[@class='ico-register']");
	  clickToElement(driver, "//a[@class='ico-register']");
	  
	  sendkeyToElement(driver, "//input[@id='FirstName']", "Automation");
	  sendkeyToElement(driver, "//input[@id='LastName']", "Testing");
	  sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
	  sendkeyToElement(driver, "//input[@id='Password']", "123456");
	  sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
	  
	  waitForElementVisible(driver, "//button[@id='register-button']");
	  clickToElement(driver, "//button[@id='register-button']");
	  
	  Assert.assertEquals(getElementText(driver, "//div[@class='message-error validation-summary-errors']"), "The specified email already exists");  
  }
  
  //@Test
  public void TC_05_Register_Password_Less_Than_6_Chars() {
	  waitForElementVisible(driver, "//a[@class='ico-register']");
	  clickToElement(driver, "//a[@class='ico-register']");
	  
	  sendkeyToElement(driver, "//input[@id='FirstName']", "Automation");
	  sendkeyToElement(driver, "//input[@id='LastName']", "Testing");
	  sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
	  sendkeyToElement(driver, "//input[@id='Password']", "123");
	  sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123");
	  
	  waitForElementVisible(driver, "//button[@id='register-button']");
	  clickToElement(driver, "//button[@id='register-button']");
	  
	  Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"), "Password must meet the following rules:\n"
		  		+ "must have at least 6 characters");  
	  
  }
  
  //@Test
  public void TC_06_Register_Invalid_Confirm_Confirm_Password() {
	  waitForElementVisible(driver, "//a[@class='ico-register']");
	  clickToElement(driver, "//a[@class='ico-register']");
	  
	  sendkeyToElement(driver, "//input[@id='FirstName']", "Automation");
	  sendkeyToElement(driver, "//input[@id='LastName']", "Testing");
	  sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
	  sendkeyToElement(driver, "//input[@id='Password']", "123456");
	  sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456999");
	  
	  waitForElementVisible(driver, "//button[@id='register-button']");
	  clickToElement(driver, "//button[@id='register-button']");
	  
	  Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");    
  }
 
  //@Test
  public void TC_11_Login_With_Empty_Data() {
	  waitForElementVisible(driver, "//a[@class='ico-login']");
	  clickToElement(driver, "//a[@class='ico-login']");
	 
	  waitForElementVisible(driver, "//button[@class='button-1 login-button']");
	  clickToElement(driver, "//button[@class='button-1 login-button']");
	  
	  Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Please enter your email");      
  }
  //@Test
  public void TC_12_Login_With_Invalid_Email() {
	  waitForElementVisible(driver, "//a[@class='ico-login']");
	  clickToElement(driver, "//a[@class='ico-login']");
	  
	  sendkeyToElement(driver, "//input[@id='Email']", "Automation");
	  sendkeyToElement(driver, "//input[@id='Password'] ", "Testing");
	  
	  waitForElementVisible(driver, "//button[@class='button-1 login-button']");
	  clickToElement(driver, "//button[@class='button-1 login-button']");
	  
	  Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Wrong email");      
  }
  //@Test
  public void TC_13_Login_With_Not_Yet_Register_Email() {
	  waitForElementVisible(driver, "//a[@class='ico-login']");
	  clickToElement(driver, "//a[@class='ico-login']");
	  
	  sendkeyToElement(driver, "//input[@id='Email']", "Fake_Automation@gmail.com");
	  sendkeyToElement(driver, "//input[@id='Password'] ", "123456");
	  
	  waitForElementVisible(driver, "//button[@class='button-1 login-button']");
	  clickToElement(driver, "//button[@class='button-1 login-button']");
	  
	  Assert.assertEquals(getElementText(driver, "//div[@class='message-error validation-summary-errors']"), "Login was unsuccessful. Please correct the errors and try again.\n"
			  + "No customer account found");      
  }
  //@Test
  public void TC_14_Login_With_Valid_Email_And_Empty_Password() {
	  
	  waitForElementVisible(driver, "//a[@class='ico-register']");
	  clickToElement(driver, "//a[@class='ico-register']");
	  
	  sendkeyToElement(driver, "//input[@id='FirstName']", "Automation");
	  sendkeyToElement(driver, "//input[@id='LastName']", "Testing");
	  sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
	  sendkeyToElement(driver, "//input[@id='Password']", "123456");
	  sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
	  
	  waitForElementVisible(driver, "//button[@id='register-button']");
	  clickToElement(driver, "//button[@id='register-button']");
	  
	  Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");  
	  
	  waitForElementVisible(driver, "//a[@class='ico-logout']");
	  clickToElement(driver, "//a[@class='ico-logout']");
	  
	  
	  waitForElementVisible(driver, "//a[@class='ico-login']");
	  clickToElement(driver, "//a[@class='ico-login']");
	  
	  sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
	  sendkeyToElement(driver, "//input[@id='Password'] ", "");
	  
	  waitForElementVisible(driver, "//button[@class='button-1 login-button']");
	  clickToElement(driver, "//button[@class='button-1 login-button']");
	  
	  Assert.assertEquals(getElementText(driver, "//div[@class='message-error validation-summary-errors']"), "Login was unsuccessful. Please correct the errors and try again.\n"
			  + "The credentials provided are incorrect");      
  }
  //@Test
  public void TC_15_Login_With_Valid_Email_And_Wrong_Password() {
	 
	  waitForElementVisible(driver, "//a[@class='ico-login']");
	  clickToElement(driver, "//a[@class='ico-login']");
	 
	  sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
	  sendkeyToElement(driver, "//input[@id='Password'] ", "1234567");
	  
	  waitForElementVisible(driver, "//button[@class='button-1 login-button']");
	  clickToElement(driver, "//button[@class='button-1 login-button']");
	  
	  Assert.assertEquals(getElementText(driver, "//div[@class='message-error validation-summary-errors']"), "Login was unsuccessful. Please correct the errors and try again.\n"
	  		+ "The credentials provided are incorrect");      
  }

  //@Test
  public void TC_16_Login_With_Valid_Email_And_Valid_Password() {
	  
	  waitForElementVisible(driver, "//a[@class='ico-login']");
	  clickToElement(driver, "//a[@class='ico-login']");
	 
	  sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
	  sendkeyToElement(driver, "//input[@id='Password'] ", "123456");
	  
	  waitForElementVisible(driver, "//button[@class='button-1 login-button']");
	  clickToElement(driver, "//button[@class='button-1 login-button']");
	  
	  Assert.assertEquals(getElementText(driver, "//a[@class='ico-account']"), "My account");      
  }
	 
@Test
  public void TC_21_Update_Customer_Info() {
	String FirstName = "Khan";
	String LastName = "Testing";
	
	
	waitForElementVisible(driver, "//a[@class='ico-register']");
	  clickToElement(driver, "//a[@class='ico-register']");
	  
	  sendkeyToElement(driver, "//input[@id='FirstName']", "Automation");
	  sendkeyToElement(driver, "//input[@id='LastName']", "Testing");
	  sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
	  sendkeyToElement(driver, "//input[@id='Password']", "123456");
	  sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
	  
	  waitForElementVisible(driver, "//button[@id='register-button']");
	  clickToElement(driver, "//button[@id='register-button']");
	  
	  Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");  
	  
  }
  
  @AfterClass
	public void afterClass() {
		driver.quit();
	}
  
  public int generateFakeNumber() {
	  Random rand = new Random();
	  return rand.nextInt(9999);
  }


}
