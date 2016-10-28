/**
 * 
 */
package com.veeva.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		
		public void implicitWait(long time) {
			driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		}
		
		public void explicitWait(long secs) {
			AddMassPromoCallPF newCallReport = new AddMassPromoCallPF(driver);
			WebDriverWait wait = new WebDriverWait(driver, secs);
			wait.until(ExpectedConditions.visibilityOfElementLocated(newCallReport.by_record_type));	//waits until div main_section loads
		}
		
		public void accountName() {
			accountName.click();
		}
		
		public void action() {
			record_call.click();
		}
}
