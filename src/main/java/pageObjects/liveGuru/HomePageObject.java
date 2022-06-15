package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver; 
		System.out.println("Driver at class HomePageOject = " + driver.toString());
	}

	public void clickToAccountLink() {
		waitForElementVisible(driver, HomePageUI.ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.ACCOUNT_LINK);
	}

	public RegisterPageObject clickToRegisterLink() {
		waitForElementVisible(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager_Live_Guru.getRegisterPage(driver);
	}

	public LoginPageObject clickToLogInLink() {
		waitForElementVisible(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver,HomePageUI.LOGIN_LINK);
		return PageGeneratorManager_Live_Guru.getLoginPage(driver);
	}
}
