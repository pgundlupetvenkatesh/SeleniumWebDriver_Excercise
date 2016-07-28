package CallReport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.veeva.pages.LoginPagePF;

public class SetUpTearDown {
	//public WebDriver ie;
	public WebDriver driver;
	Setup obj = new Setup();
	
	public WebDriver browserChoose(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", obj.getChromeDriver());
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", obj.getIEDriver());
			driver = new InternetExplorerDriver();
		}
		else {
			System.out.println("Possible Defect - Enter valid browser name.");
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
}
