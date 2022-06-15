package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.facebook.LoginPageUI;

public class LoginPageObject extends BasePage{
	WebDriver driver;
	
	public LoginPageObject (WebDriver driver) {
		this.driver = driver;
}

	public void clickToCreateNewAccountButton() {
		waitForElementVisible(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
	}

	public boolean isEmailAddressTextboxDisplayd() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		return isElementDisplayed(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
	}

	public void enterToEmailAddressTextbox(String emailAddress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
	}

	public boolean isReEnterEmailTextboxDisplayed() {
		//Neu wait for Visible là se sai, nó chỉ đúng cho TH đã & đang hiển thị rồi
		return isElementDisplayed(driver, LoginPageUI.RE_ENTER_EMAIL_ADDRESS_TEXTBOX);
	}

	public void clickCloseIconAtRegisterForm() {
		waitForElementVisible(driver, LoginPageUI.CLOSE_ICON);
		clickToElement(driver, LoginPageUI.CLOSE_ICON);
		
	}

	public boolean isConfirmEmailAddressTextboxUndisplayed() {
		waitForElementUndisplayed(driver, LoginPageUI.RE_ENTER_EMAIL_ADDRESS_TEXTBOX);
		return isElementUndisplayed(driver, LoginPageUI.RE_ENTER_EMAIL_ADDRESS_TEXTBOX);
	}
}
