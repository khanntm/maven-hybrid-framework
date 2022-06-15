package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class AddressBookPageObject extends BasePage{
	private WebDriver driver;
	
	public AddressBookPageObject(WebDriver driver) {
		this.driver = driver;
		System.out.println("Driver at class Address Book = " + driver.toString());
	}

}
