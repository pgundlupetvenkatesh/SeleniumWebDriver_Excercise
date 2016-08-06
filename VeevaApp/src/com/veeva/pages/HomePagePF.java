/**
 * 
 */
package com.veeva.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

/**
 * @author Pratik
 *
 */
public class HomePagePF {
		WebDriver driver;
		public static final String pageTitle = "Salesforce - Enterprise Edition";
		public HomePagePF(WebDriver lDriver) {
			this.driver = lDriver;
		}
		
		@FindBy(how = How.XPATH, using=".//a[@title = 'My Accounts Tab']") private WebElement accountMenu;
		@FindBy(how = How.XPATH, using = ".//a[@title = 'Medical Inquiries Tab']") private WebElement MedInquiry;
		
		public void verifyHomePageTitle() {
			Assert.assertEquals(driver.getTitle(), pageTitle, "Possible defect - Home page title mismatch.");
		}
		
		public void menuItem(String item) {
			if(item.equalsIgnoreCase("My Accounts")) {
				accountMenu.click();
			}
			else if(item.equalsIgnoreCase("Medical Inquiries")) {
				MedInquiry.click();
			}
			else {
				System.out.println("Possible Defect - Not a valid menu item.");
			}
		}
}
