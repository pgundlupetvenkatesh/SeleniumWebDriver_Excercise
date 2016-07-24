/**
 * 
 */
package com.veeva.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Pratik
 *	Page object of login page
 */
public class LoginPage {
	WebDriver ie;
	public LoginPage(WebDriver driver) {
		this.ie = driver;
	}
	By user_name = By.id("username");
	By password = By.id("password");
	By login = By.id("Login");
	By remember_me = By.id("rememberUn");
	By forgot_password = By.id("forgot_password_link");
	By custom_domain = By.id("mydomainLink");
	By try_free = By.id("signup_link");
	
	public void rememberMe() {
		ie.findElement(remember_me).click();
	}
	
	public void forgotPassword() {
		ie.findElement(forgot_password).click();
	}
	
	public void customDomain() {
		ie.findElement(custom_domain).click();
	}
	
	public void tryForFree() {
		ie.findElement(try_free).click();
	}
	
	public void loginToapp(String un, String pwd) {
		ie.findElement(user_name).sendKeys(un);
		ie.findElement(password).sendKeys(pwd);
		ie.findElement(login).click();
	}

}
