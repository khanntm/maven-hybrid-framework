package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class AccountInformationPageObject extends BasePage{
	private WebDriver driver;
	
	public AccountInformationPageObject(WebDriver driver) {
		this.driver = driver;
		System.out.println("Driver at class Account Information = " + driver.toString());
	}

}
