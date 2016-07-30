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
public class AccountsPagePF {
		WebDriver ie;
		public AccountsPagePF(WebDriver driver) {
			this.ie = driver;
		}
		
		@FindBy(how = How.XPATH, using = ".//a[@class = 'personaccountMru']") WebElement accountName;
		@FindBy(how = How.NAME, using = "record_a_call") WebElement record_call; 
		
		public void accountName() {
			accountName.click();
		}
		
		public void action() {
			record_call.click();
		}
}
