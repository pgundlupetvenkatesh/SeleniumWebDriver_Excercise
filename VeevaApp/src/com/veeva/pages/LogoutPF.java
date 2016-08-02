/**
 * 
 */
package com.veeva.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Pratik
 *
 */
public class LogoutPF {
		WebDriver driver;
		public LogoutPF(WebDriver lDriver) {
			this.driver = lDriver;
		}
		
		@FindBy(how = How.ID, using = "userNav") @CacheLookup private WebElement user;
		@FindBy(how = How.XPATH, using = ".//a[@title='Logout']") @CacheLookup private WebElement logout_link;
		
		public void userLogout() {
			user.click();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			logout_link.click();
		}
}
