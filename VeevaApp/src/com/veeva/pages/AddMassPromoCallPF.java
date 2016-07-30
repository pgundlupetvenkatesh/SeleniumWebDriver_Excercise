/**
 * 
 */
package com.veeva.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Pratik
 *
 */
public class AddMassPromoCallPF {
		WebDriver ie;
		public AddMassPromoCallPF(WebDriver driver) {
			this.ie = driver;
		}
		
		@FindBy(how = How.ID, using = "RecordTypeId") WebElement record_type;
		@FindBy(how = How.ID, using = "chkd_a00U0000006DoZJIA0") WebElement cholecap_checkbox;
		@FindBy(how = How.ID, using = "chkda00U000000W2Bg4IAF_a00U0000006DoZNIA0") WebElement labrinone_checkbox;
		@FindBy(how = How.ID, using = "chka00U0000006DoVNIA0") WebElement restolar_video;
		@FindBy(how = How.XPATH, using = ".//label[@for='chkd_a00U0000006DoZJIA0']") WebElement cholecap_checkbox_name;
		@FindBy(how = How.XPATH, using = ".//label[@for='chkda00U000000W2Bg4IAF_a00U0000006DoZNIA0']") WebElement labrinone_checkbox_name;
		@FindBy(how = How.XPATH, using = ".//input[@ng-change='quantityChanged(row)']") WebElement quantity;
		@FindBy(how = How.XPATH, using = ".//td[@id='bottomButtonRow']/span[1]/input[@title='Save']") WebElement save_button;
		@FindBy(how = How.XPATH, using = "//span/select[@ng-model='discussion.Product_vod__c']/option[2][@selected='selected']") WebElement product_dropdown_1;
		@FindBy(how = How.XPATH, using = "//span/select[@ng-model='discussion.Product_vod__c']/option[3][@selected='selected']") WebElement product_dropdown_2;
		@FindBy(how = How.XPATH, using = ".//div[@ng-init='initDiscussion(discussion)']") List<WebElement> call_discussion_section;
		@FindBy(how = How.XPATH, using = ".//span[@ng-if='!editable']") List<WebElement> saved_status;
		
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