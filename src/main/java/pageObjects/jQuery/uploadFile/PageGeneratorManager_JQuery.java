package pageObjects.jQuery.uploadFile;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager_JQuery {
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
		
	}
}
