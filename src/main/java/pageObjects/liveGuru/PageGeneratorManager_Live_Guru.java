package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager_Live_Guru {
	
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}

	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}

	public static MyDashboardPageObject getMyDashboardPage(WebDriver driver) {
		return new MyDashboardPageObject(driver);
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	public static AccountDashboardPageObject getAccountDashboardPage(WebDriver driver) {
		return new AccountDashboardPageObject(driver);
	}
	
	public static AccountInformationPageObject getAccountInformationPage(WebDriver driver) {
		return new AccountInformationPageObject(driver);
	}
	
	public static AddressBookPageObject getAddressBookPage(WebDriver driver) {
		return new AddressBookPageObject(driver);
	}
	
	public static MyOrdersPageObject getMyOrdersPage(WebDriver driver) {
		return new MyOrdersPageObject(driver);
	}
	public static BilingAgreementPageObject getBillingAgreementPage(WebDriver driver) {
		return new BilingAgreementPageObject(driver);
	}
	public static RecurringProfilesPageObject getRecurringProfilesPage(WebDriver driver) {
		return new RecurringProfilesPageObject(driver);
	}
	public static MyProductReviewPageObject getMyProductReviewPage(WebDriver driver) {
		return new MyProductReviewPageObject(driver);
	}

	

}
