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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_06_Page_Generator_Manager_II extends BaseTestNopCommerce{
	private WebDriver driver; 
	private String projectPath = System.getProperty("user.dir");
	private String emailAddress, firstName, lastName, password, emailAddressLogin, emailAddressTC14, myAccountLinkText;
	private UserHomePageObject homePage; 
	private UserLoginPageObject loginPage;
	private UserRegisterPageObject registerPage;

	@Parameters({"browser","url"})
	 @BeforeClass 
	  public void beforeClass(String browserName, String appUrl) {
		 driver = getBrowserDriver(browserName, appUrl);		 
		 
		 // 1  using for pre-condition case. 
		 homePage = new UserHomePageObject(driver);
		 //loginPage = new LoginPageObject(driver);
		 
		 emailAddress = "khan" + generateFakeNumber() + "@gmail.com";
		 emailAddressTC14 = "khan" + generateFakeNumber() + "@gmail.com";
		 firstName = "Khan";
		 lastName = "Auto";
		 password = "123456";
		 emailAddressLogin = "Fake_Automation@gmail.com";
		 
		 System.out.println("Precondition: Step 01 - Click to Register link");
		 registerPage = homePage.clickToRegisterLink(); 
		  
		  System.out.println("Precondition: Step 02 - Input  to required fields");
		  registerPage.inputToFirstNameTextbox(firstName);
		  registerPage.inputToLastNameTextbox(lastName);
		  registerPage.inputToEmailTextbox(emailAddressTC14);
		  registerPage.inputToPasswordTextbox(password);
		  registerPage.inputToConfirmPasswordTextbox(password);
		  
		  System.out.println("Precondition: Step 03 - Click to Regiser button");
		  registerPage.clickToRegisterButton();

		  System.out.println("Precondition: Step 04 - Verify success message displayed");
		  Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");  
		  
		  System.out.println("Precondition: Step 05 - Click to Logout link");
		  homePage = registerPage.clickToLogoutLink();
		  
	 }

  @Test
  public void Login_01_With_Empty_Data() {
	  
	  System.out.println("Home page + step 01: Click Login link");
	  loginPage = homePage.clickToLoginLinkUser();
	  
	  System.out.println("Login page + step 02: Click Login button");
	  loginPage.clickToLoginButton();
	  
	  System.out.println("Login page + step 03: Get email error message");
	  Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");      
	  	  
  }
  @Test
  public void Login_02_With_Invalid_Email() {
	  System.out.println("Home page + step 01: Click Login link");
	  loginPage = homePage.clickToLoginLinkUser();

	  System.out.println("Login page + step 02: Input invalid email");
	  loginPage.inputToEmailTextbox("Automation");
	  loginPage.inputToPasswordTextbox("Testing");
	  
	  System.out.println("Login page + step 03: Click Login button");
	  loginPage.clickToLoginButton();
	  
	  System.out.println("Login page + step 04: Get email error message");
	  Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");      
  }
  @Test
  public void Login_03_With_Not_Yet_Register_Email() {
	  System.out.println("Home page + step 01: Click Login link");
	  loginPage = homePage.clickToLoginLinkUser();
	  
	  System.out.println("Login page + step 02: Input Not Exist email");
	  loginPage.inputToEmailTextbox(emailAddressLogin);
	  loginPage.inputToPasswordTextbox("123456");
	  
	  System.out.println("Login page + step 03: Click Login button");
	  loginPage.clickToLoginButton();
	  
	  System.out.println("Login page + step 04: Get error message on first form - Not Register/ Wrong Pass/ Empty Pass");
	  Assert.assertEquals(loginPage.getErrorMessageNotRegistWrongOrEmptyPassword(), "Login was unsuccessful. Please correct the errors and try again.\n"
			  + "No customer account found");      
  }
  @Test
  public void Login_04_With_Valid_Email_And_Empty_Password() {

	  System.out.println("Home page + step 06: Click Login link");
	  loginPage = homePage.clickToLoginLinkUser();
	  
	  System.out.println("Login page + step 07: Input exisiting email & wrong password");
	  loginPage.inputToEmailTextbox(emailAddressTC14);
	  loginPage.inputToPasswordTextbox("");
	  
	  System.out.println("Login page + step 08: Click Login button");
	  loginPage.clickToLoginButton();
	  
	  System.out.println("Login page + step 09: Get error message on first form - Not Register/ Wrong Pass/ Empty Pass");
	  Assert.assertEquals(loginPage.getErrorMessageNotRegistWrongOrEmptyPassword(),"Login was unsuccessful. Please correct the errors and try again.\n"
			  + "The credentials provided are incorrect");   
  }
  @Test
  public void Login_05_With_Valid_Email_And_Wrong_Password() {
	 
	  System.out.println("Home page + step 06: Click Login link");
	  loginPage = homePage.clickToLoginLinkUser();
	  
	  System.out.println("Login page + step 07: Input exisiting email & wrong password");
	  loginPage.inputToEmailTextbox(emailAddressTC14);
	  loginPage.inputToPasswordTextbox("1234567");
	  
	  System.out.println("Login page + step 08: Click Login button");
	  loginPage.clickToLoginButton();
	  
	  System.out.println("Login page + step 09: Get error message on first form - Not Register/ Wrong Pass/ Empty Pass");
	  Assert.assertEquals(loginPage.getErrorMessageNotRegistWrongOrEmptyPassword(),"Login was unsuccessful. Please correct the errors and try again.\n"
			  + "The credentials provided are incorrect"); 
	      
  }

  @Test
  public void Login_06_With_Valid_Email_And_Valid_Password() {
	  System.out.println("Home page + step 01: Click Login link");
	  loginPage = homePage.clickToLoginLinkUser();
	  
	  System.out.println("Login page + step 02: Input exisiting email & wrong password");
	  loginPage.inputToEmailTextbox(emailAddressTC14);
	  loginPage.inputToPasswordTextbox("123456");
	  
	  System.out.println("Login page + step 03: Click Login button");
	  homePage = loginPage.clickToLoginButton();
	  
	  System.out.println("Homepage + step 04: Verify My Account link display");
	  
	  //homePage.getMyAccountLink(myAccountLinkText);
	  //Assert.assertEquals(homePage.getMyAccountLink(myAccountLinkText), "My account");   
	  Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	  
  }

  
  @AfterClass
	public void afterClass() {
		driver.quit();
	}
  
  
}
