package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class RecurringProfilesPageObject extends BasePage{
	private WebDriver driver;
	
	public RecurringProfilesPageObject(WebDriver driver) {
		this.driver = driver;
		System.out.println("Driver at class Recurring Profiles = " + driver.toString());
	}

}
