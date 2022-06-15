package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager_Facebook {
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
		
	}
}
