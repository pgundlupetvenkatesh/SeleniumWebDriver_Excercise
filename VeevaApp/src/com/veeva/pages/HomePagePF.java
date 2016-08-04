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
		
		public void myAccountsMenu() {
			accountMenu.click();
		}
		
		public void verifyHomePageTitle() {
			Assert.assertEquals(driver.getTitle(), pageTitle, "Possible defect - Home page title mismatch.");
		}
}
