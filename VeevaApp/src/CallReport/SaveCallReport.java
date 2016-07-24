package CallReport;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.veeva.pages.AccountsPage;
import com.veeva.pages.AddMassPromoCall;
import com.veeva.pages.HomePage;
import com.veeva.pages.LoginPage;
import com.veeva.pages.Logout;

public class SaveCallReport extends SetUpTearDown  {
	@Test
	public void login() {												//Logging into the application with valid username and password.
		LoginPage loginObj = new LoginPage(ie);
		loginObj.loginToapp("***", "***");
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
		accObj.action();												//Click on the Record a Call button.
		ie.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test (dependsOnMethods={"accountHolder"})
	public void saveCallRreport() throws InterruptedException {			//This function creates a new call report  
		AddMassPromoCall promoCallObj = new AddMassPromoCall(ie);
		promoCallObj.recordType("Mass Add Promo Call");
		Thread.sleep(20000);
		String checkBox1 = promoCallObj.checkboxDetails("Cholecap");	//click Cholecap & Labrinone check-box
		String checkBox2 = promoCallObj.checkboxDetails("Labrinone");
		String product1 = promoCallObj.productDropdown("Cholecap");		//To get the text for 1st product drop-down value
		String product2 = promoCallObj.productDropdown("Labrinone");	//To get the text for 2nd product drop-down value
		Assert.assertEquals(promoCallObj.productsRowCount(), 2, "Possible defect - Product row count mismatch.");	//Get the count of the call Discussion sub-section
		Assert.assertEquals(checkBox1, product1, "Possible defect - Cholecap product mismatch");
		Assert.assertTrue(product2.contains(checkBox2), "Possible defect - Lebrinone product mismatch");
		promoCallObj.samplePromoItem();								//Checking Restolar Video check-box
		promoCallObj.quantity("2");
		promoCallObj.clickSave();									//Saving a Call Report	
		Thread.sleep(10000);
		Assert.assertEquals(promoCallObj.callRepeortStatus(), "Saved", "Possible defect - Call Report is not saved.");
	}
	
	@Test(dependsOnMethods={"saveCallRreport"}, description = "Logging out from Veeva CRM")
	public void logout() {
		Logout logoutObj = new Logout(ie);
		logoutObj.userLogout();
	}
}
