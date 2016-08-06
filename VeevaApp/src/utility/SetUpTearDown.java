package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

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
		return driver = browserChoose("ie");
	}
	
	@BeforeTest
	public void InvokeUrl() {
		driver.get(obj.appUrl());						//Invoking test URL
		driver.manage().window().maximize();			//Maximizing the browser window.
	}
	
	@AfterSuite
	public void Exit() {
		driver.quit();
	}
	
	public boolean implicitTime(int time) {
		try {
			driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
			System.out.println("Waited for " + time + " Seconds.");
		}
		catch(Exception e) {
			return false;
		}
		return true;
	}
}
