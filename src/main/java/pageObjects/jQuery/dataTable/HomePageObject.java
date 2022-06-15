package pageObjects.jQuery.dataTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.dataTable.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingByPageNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
	}

	public void enterToHeaderTextBoxByLabel(String headerLable, String inputValue) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_LABLE_NAME, headerLable);
		//Dynamic locator phai truyen sau, neu ko chay sai
		//sendkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABLE_NAME, inputValue, headerLable);
		sendkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABLE_NAME, inputValue, headerLable);
		pressKeyToElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, Keys.ENTER, headerLable);
		
	}

	public boolean isPageNumerActived(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGINATION_PAGE_ACTIVED_BY_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGINATION_PAGE_ACTIVED_BY_NUMBER, pageNumber);
	}

	public List<String> getValueEachRowAtAllPage() {
		int totalPage = getElementSize(driver, HomePageUI.TOTAL_PAGINATION);
		System.out.println("Total size: " + totalPage);
		
		//List String thì cho phép lấy ra danh sách trùng
		List<String> allRowValueAllPage = new ArrayList<String>();
		
		//Neu muon lay ra danh sách ko trung dùng Set<String>. Thay List = Set thi khi luu vao no chỉ lấy giá tri 
		//Set<String> allRowValueUniqueAllPage = new HashSet<String>();
		
		//Duyet qua tat ca các page number của paging
		for (int index = 1; index <= totalPage; index++) {
			clickToElement(driver,HomePageUI.PAGINATION_PAGE_INDEX, String.valueOf(index));
			//sleepInSecond(2);
			
			//Get text cua all row moi page đưa vào array list
			//List<WebElement> allRowElementEachPage = getListWebElement(driver, HomePageUI.ALL_ROW_EACH_PAGE);
			List<WebElement> allRowElementEachPage = getListWebElement(driver, HomePageUI.ALL_COUNTRY_EACH_PAGE);
			for (WebElement eachRow : allRowElementEachPage) {
				allRowValueAllPage.add(eachRow.getText());
			}
		}
		//In tat ca gia tri row ra - cua tat ca cac page
		for (String value : allRowValueAllPage) {
			
			//System.out.println("-----------------------------------");	
			System.out.println(value);	
		}
		
		return allRowValueAllPage;
		
	}

	public void enterToTextboxAtRowNumberByColumnName(String columnName, String rowNumber, String valueToEnter) {
		//Lấy ra toàn bộ người anh của cột cần input + 1
		//columnIndex: lay vi tri index cua cot can input
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		
		//Sendkey vào dòng nào e.g: rowNumber = 1 
		waitForElementVisible(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		////tbody/tr[1]/td[2]/input
		sendkeyToElement(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, valueToEnter, rowNumber, String.valueOf(columnIndex));
		
		
	}

	public void selectDropDowAtRowNumberByColumnName(String columnName, String rowNumber, String valueToSelect) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex)); 
		selectItemInDefaultDropdown(driver, HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, valueToSelect, rowNumber, String.valueOf(columnIndex));
	}

	public void clickToLoadButton() {
		waitForElementClickable(driver, HomePageUI.LOAD_BUTTON);
		clickToElement(driver, HomePageUI.LOAD_BUTTON);
		
	}

	public void checkOnCheckboxAtRowNumberByColumnName(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		checkToDefaultCheckboxOrRadio(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
	}

	public void uncheckOnCheckboxAtRowNumberByColumnName(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;	
		waitForElementClickable(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		uncheckToDefaultCheckbox(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
	}

	public void clickToIconByRowNumber(String rowNumber, String nameOfButton) {
		waitForElementClickable(driver, HomePageUI.ICON_NAME_BY_ROW_NUMBER, rowNumber, nameOfButton);
		clickToElement(driver, HomePageUI.ICON_NAME_BY_ROW_NUMBER, rowNumber, nameOfButton);
	}

	

	
	
	

	
	
}
