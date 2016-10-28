package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.veeva.pages.LogoutPF;

public class SetUpTearDown {
	public WebDriver driver;
	Setup obj = new Setup();
	
	public WebDriver browserChoose(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", obj.getChromeDriver());
			driver = new ChromeDriver();
		}
		else {
			System.setProperty("webdriver.ie.driver", obj.getIEDriver());
			driver = new InternetExplorerDriver();
		}
		return driver;
	}
	
	@BeforeSuite
	public WebDriver initializeBrowser() {
		return driver = browserChoose("ie"); //to run in google chrome browser use 'chrome'
	}
	
	@BeforeTest
	public void InvokeUrl() {
		driver.get(obj.appUrl());						//Invoking test URL
		driver.manage().window().maximize();			//Maximizing the browser window.
		driver.manage().deleteAllCookies();
	}
	
	@AfterTest
	public void logout() {
		LogoutPF logoutObj = PageFactory.initElements(driver, LogoutPF.class);
		logoutObj.userLogout();
	}
	
	@AfterSuite
	public void Exit() {
		driver.quit();
	}
}
