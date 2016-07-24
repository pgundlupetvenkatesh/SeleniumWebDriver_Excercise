/**
 * 
 */
package com.veeva.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Pratik
 *
 */
public class AddMassPromoCall {
	WebDriver ie;
	public AddMassPromoCall(WebDriver driver) {
		this.ie = driver;
	}
	By record_type = By.id("RecordTypeId");
	By cholecap_checkbox = By.id("chkd_a00U0000006DoZJIA0");
	By labrinone_checkbox = By.id("chkda00U000000W2Bg4IAF_a00U0000006DoZNIA0");
	By restolar_video = By.id("chka00U0000006DoVNIA0");
	By cholecap_checkbox_name = By.xpath(".//label[@for='chkd_a00U0000006DoZJIA0']");
	By labrinone_checkbox_name = By.xpath(".//label[@for='chkda00U000000W2Bg4IAF_a00U0000006DoZNIA0']");
	By quantity = By.xpath(".//input[@ng-change='quantityChanged(row)']");
	By save_button = By.xpath(".//td[@id='bottomButtonRow']/span[1]/input[@title='Save']");
	By product_dropdown_1 = By.xpath("//span/select[@ng-model='discussion.Product_vod__c']/option[2][@selected='selected']");
	By product_dropdown_2 = By.xpath("//span/select[@ng-model='discussion.Product_vod__c']/option[3][@selected='selected']");
	By call_discussion_section = By.xpath(".//div[@ng-init='initDiscussion(discussion)']");
	By saved_status = By.xpath(".//span[@ng-if='!editable']");
	
	public void recordType(String recType) {
		Select recordTypeID = new Select (ie.findElement(record_type));
		recordTypeID.selectByVisibleText(recType);
	}
	
	public void samplePromoItem() {
		ie.findElement(restolar_video).click();
	}
	
	public void quantity(String qnty) {
		WebElement textField = ie.findElement(quantity);	//Getting the element of the Quantity field to update it.
		textField.clear();
		textField.sendKeys(qnty);
	}
	
	public void clickSave() {
		ie.findElement(save_button).click();
	}
	
	public String checkboxDetails(String str) {
		String checkBoxText = null;
		if(str.equalsIgnoreCase("Cholecap")) {
			ie.findElement(cholecap_checkbox).click();
			checkBoxText = ie.findElement(cholecap_checkbox_name).getText();
		}
		if(str.equalsIgnoreCase("Labrinone")) {
			ie.findElement(labrinone_checkbox).click();
			checkBoxText = ie.findElement(labrinone_checkbox_name).getText();
		}
		return checkBoxText;
	}
	
	public String productDropdown(String product) {
		String dropdownText = null;
		if(product.equalsIgnoreCase("Cholecap")) {
			dropdownText = ie.findElement(product_dropdown_1).getText();
		}
		if(product.equalsIgnoreCase("Labrinone")) {
			dropdownText = ie.findElement(product_dropdown_2).getText();
		}
		return dropdownText;
	}
	
	//This function counts the sub-sections in the call discussion section.
	public int productsRowCount() {
		return ie.findElements(call_discussion_section).size();		//To get the count of the Call Discussion sections.
	}
	
	//This function will check the Status after Save button for call report is clicked.
	public String callRepeortStatus() {
		List<WebElement> weLst = ie.findElements(saved_status);		//Getting the span element items into a list.
		WebElement getElement = weLst.get(1);						//Fetching the second item from the list
		String status = getElement.getText();
		return status;
	}
}
