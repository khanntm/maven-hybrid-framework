package pageObject.portal.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.LoginPageUI;

public class UserLoginPageObject extends BasePage {
	private WebDriver driver;
	
	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
}

	public UserHomePageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public void inputToEmailTextbox(String emailAddressLogin) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddressLogin);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public String getErrorMessageNotRegistWrongOrEmptyPassword() {
		waitForElementVisible(driver, LoginPageUI.ERROR_MESSAGE_ON_TOP_NOT_REGISTER_WRONG_EMPTY_EMAIL);
		return getElementText(driver, LoginPageUI.ERROR_MESSAGE_ON_TOP_NOT_REGISTER_WRONG_EMPTY_EMAIL);
	}
	
	public UserHomePageObject loginAsUser(String emailAddressLogin, String password) {
		inputToEmailTextbox(emailAddressLogin);
		inputToPasswordTextbox(password);
		return clickToLoginButton();
	}
}
