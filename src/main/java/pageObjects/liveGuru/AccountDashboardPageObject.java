package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class AccountDashboardPageObject extends BasePage{
	private WebDriver driver;
	
	public AccountDashboardPageObject(WebDriver driver) {
		this.driver = driver;
		System.out.println("Driver at class Account Dashboard = " + driver.toString());
	}

}
