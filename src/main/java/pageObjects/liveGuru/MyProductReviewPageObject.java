package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class MyProductReviewPageObject extends BasePage{
	private WebDriver driver;
	
	public MyProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
		System.out.println("Driver at class My Product Review = " + driver.toString());
	}

}
