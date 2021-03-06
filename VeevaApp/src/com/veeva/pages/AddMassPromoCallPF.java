/**
 * 
 */
package com.veeva.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Pratik
 *
 */
public class AddMassPromoCallPF {
		WebDriver driver;
		public AddMassPromoCallPF(WebDriver lDriver) {
			this.driver = lDriver;
		}
		
		@FindBy(how = How.ID, using = "RecordTypeId") WebElement record_type;
		@FindBy(how = How.ID, using = "chkd_a00U0000006DoZJIA0") WebElement cholecap_checkbox;
		@FindBy(how = How.ID, using = "chkda00U000000W2Bg4IAF_a00U0000006DoZNIA0") WebElement labrinone_checkbox;
		@FindBy(how = How.ID, using = "chka00U0000006DoVNIA0") WebElement restolar_video;
		@FindBy(how = How.XPATH, using = ".//label[@for='chkd_a00U0000006DoZJIA0']") WebElement cholecap_checkbox_name;
		@FindBy(how = How.XPATH, using = ".//label[@for='chkda00U000000W2Bg4IAF_a00U0000006DoZNIA0']") WebElement labrinone_checkbox_name;
		@FindBy(how = How.XPATH, using = ".//input[@ng-change='quantityChanged(row)']") WebElement quantity;
		@FindBy(how = How.XPATH, using = ".//td[@id='bottomButtonRow']/span[1]/input[@title='Save']") WebElement save_button;
		@FindBy(how = How.XPATH, using = "//span/select[@class='ng-pristine ng-untouched ng-valid']/option[2][@selected='selected']") WebElement product_dropdown_1;
		@FindBy(how = How.XPATH, using = "//span/select[@class='ng-pristine ng-untouched ng-valid']/option[3][@selected='selected']") WebElement product_dropdown_2;
		@FindBy(how = How.XPATH, using = ".//div[@ng-init='initDiscussion(discussion)']") List<WebElement> call_discussion_section;
		@FindBy(how = How.XPATH, using = ".//span[@ng-if='!editable']") List<WebElement> saved_status;
		
		//Used for Explicit waits as FinBy were a bit tricky to handle, working on it though!!!
		By by_record_type = By.id("RecordTypeId");
		By cholecap = By.id("chkd_a00U0000006DoZJIA0");
		
		public void explicitWait(long secs, By elementName) {
			WebDriverWait wait = new WebDriverWait(driver, secs);
			wait.until(ExpectedConditions.visibilityOfElementLocated(elementName));	//waits until div main_section loads
		}
		
		//Explicit wait for a page section to load. I would use this function when I load the page a the start so that the div sections load.
		public void explicitWait(long secs) {
			WebDriverWait wait = new WebDriverWait(driver, secs);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("veeva-app")));	//waits until div main_section loads
		}
		
		public void recordType(String recType) {
			Select recordTypeID = new Select (record_type);
			recordTypeID.selectByVisibleText(recType);
		}
		
		public void samplePromoItem() {
			restolar_video.click();
		}
		
		public void quantity(String qnty) {
			WebElement textField = quantity;	//Getting the element of the Quantity field to update it.
			textField.clear();
			textField.sendKeys(qnty);
		}
		
		public void clickSave() {
			save_button.click();
		}
		
		public String checkboxDetails(String str) {
			String checkBoxText = null;
			explicitWait(60, cholecap);	//Waits till the element displays and the max. wait time is 60 secs.
			if(str.equalsIgnoreCase("Cholecap")) {
				cholecap_checkbox.click();
				checkBoxText = cholecap_checkbox_name.getText();
			}
			if(str.equalsIgnoreCase("Labrinone")) {
				labrinone_checkbox.click();
				checkBoxText = labrinone_checkbox_name.getText();
			}
			return checkBoxText;
		}
		
		public String productDropdown(String product) {
			String dropdownText = null;
			if(product.equalsIgnoreCase("Cholecap")) {
				dropdownText = product_dropdown_1.getText();
			}
			if(product.equalsIgnoreCase("Labrinone")) {
				new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(product_dropdown_2));
				dropdownText = product_dropdown_2.getText();
			}
			return dropdownText;
		}
		
		//This function counts the sub-sections in the call discussion section.
		public int productsRowCount() {
			return call_discussion_section.size();		//To get the count of the Call Discussion sections.
		}
		
		//This function will check the Status after Save button for call report is clicked.
		public String callRepeortStatus() {
			List<WebElement> weLst = saved_status;		//Getting the span element items into a list.
			WebElement getElement = weLst.get(1);						//Fetching the second item from the list
			String status = getElement.getText();
			return status;
		}
}