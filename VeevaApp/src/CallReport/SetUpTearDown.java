package CallReport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class SetUpTearDown {
	public WebDriver ie;
	Setup obj = new Setup();
	
	@BeforeSuite
	public void initializeBrowser() {
		System.setProperty("webdriver.ie.driver", obj.getDriver());
		ie = new InternetExplorerDriver();
	}
	
	@BeforeTest
	public void InvokeUrl() {
		ie.get(obj.appUrl());						//Invoking test URL
		ie.manage().window().maximize();			//Maximizing the browser window.
	}
	
	@AfterSuite
	public void Exit() {
		ie.quit();
	}
}
