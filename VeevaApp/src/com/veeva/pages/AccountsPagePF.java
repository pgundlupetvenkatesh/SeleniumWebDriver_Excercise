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
		WebDriver driver;
		public AccountsPagePF(WebDriver lDriver) {
			this.driver = lDriver;
		}
		
		@FindBy(how = How.XPATH, using = ".//*[@id='mru001U000000kOv0z']/a[@class = 'personaccountMru']") private WebElement accountName;
		@FindBy(how = How.NAME, using = "record_a_call") private WebElement record_call; 
		
		public void accountName() {
			accountName.click();
		}
		
		public void action() {
			record_call.click();
		}
}
