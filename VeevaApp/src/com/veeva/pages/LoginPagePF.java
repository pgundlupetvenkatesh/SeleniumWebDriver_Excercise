/**
 * 
 */
package com.veeva.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Pratik
 *
 */
public class LoginPagePF {
	
	WebDriver driver;
	public LoginPagePF(WebDriver lDriver) {
		this.driver = lDriver;
	}
	
	@FindBy(how = How.ID, using="username") @CacheLookup private WebElement user_name;
	@FindBy(how = How.ID, using="password") @CacheLookup private WebElement password;
	@FindBy(how = How.ID, using="Login") @CacheLookup private WebElement login;
	@FindBy(how = How.ID, using="rememberUn") private WebElement remember_me;
	
	public void loginToapp(String un, String pwd) {
		user_name.sendKeys(un);
		password.sendKeys(pwd);
		login.click();
	}
}
