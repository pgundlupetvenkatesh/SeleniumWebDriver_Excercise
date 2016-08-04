package CallReport;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.veeva.pages.AccountsPagePF;
import com.veeva.pages.AddMassPromoCallPF;
import com.veeva.pages.HomePagePF;
import com.veeva.pages.LoginPagePF;
import com.veeva.pages.LogoutPF;

public class SaveCallReport extends SetUpTearDown  {
	@Test
	public void login() {
		LoginPagePF obj = PageFactory.initElements(driver, LoginPagePF.class);
		obj.loginToapp("bb10@bb2.com", "bugb1234");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test (dependsOnMethods={"login"})
	public void homePage() {
		HomePagePF homeObj = PageFactory.initElements(driver, HomePagePF.class);
		homeObj.myAccountsMenu();			//Clicking the My Account tab
		homeObj.verifyHomePageTitle();
	}
	
	@Test (dependsOnMethods={"homePage"})
	public void accountHolder() {
		AccountsPagePF accObj = PageFactory.initElements(driver, AccountsPagePF.class);
		accObj.accountName();				//Clicking Mark Canter in the side window panel
		accObj.action();					//Click on the Record a Call button.
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test (dependsOnMethods={"accountHolder"})
	public void saveCallRreport() throws InterruptedException {			//This function creates a new call report
		AddMassPromoCallPF promoCallObj = PageFactory.initElements(driver, AddMassPromoCallPF.class);
		promoCallObj.recordType("Mass Add Promo Call");
		implicitTime(30);
		//Thread.sleep(20000);
		String checkBox1 = promoCallObj.checkboxDetails("Cholecap");	//click Cholecap & Labrinone check-box
		String checkBox2 = promoCallObj.checkboxDetails("Labrinone");
		String product1 = promoCallObj.productDropdown("Cholecap");		//To get the text for 1st product drop-down value
		String product2 = promoCallObj.productDropdown("Labrinone");	//To get the text for 2nd product drop-down value
		Assert.assertEquals(promoCallObj.productsRowCount(), 2, "Possible defect - Product row count mismatch.");	//Get the count of the call Discussion sub-section
		Assert.assertEquals(checkBox1, product1, "Possible defect - Cholecap product mismatch");
		Assert.assertTrue(product2.contains(checkBox2), "Possible defect - Lebrinone product mismatch");
		promoCallObj.samplePromoItem();		//Checking Restolar Video check-box
		promoCallObj.quantity("2");
		promoCallObj.clickSave();			//Saving a Call Report	
		implicitTime(20);
		//Thread.sleep(10000);
		Assert.assertEquals(promoCallObj.callRepeortStatus(), "Saved", "Possible defect - Call Report is not saved.");
	}
	
	@Test(dependsOnMethods={"saveCallRreport"}, description = "Logging out from Veeva CRM")
	public void logout() {
		LogoutPF logoutObj = PageFactory.initElements(driver, LogoutPF.class);
		logoutObj.userLogout();
	}
}