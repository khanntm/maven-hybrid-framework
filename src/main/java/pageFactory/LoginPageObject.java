package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;
import pageUIs.nopCommerce.user.LoginPageUI;

public class LoginPageObject extends BasePageFactory {
private WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="Email")
	private WebElement emailTextbox;
	
	@FindBy(id="Password")
	private WebElement passwordTextbox;

	@FindBy(xpath="//button[contains(@class,'login-button')]")
	private WebElement loginButton;
	
	@FindBy(id="Email-error")
	private WebElement emailErrorMessage;
	
	@FindBy(xpath="//div[contains(@class,'validation-summary-errors')]")
	private WebElement errorMessageOnTopRegisterWrongEmptyEmail;
	
	public void clickToLoginButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, emailErrorMessage);
		return getElementText(driver, emailErrorMessage);
	}

	public void inputToEmailTextbox(String emailAddressLogin) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, emailAddressLogin);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);
	}

	public String getErrorMessageNotRegistWrongOrEmptyPassword() {
		waitForElementVisible(driver, errorMessageOnTopRegisterWrongEmptyEmail);
		return getElementText(driver, errorMessageOnTopRegisterWrongEmptyEmail);
	}

	
}
