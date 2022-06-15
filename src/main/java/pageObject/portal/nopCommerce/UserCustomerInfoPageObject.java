package pageObject.portal.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.CustomerInforPageUI;
import pageUIs.nopCommerce.user.HomePageUI;
import pageUIs.nopCommerce.user.RegisterPageUI;

public class UserCustomerInfoPageObject extends BasePage {
	//bien gloal
	private WebDriver driver;
		
	public	UserCustomerInfoPageObject(WebDriver driver) {
		//neu co có tao thì nó se tạo ngầm mac dinh ko có tham so ntn
		//ien local
		this.driver = driver;
		System.out.println("Driver at class MyAccountPageOject = " + driver.toString());
	}

	public boolean isCustomerInforPageDisplayed() {
		waitForElementVisible(driver, CustomerInforPageUI.CUSTOMER_INFOR_HEADER);
		return isElementDisplayed(driver, CustomerInforPageUI.CUSTOMER_INFOR_HEADER);
	}

	
	
	

}
