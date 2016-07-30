/**
 * 
 */
package com.veeva.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Pratik
 *
 */
public class HomePagePF {
		WebDriver ie;
		public HomePagePF(WebDriver driver) {
			this.ie = driver;
		}
		
		@FindBy(how = How.XPATH, using=".//a[@title = 'My Accounts Tab']") WebElement accountMenu; 
		
		public void myAccountsMenu() {
			accountMenu.click();
		}
}
