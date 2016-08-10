/**
 * 
 */
package com.veeva.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * @author Pratik
 *
 */
public class MedicalInquiryPF {
	WebDriver driver;
	String medInqPageTitle = "Medical Inquiries: Home ~ Salesforce - Enterprise Edition";
	public MedicalInquiryPF(WebDriver lDriver) {
		this.driver = lDriver;
	}
	
	@FindBy(how = How.NAME, using = "new") private WebElement newButton;
	@FindBy(how = How.ID, using = "p3") private WebElement recordType;
	@FindBy(how = How.XPATH, using = ".//input[@title='Continue']") private WebElement continueButton;
	@FindBy(how = How.ID, using = "bPageBlocksecondaryPalette") private WebElement medInqSection;
	@FindBy(how = How.ID, using = "reqi-value:reference:Medical_Inquiry_vod__c:Account_vod__c") private WebElement infoAccount;
	@FindBy(how = How.ID, using = "reqi-value:picklist:Medical_Inquiry_vod__c:Source__c") private WebElement infoSource;
	@FindBy(how = How.ID, using = "dt_reqi-value:datetime:Medical_Inquiry_vod__c:Request_Date_TVA__c") private WebElement infoReqDate;
	@FindBy(how = How.ID, using = "tm_reqi-value:datetime:Medical_Inquiry_vod__c:Request_Date_TVA__c") private WebElement infoReqTime;
	@FindBy(how = How.ID, using = "reqi-value:picklist:Medical_Inquiry_vod__c:Delivery_Method_vod__c") private WebElement priLocation;
	@FindBy(how = How.ID, using = "AddrSelect") private WebElement address;
	@FindBy(how = How.ID, using = "reqi-value:picklist:Medical_Inquiry_vod__c:Product__c") private WebElement inqProduct;
	@FindBy(how = How.ID, using = "reqi-value:textarea:Medical_Inquiry_vod__c:Inquiry_Text__c") private WebElement inqText;
	@FindBy(how = How.ID, using = "pbButtonTableColSubmitBottom") private WebElement submitButton;
	@FindBy(how = How.ID, using = "errorDiv") private WebElement mainValidationMessage;
	@FindBy(how = How.ID, using = "datePicker") WebElement datePicker;
	
	public void verifyMedInquiryPageTitle() {
		Assert.assertEquals(driver.getTitle(), medInqPageTitle, "Possible defect - Medical Inquiry page title mismatch.");
	}
	
	public void validationMessage() {
		Assert.assertEquals(mainValidationMessage.getText(), "Error: Invalid Data.", "Possible defect - required field validation message not shown.");
	}
	
	public void sectionCheck() {
		System.out.println("Medical Inquiry Section - " + medInqSection);
	}

	public void ButtonClick(String item) {
		if(item.equalsIgnoreCase("New")) {
			newButton.click();
		}
		else if(item.equalsIgnoreCase("Continue")) {
			continueButton.click();
		}
		else if(item.equalsIgnoreCase("Submit")) {
			submitButton.click();
		}
		else {
			System.out.println("Possible Defect - Button name not in the page.");
		}
	}
	
	public void medInquiryRecordType(String recType) {
		Select recTypeID = new Select(recordType);
		recTypeID.selectByVisibleText(recType);
	}
	
	public void setInfoAccount(String accName) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(infoAccount));
		infoAccount.clear();
		infoAccount.sendKeys(accName);
	}
	
	public void setInfoSource(String src) {
		Select srcText = new Select(infoSource);
		srcText.selectByVisibleText(src);
	}
	
	public void setReqTime(String time) {
		Select reqTime = new Select(infoReqTime);
		reqTime.selectByVisibleText(time);
	}
	
	public void setReqDate(String date) {
		infoReqDate.click();
		infoReqDate.sendKeys(date);
	}
	
	public void setLocation(String priLoc) {
		Select loc = new Select(priLocation);
		loc.selectByVisibleText(priLoc);
	}
	
	public void setInqProduct(String pro) {
		Select product = new Select(inqProduct);
		product.selectByVisibleText(pro);
	}
	
	public void setInqText(String text) {
		inqText.clear();
		inqText.sendKeys(text);
	}
	
	public void setAddress(String addr) {
		Select addrs = new Select(address);
		addrs.selectByVisibleText(addr);
	}
}
