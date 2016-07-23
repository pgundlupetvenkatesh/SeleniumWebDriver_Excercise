package CallReport;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.veeva.pages.AccountsPage;
import com.veeva.pages.HomePage;
import com.veeva.pages.LoginPage;

public class SaveCallReport extends SetUpTearDown  {
	@Test
	public void login() {												//Logging into the application with valid username and password.
		LoginPage loginObj = new LoginPage(ie);
		loginObj.loginToapp("****", "****");
		ie.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	//Using implicit timeout for 10 secs so that the home page loads complete.
	}
	
	@Test (dependsOnMethods={"login"})
	public void homePage() {
		HomePage hmpgeObj = new HomePage(ie);
		hmpgeObj.myAccountsMenu();										//Clicking the My Account tab
	}
	
	@Test (dependsOnMethods={"homePage"})
	public void accountHolder() {
		AccountsPage accObj = new AccountsPage(ie);
		accObj.accountName();											//Clicking Mark Canter in the side window panel
	}
	
	@Test (dependsOnMethods={"accountHolder"})
	public void saveCallRreport() throws InterruptedException {					//This function creates a new call report
		WebDriverWait wait = new WebDriverWait(ie, 500);						//Setting explicit wait time
		ie.findElement(By.name("record_a_call")).click();						//Click on the Record a Call button.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("RecordTypeId")));	//Explicitly Wait till the set time until Record Type Id dropdown is visible.  
		Select record_type = new Select (ie.findElement(By.id("RecordTypeId")));
		record_type.selectByValue("string:012U0000000MBvLIAW");								//Select text Mass Add Promo Call from the dropdown
		Thread.sleep(20000);
		String checkBoxCholecap = checkboxDetails("chkd_a00U0000006DoZJIA0");							//clicked Cholecap check-box
		String checkBoxLabrinone = checkboxDetails("chkda00U000000W2Bg4IAF_a00U0000006DoZNIA0");		//Clicked Labrinone check-box
		//To get the text for 1st product drop-down value
		String product1 = ie.findElement(By.xpath("//span/select[@ng-model='discussion.Product_vod__c']/option[2][@selected='selected']")).getText();
		//To get the text for 2nd product drop-down value
		String product2 = ie.findElement(By.xpath("//span/select[@ng-model='discussion.Product_vod__c']/option[3][@selected='selected']")).getText();
		System.out.println("There are " + subSectionCount("initDiscussion(discussion)") + " sub-section(s) created");	//Get the count of the call Discussion sub-section
		System.out.println("Product " + checkBoxCholecap + ":" + product1.contains(checkBoxCholecap));	
		System.out.println("Product " + checkBoxLabrinone + ":" + product2.contains(checkBoxLabrinone));	
		System.out.println("First value in the Product drop-down is set to " + product1);	//Verifying the 1st product drop-down data.
		System.out.println("Second value in the Product drop-down is set to " + product2);	//Verifying the 2nd product drop-down data.
		ie.findElement(By.id("chka00U0000006DoVNIA0")).click();								//Checking Restolar Video check-box
		quantity("quantityChanged(row)");
		ie.findElement(By.xpath(".//input[@title='Save']")).click();						//Saving a Call Report	
		Thread.sleep(10000);
		System.out.println("Call Report successfully " + callRepeortStatus("!editable"));	//Displaying the saved text to make sure Call Report is saved.
/*		String s = ie.findElement(By.xpath(".//h2[@class='pageDescription ng-binding']")).getText();
		Assert.assertNotEquals(s, "New Mass Add Promo Call", "Mass add promo call saved!");	//Checks for Call report number*/	
}
	
	public String checkboxDetails(String str) {
		ie.findElement(By.id(str)).click();
		String checkBoxText = ie.findElement(By.xpath(".//label[@for='" + str + "']")).getText();
		return checkBoxText;
	}
	
	public void quantity(String str) {
		WebElement textField = ie.findElement(By.xpath(".//input[@ng-change='" + str + "']"));	//Getting the element of the Quantity field to update it.
		textField.clear();
		textField.sendKeys("2");
	}
	
	@Test (description = "This function will check the Status after Save button for call report is clicked.")
	public String callRepeortStatus(String str) {
		List<WebElement> weLst = ie.findElements(By.xpath(".//span[@ng-if='" + str + "']"));	//Getting the span element items into a list.
		WebElement getElement = weLst.get(1);													//Fetching the second item from the list
		String status = getElement.getText();
		return status;
	}
	
	@Test (description = "This function counts the sub-sections in the call discussion section.")
	public int subSectionCount(String str) {
		int count = ie.findElements(By.xpath(".//div[@ng-init='" + str + "']")).size();	//To get the count of the Call Discussion sections.
		return count;
	}
	
	@Test(dependsOnMethods={"saveCallRreport"}, description = "Logging out from Veeva CRM")
	public void logout() {
		ie.findElement(By.id("userNav")).click();
		ie.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		ie.findElement(By.xpath(".//a[@title='Logout']")).click();
	}
}
