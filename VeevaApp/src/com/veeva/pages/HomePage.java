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
public class HomePage {
	WebDriver ie;
	public HomePage(WebDriver driver) {
		this.ie = driver;
	}
	
	By accountMenu = By.xpath(".//a[@title = 'My Accounts Tab']");
	
	public void myAccountsMenu() {
		ie.findElement(accountMenu).click();
	}
}
