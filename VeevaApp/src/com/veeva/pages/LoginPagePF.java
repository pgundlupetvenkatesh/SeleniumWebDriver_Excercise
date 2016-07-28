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
public class LoginPagePF {
	
	WebDriver ie;
	public LoginPagePF(WebDriver driver) {
		this.ie = driver;
	}
	
	@FindBy(how = How.ID, using="username") WebElement user_name;
	@FindBy(how = How.ID, using="password") WebElement password;
	@FindBy(how = How.ID, using="Login") WebElement login;
	@FindBy(how = How.ID, using="rememberUn") WebElement remember_me;
	
	public void loginToapp(String un, String pwd) {
		user_name.sendKeys(un);
		password.sendKeys(pwd);
		login.click();
	}

}
