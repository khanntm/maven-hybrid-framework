package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTestNopCommerce;
import pageObject.portal.nopCommerce.PageGeneratorManager;
import pageObject.portal.nopCommerce.UserAddressPageObject;
import pageObject.portal.nopCommerce.UserCustomerInfoPageObject;
import pageObject.portal.nopCommerce.UserHomePageObject;
import pageObject.portal.nopCommerce.UserLoginPageObject;
import pageObject.portal.nopCommerce.UserMyProductReviewPageObject;
import pageObject.portal.nopCommerce.UserRegisterPageObject;
import pageObject.portal.nopCommerce.UserRewardPointPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_07_Switch_Page extends BaseTestNopCommerce{
	
	@Parameters({"browser","url"})
	 @BeforeClass 
	  public void beforeClass(String browserName, String appUrl) {
		 driver = getBrowserDriver(browserName, appUrl);		 
		 
		 // 1  using for pre-condition case. 
		 //homePage = new HomePageObject(driver);
		 homePage = PageGeneratorManager.getUserHomePage(driver);
		 registerPage = PageGeneratorManager.getUserRegisterPage(driver);
		 
		 emailAddress = "khan" + generateFakeNumber() + "@gmail.com";
		 firstName = "Khan";
		 lastName = "Auto";
		 password = "123456";
	 }

 @Test
  public void User_01_Regiser() {
	  
	 System.out.println("User 01 Register: Step 01 - Click to Register link");
	 registerPage = homePage.clickToRegisterLink(); 
	  
	  System.out.println("User 01 Register: Step 02 - Input  to required fields");
	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox(emailAddress);
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputToConfirmPasswordTextbox(password);
	  
	  System.out.println("User 01 Register:  Step 03 - Click to Regiser button");
	  registerPage.clickToRegisterButton();

	  System.out.println("User 01 Register: Step 04 - Verify success message displayed");
	  Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");  
	  
	  System.out.println("User 01 Register: Step 05 - Click to Logout link");
	  homePage = registerPage.clickToLogoutLink();  	  
  }
  @Test
  public void User_02_Login() {
	  System.out.println("User 02 + step 01: Click Login link");
	  loginPage = homePage.clickToLoginLinkUser();
	  
	  System.out.println("User 02  + step 02: Input exisiting email & wrong password");
	  loginPage.inputToEmailTextbox(emailAddress);
	  loginPage.inputToPasswordTextbox(password);
	  
	  System.out.println("User 02  + step 03: Click Login button");
	  homePage = loginPage.clickToLoginButton();
	  
	  System.out.println("User 02  + step 04: Verify My Account link display");
	
	  Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	        
  }
  @Test
  public void User_03_Customer_Infor() {
	  customerInforPage = homePage.clickToMyAccountLink();    
	  //Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed());
  }
  @Test
  public void User_04_Switch_Page() {
	  // Knowledge cua Page Object
	  // 1 page A khi chuyen tu page nay sang page kia thi phai viet 1 hàm de mo page do len (open url/ click) 
	  
	  //Customer Infor > Address
	  addressPage = customerInforPage.openAddressPage(driver);
	  //Address > My Product Review
	  myProductReviewPage = addressPage.openMyProductReviewPage(driver);
	  //My Product Review > Reward Point
	  rewardPointPage = myProductReviewPage.openRewardPoint(driver);
	  //Reward Point -> Address
	  addressPage = rewardPointPage.openAddressPage(driver);
	  //Address -> Reward Point
	  rewardPointPage = addressPage.openRewardPoint(driver);
	  //Reward Point > My Product Review
	  myProductReviewPage = rewardPointPage.openMyProductReviewPage(driver);
	 
	  //My Product Review > Address
	  addressPage = myProductReviewPage.openAddressPage(driver);
	  
	  customerInforPage = addressPage.openCustomerInfoPage(driver);
	  
	  myProductReviewPage = customerInforPage.openMyProductReviewPage(driver);
  }
  //@Test
  public void User_05_Switch_Role() {
	  //Role User -> Role Admin
	  
	  //Role Admin -> Role User
	}
  
  @AfterClass
	public void afterClass() {
		driver.quit();
	}
    private WebDriver driver; 
	//private String projectPath = System.getProperty("user.dir");
	private String emailAddress, firstName, lastName, password, myAccountLinkText;
	private UserHomePageObject homePage; 
	private UserLoginPageObject loginPage;
	private UserRegisterPageObject registerPage;
	private UserCustomerInfoPageObject customerInforPage;
	private UserAddressPageObject addressPage;
	private UserMyProductReviewPageObject myProductReviewPage;
	private UserRewardPointPageObject rewardPointPage;
}
