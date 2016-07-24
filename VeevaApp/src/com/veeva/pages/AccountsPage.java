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
	By record_call = By.name("record_a_call");
	
	public void accountName() {
		ie.findElement(accountName).click();
	}
	
	public void action() {
		ie.findElement(record_call).click();
	}
}
