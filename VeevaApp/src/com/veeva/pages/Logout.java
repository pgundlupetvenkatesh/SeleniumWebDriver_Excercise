/**
 * 
 */
package com.veeva.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Pratik
 *
 */
public class Logout {
	WebDriver ie;
	public Logout(WebDriver driver) {
		this.ie = driver;
	}
	By user = By.id("userNav");
	By logout_link = By.xpath(".//a[@title='Logout']");
	
	public void userLogout() {
		ie.findElement(user).click();
		ie.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		ie.findElement(logout_link).click();
	}

}
