package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.MyDashboardPageUI;

public class MyDashboardPageObject extends BasePage {
	private WebDriver driver;
	
	public MyDashboardPageObject(WebDriver driver) {
		this.driver = driver; 
		System.out.println("Driver at class MyDashboardPageOject = " + driver.toString());
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, MyDashboardPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, MyDashboardPageUI.REGISTER_SUCCESS_MESSAGE);
	}
	
	public void clickToAccountLink() {
		waitForElementClickable(driver,MyDashboardPageUI.ACCOUNT_LINK);
		clickToElement(driver, MyDashboardPageUI.ACCOUNT_LINK);
	}

	public HomePageObject clickToLogoutLink() {
		waitForElementClickable(driver, MyDashboardPageUI.LOGOUT_LINK);
		clickToElement(driver, MyDashboardPageUI.LOGOUT_LINK);
		return PageGeneratorManager_Live_Guru.getHomePage(driver);
	}

	
}
