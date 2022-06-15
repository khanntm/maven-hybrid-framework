package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTestNopCommerce;
import pageObject.portal.nopCommerce.UserHomePageObject;
import pageObject.portal.nopCommerce.UserLoginPageObject;
import pageObject.portal.nopCommerce.UserRegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_04_Multiple_Browser extends BaseTestNopCommerce{
	private WebDriver driver; 
	
	private String emailAddress, firstName, lastName, password, emailAddressLogin, emailAddressTC14, myAccountLinkText;
	private UserHomePageObject homePage; 
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	
	@Parameters({"browser","url"})
	 @BeforeClass 
	  public void beforeClass(String browserName, String appUrl) {
		 driver = getBrowserDriver(browserName, appUrl);	
		 
		 homePage = new UserHomePageObject(driver);
		 registerPage = new UserRegisterPageObject(driver);
		 loginPage = new UserLoginPageObject(driver);
		 
		 emailAddress = "khan" + generateFakeNumber() + "@gmail.com";
		 emailAddressTC14 = "khan" + generateFakeNumber() + "@gmail.com";
		 firstName = "Khan";
		 lastName = "Auto";
		 password = "123456";
		 emailAddressLogin = "Fake_Automation@gmail.com";
	 }

@Test
  public void TC_01_Register_Empty_Data() {
	 
	 System.out.println("Home page + Step 01: Click to Register link");
	 homePage.clickToRegisterLink(); 
	 
	 System.out.println("Register page + Step 02: Click to Regiser button");
	 registerPage.clickToRegisterButton();
	  
	 
	 System.out.println("Register page + Step 03: Verify error message displayed");
	  Assert.assertEquals(registerPage.getErrorMessageAtFirstNameTextbox(), "First name is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtLastNameTextbox(), "Last name is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");  
  }
  
   //@Test
  public void TC_02_Register_Invalid_Email() {
	  System.out.println("Home page + Step 01: Click to Register link");
	  homePage.clickToRegisterLink(); 
	 
	  System.out.println("Register Page + Step 02: Input  to required fields");
	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox("2342342343");
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputToConfirmPasswordTextbox(password);
	  
	  System.out.println("Register page + Step 03: Click to Regiser button");
	  registerPage.clickToRegisterButton();
	  
	  System.out.println("Register page + Step 04: Verify error message displayed at Email");
	  Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");  
  }
  
 //@Test
  public void TC_03_Register_Success() {
	  System.out.println("Home page + Step 01: Click to Register link");
	  homePage.clickToRegisterLink(); 
	  
	  System.out.println("Register Page + Step 02: Input  to required fields");
	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox(emailAddress);
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputToConfirmPasswordTextbox(password);
	  
	  System.out.println("Register page + Step 03: Click to Regiser button");
	  registerPage.clickToRegisterButton();

	  System.out.println("Register page + Step 04: Verify success message displayed");
	  Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");  
	  
	  //System.out.println("Register page + Step 05: Click to Logout link");
	  //registerPage.clickToLogoutLink();
	  
  }
  
  //@Test
  public void TC_04_Register_Existing_Email() {
	  System.out.println("Home page + Step 01: Click to Register link");
	  homePage.clickToRegisterLink(); 
	  
	  System.out.println("Register Page + Step 02: Input  to required fields");
	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox(emailAddress);
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputToConfirmPasswordTextbox(password);
	  
	  System.out.println("Register page + Step 03: Click to Regiser button");
	  registerPage.clickToRegisterButton();
	  
	  System.out.println("Register page + Step 04: Verify error message displayed at Email");
	  Assert.assertEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");  
  }
  
  //@Test
  public void TC_05_Register_Password_Less_Than_6_Chars() {
	  System.out.println("Home page + Step 01: Click to Register link");
	  homePage.clickToRegisterLink(); 
	  
	  System.out.println("Register Page + Step 02: Input  to required fields");
	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox(emailAddress);
	  registerPage.inputToPasswordTextbox("123");
	  registerPage.inputToConfirmPasswordTextbox("123");
	  
	  System.out.println("Register page + Step 03: Click to Regiser button");
	  registerPage.clickToRegisterButton();
	  
	  System.out.println("Register page + Step 04: Verify error message displayed at Password");
	  Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password must meet the following rules:\n"
		  		+ "must have at least 6 characters");  
	  
  }
  
  //@Test
  public void TC_06_Register_Invalid_Confirm_Confirm_Password() {
	  System.out.println("Home page + Step 01: Click to Register link");
	  homePage.clickToRegisterLink(); 
	  
	  System.out.println("Register Page + Step 02: Input  to required fields");
	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox(emailAddress);
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputToConfirmPasswordTextbox("123456999");
	  
	  System.out.println("Register page + Step 03: Click to Regiser button");
	  registerPage.clickToRegisterButton();
	  
	  System.out.println("Register page + Step 04: Verify error message displayed at Confirm Password");
	  
	  Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "The password and confirmation password do not match.");    
  }
 
  //@Test
  public void TC_11_Login_With_Empty_Data() {
	  
	  System.out.println("Home page + step 01: Click Login link");
	  homePage.clickToLoginLinkUser();
	  
	  System.out.println("Login page + step 02: Click Login button");
	  loginPage.clickToLoginButton();
	  
	  System.out.println("Login page + step 03: Get email error message");
	  Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");      
	  	  
  }
  //@Test
  public void TC_12_Login_With_Invalid_Email() {
	  System.out.println("Home page + step 01: Click Login link");
	  homePage.clickToLoginLinkUser();
	  
	  System.out.println("Login page + step 02: Input invalid email");
	  loginPage.inputToEmailTextbox("Automation");
	  loginPage.inputToPasswordTextbox("Testing");
	  
	  System.out.println("Login page + step 03: Click Login button");
	  loginPage.clickToLoginButton();
	  
	  System.out.println("Login page + step 04: Get email error message");
	  Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");      
  }
  //@Test
  public void TC_13_Login_With_Not_Yet_Register_Email() {
	  System.out.println("Home page + step 01: Click Login link");
	  homePage.clickToLoginLinkUser();
	  
	  System.out.println("Login page + step 02: Input Not Exist email");
	  loginPage.inputToEmailTextbox(emailAddressLogin);
	  loginPage.inputToPasswordTextbox("123456");
	  
	  System.out.println("Login page + step 03: Click Login button");
	  loginPage.clickToLoginButton();
	  
	  System.out.println("Login page + step 04: Get error message on first form - Not Register/ Wrong Pass/ Empty Pass");
	  Assert.assertEquals(loginPage.getErrorMessageNotRegistWrongOrEmptyPassword(), "Login was unsuccessful. Please correct the errors and try again.\n"
			  + "No customer account found");      
  }
  //@Test
  public void TC_14_Login_With_Valid_Email_And_Empty_Password() {
	  
	  System.out.println("Home page + Step 01: Click to Register link");
	  homePage.clickToRegisterLink(); 
	   
	  System.out.println("Register Page + Step 02: Input  to required fields");
	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox(emailAddressTC14);
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputToConfirmPasswordTextbox(password);
	  
	  System.out.println("Register page + Step 03: Click to Regiser button");
	  registerPage.clickToRegisterButton();

	  System.out.println("Register page + Step 04: Verify success message displayed");
	  Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");  
	  
	  System.out.println("Register page + Step 05: Click to Logout link");
	  registerPage.clickToLogoutLink();
	  
	  System.out.println("Home page + step 06: Click Login link");
	  homePage.clickToLoginLinkUser();
	  
	  System.out.println("Login page + step 07: Input exisiting email & wrong password");
	  loginPage.inputToEmailTextbox(emailAddressTC14);
	  loginPage.inputToPasswordTextbox("");
	  
	  System.out.println("Login page + step 08: Click Login button");
	  loginPage.clickToLoginButton();
	  
	  System.out.println("Login page + step 09: Get error message on first form - Not Register/ Wrong Pass/ Empty Pass");
	  Assert.assertEquals(loginPage.getErrorMessageNotRegistWrongOrEmptyPassword(),"Login was unsuccessful. Please correct the errors and try again.\n"
			  + "The credentials provided are incorrect");   
  }
  //@Test
  public void TC_15_Login_With_Valid_Email_And_Wrong_Password() {
	 
	  System.out.println("Home page + Step 01: Click to Register link");
	  homePage.clickToRegisterLink(); 
	   
	  System.out.println("Register Page + Step 02: Input  to required fields");
	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox(emailAddress);
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputToConfirmPasswordTextbox(password);
	  
	  System.out.println("Register page + Step 03: Click to Regiser button");
	  registerPage.clickToRegisterButton();

	  System.out.println("Register page + Step 04: Verify success message displayed");
	  Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");  
	  
	  System.out.println("Register page + Step 05: Click to Logout link");
	  registerPage.clickToLogoutLink();
	  
	  System.out.println("Home page + step 06: Click Login link");
	  homePage.clickToLoginLinkUser();
	  
	  System.out.println("Login page + step 07: Input exisiting email & wrong password");
	  loginPage.inputToEmailTextbox(emailAddress);
	  loginPage.inputToPasswordTextbox("1234567");
	  
	  System.out.println("Login page + step 08: Click Login button");
	  loginPage.clickToLoginButton();
	  
	  System.out.println("Login page + step 09: Get error message on first form - Not Register/ Wrong Pass/ Empty Pass");
	  Assert.assertEquals(loginPage.getErrorMessageNotRegistWrongOrEmptyPassword(),"Login was unsuccessful. Please correct the errors and try again.\n"
			  + "The credentials provided are incorrect"); 
	      
  }

  //@Test
  public void TC_16_Login_With_Valid_Email_And_Valid_Password() {
	  System.out.println("Home page + step 01: Click Login link");
	  homePage.clickToLoginLinkUser();
	  
	  System.out.println("Login page + step 02: Input exisiting email & wrong password");
	  loginPage.inputToEmailTextbox(emailAddress);
	  loginPage.inputToPasswordTextbox("123456");
	  
	  System.out.println("Login page + step 03: Click Login button");
	  loginPage.clickToLoginButton();
	  
	  System.out.println("Homepage + step 04: Verify My Account link");
	  homePage.getMyAccountLink(myAccountLinkText);
	  Assert.assertEquals(homePage.getMyAccountLink(myAccountLinkText), "My account");      
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
