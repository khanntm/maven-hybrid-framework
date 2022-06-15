package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class BilingAgreementPageObject extends BasePage{
	private WebDriver driver;
	
	public BilingAgreementPageObject(WebDriver driver) {
		this.driver = driver;
		System.out.println("Driver at class Billing Agreement = " + driver.toString());
	}

}
