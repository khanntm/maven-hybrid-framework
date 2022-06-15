package pageObject.portal.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.HomePageUI;
import pageUIs.nopCommerce.user.RegisterPageUI;

public class UserHomePageObject extends BasePage {
	//bien gloal
	private WebDriver driver;
		
	public	UserHomePageObject(WebDriver driver) {
		//neu co có tao thì nó se tạo ngầm mac dinh ko có tham so ntn
		//ien local
		this.driver = driver;
		System.out.println("Driver at class HomePageOject = " + driver.toString());
	}
		public UserRegisterPageObject clickToRegisterLink() {
			waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
			clickToElement(driver,HomePageUI.REGISTER_LINK);
			return PageGeneratorManager.getUserRegisterPage(driver);
			 
		}
		public UserLoginPageObject clickToLoginLinkUser() {
			waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
			clickToElement(driver, HomePageUI.LOGIN_LINK);
			// Cach 2 van chua toi uu Page Generator Manager
			//return new LoginPageObject(driver);
			
			//cach 3
			return PageGeneratorManager.getUserLoginPage(driver);
			
		}
		public String getMyAccountLink(String string) {
			waitForElementVisible(driver,HomePageUI.MY_ACCOUNT_LINK);
			return getElementText(driver,HomePageUI.MY_ACCOUNT_LINK);
			
		}
		public boolean isMyAccountLinkDisplayed() {
			waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
			return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
		}
		public UserCustomerInfoPageObject clickToMyAccountLink() {
			waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
			clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
			return PageGeneratorManager.getUserCustomerInforPage(driver);	
		}
		

}
