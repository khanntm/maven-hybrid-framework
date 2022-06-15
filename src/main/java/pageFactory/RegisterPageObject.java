package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;
import pageUIs.nopCommerce.user.RegisterPageUI;

public class RegisterPageObject extends BasePageFactory {
private WebDriver driver;
	
	public RegisterPageObject(WebDriver driver)  {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "FistName")
	private WebElement firstNameTextbox;
	
	@FindBy(id = "LastName")
	private WebElement lastNameTextbox;
	
	@FindBy(id = "Email")
	private WebElement emailTextbox;
	
	@FindBy(id = "Password")
	private WebElement passwordTextbox;
	
	@FindBy(id = "ConfirmPassword")
	private WebElement confirmPasswordTextbox;
	
	@FindBy(id = "register-button")
	private WebElement registerButton;
	
	@FindBy(id = "FirstName-error")
	private WebElement firstNameErrorMessage;
	
	@FindBy(id = "LastName-error")
	private WebElement lastNameErrorMessage;
	
	@FindBy(id = "Email-error")
	private WebElement emailErrorMessage;
	
	@FindBy(id = "Password-error")
	private WebElement passwordErrorMessage;
	
	@FindBy(id = "ConfirmPassword-error")
	private WebElement confirmPasswordErrorMessage;
	
	@FindBy(css = "div.result")
	private WebElement registerEmailErrorMessage;
	
	@FindBy(xpath = "//a[@class='ico-logout']")
	private WebElement logoutLink;
	
	@FindBy(xpath = "//div[contains(@class,'message-error')]")
	private WebElement existingEmailErrorMessage;
	
	
	
	public void clickToRegisterButton() {
		waitForElementClickable(driver,registerButton);
		clickToElement(driver,registerButton);
	}

	public String getErrorMessageAtFirstNameTextbox() {
		waitForElementClickable(driver,firstNameErrorMessage);
		return getElementText(driver,firstNameErrorMessage);
	}

	public String getErrorMessageAtLastNameTextbox() {
		waitForElementClickable(driver,lastNameErrorMessage);
		return getElementText(driver,lastNameErrorMessage);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementClickable(driver,emailErrorMessage);
		return getElementText(driver,emailErrorMessage);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementClickable(driver,passwordErrorMessage);
		return getElementText(driver,passwordErrorMessage);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementClickable(driver,confirmPasswordErrorMessage);
		return getElementText(driver,confirmPasswordErrorMessage);
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver,firstNameTextbox);
		sendkeyToElement(driver,firstNameTextbox,firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver,lastNameTextbox);
		sendkeyToElement(driver,lastNameTextbox,lastName);		
	}

	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver,emailTextbox);
		sendkeyToElement(driver,emailTextbox,emailAddress);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver,passwordTextbox);
		sendkeyToElement(driver,passwordTextbox,password);	
	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver,confirmPasswordTextbox);
		sendkeyToElement(driver,confirmPasswordTextbox,confirmPassword);		
	}

	public String getRegisterSuccessMessage() {
		waitForElementClickable(driver,registerEmailErrorMessage);
		return getElementText(driver,registerEmailErrorMessage);
	}
	public void clickToLogoutLink() {
		waitForElementClickable(driver,logoutLink);
		clickToElement(driver,logoutLink);
	}

	public String getErrorExistingEmailMessage() {
		waitForElementVisible(driver,existingEmailErrorMessage);
		return getElementText(driver,existingEmailErrorMessage);
	}

}
