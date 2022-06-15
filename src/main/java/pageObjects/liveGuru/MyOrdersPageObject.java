package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class MyOrdersPageObject extends BasePage{
	private WebDriver driver;
	
	public MyOrdersPageObject(WebDriver driver) {
		this.driver = driver;
		System.out.println("Driver at class My Orders = " + driver.toString());
	}

}
