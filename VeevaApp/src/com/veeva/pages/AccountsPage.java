/**
 * 
 */
package com.veeva.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Pratik
 *
 */
public class AccountsPage {
	WebDriver ie;
	public AccountsPage(WebDriver driver) {
		this.ie = driver;
	}
	By accountName = By.xpath(".//a[@class = 'personaccountMru']");
	
	public void accountName() {
		ie.findElement(accountName).click();
	}
}
