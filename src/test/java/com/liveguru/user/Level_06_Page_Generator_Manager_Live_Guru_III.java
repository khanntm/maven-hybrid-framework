package com.liveguru.user;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTestLiveGuru;
import commons.BaseTestNopCommerce;
import pageObjects.liveGuru.AccountDashboardPageObject;
import pageObjects.liveGuru.AccountInformationPageObject;
import pageObjects.liveGuru.AddressBookPageObject;
import pageObjects.liveGuru.BilingAgreementPageObject;
import pageObjects.liveGuru.HomePageObject;
import pageObjects.liveGuru.LoginPageObject;
import pageObjects.liveGuru.MyDashboardPageObject;
import pageObjects.liveGuru.MyOrdersPageObject;
import pageObjects.liveGuru.MyProductReviewPageObject;
import pageObjects.liveGuru.PageGeneratorManager_Live_Guru;
import pageObjects.liveGuru.RecurringProfilesPageObject;
import pageObjects.liveGuru.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_06_Page_Generator_Manager_Live_Guru_III extends BaseTestLiveGuru {
	
	@Parameters({"browser","url"})
	 @BeforeClass 
	  public void beforeClass(String browserName, String appUrl) {
		 driver = getBrowserDriver(browserName, appUrl);	
		 homePage = PageGeneratorManager_Live_Guru.getHomePage(driver);
		
		 firstName = "Khan";
		 lastName = "Nguyen";
		 emailAddress = "Khan" + generateFakeNumber() + "@gmail.com";
		 password = "123456";
		 confirmPassword = password; 
	 }

  @Test
  public void User_01_Register_To_System() {
	  System.out.println("Home page + step 01: Click Account link");
	  homePage.clickToAccountLink();
	  
	  System.out.println("Home page + step 02: Click Register link");
	  registerPage = homePage.clickToRegisterLink();
	  
	  System.out.println("Register Page: Step 03 - Input  to required fields");
	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox(emailAddress);
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputToConfirmPasswordTextbox(confirmPassword);
	  
	  System.out.println("Register Page: Step 04 - Click to Regiser button");
	  myDashboardPage = registerPage.clickToRegisterButton();
	  
	  System.out.println("My Dashboarrd: Step 05 - Verify success message displayed");
	  Assert.assertEquals(myDashboardPage.getRegisterSuccessMessage(),"Thank you for registering with Main Website Store.");
	  
	  System.out.println("My Dashboard + step 06: Click My Account link");
	  myDashboardPage.clickToAccountLink();
	  
	  System.out.println("My Dashboard: Step 07 - Click to Logout link");
	  homePage = myDashboardPage.clickToLogoutLink();
  }
  
@Test
  public void User_02_Login_To_System() {
	  System.out.println("TC02: Home page + step 01: Click Account link");
	  homePage.clickToAccountLink();
	  
	  System.out.println("TC02: Home page + step 02: Click Register link");
	  loginPage = homePage.clickToLogInLink();
	  
	  System.out.println("TC02: Login page step 03: Input username & password");
	  loginPage.inputToEmailAddressTextbox(emailAddress);
	  loginPage.inputToPasswordTextbox(password);
	  
	  System.out.println("TC02: Login page step 04: Click Login button");
	  myDashboardPage = loginPage.clickToLoginButon();
	  
	  System.out.println("TC02 My Dashboard + step 05: Click My Account link");
	  myDashboardPage.clickToAccountLink();
	  
	  //System.out.println("TC02 My Dashboard: Step 06 - Click to Logout link");
	  //homePage = myDashboardPage.clickToLogoutLink();
  }
  
@Test
	public void User_03_Switch_Pages() {
	//accountInformationPage = accountDashboardPage.openAccountInformationPage(driver);
	accountInformationPage = myDashboardPage.openAccountInformationPage(driver);
	
	addressBookPage = accountInformationPage.openAddressBookPage(driver);
	
	myOrdersPage = addressBookPage.openMyOrdersPage(driver); 
	
	billingAgreementPage = myOrdersPage.openBilingAgreementPage(driver);
	
	recurringProfilesPage = billingAgreementPage.openRecurringProfilePage(driver);
	
	//myProductReviewPage = recurringProfilesPage.openMyProductReviewLiveGuruPage();
}

  @AfterClass
	public void afterClass() {
		driver.quit();
	}
  private WebDriver driver; 
  private HomePageObject homePage;
  private LoginPageObject loginPage;
  private RegisterPageObject registerPage;
  private MyDashboardPageObject myDashboardPage;
  private String firstName, lastName, emailAddress, password, confirmPassword;
 // private AccountDashboardPageObject accountDashboardPage;
  private AccountInformationPageObject accountInformationPage;
  private AddressBookPageObject addressBookPage;
  private MyOrdersPageObject myOrdersPage;
  private BilingAgreementPageObject billingAgreementPage;
  private RecurringProfilesPageObject recurringProfilesPage;
 // private MyProductReviewPageObject myProductReviewPage; 

}
