package CallReport;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.veeva.pages.AccountsPagePF;
import com.veeva.pages.AddMassPromoCallPF;
import com.veeva.pages.HomePagePF;

public class SaveCallReport extends Login  {
	@Test (dependsOnMethods = {"login"})
	public void homePage() {
		HomePagePF homeObj = PageFactory.initElements(driver, HomePagePF.class);
		homeObj.menuItem("My Accounts");	//Clicking the My Accounts menu item
		homeObj.verifyHomePageTitle();
	}
	
	@Test (dependsOnMethods={"homePage"})
	public void accountHolder() {
		AccountsPagePF accObj = PageFactory.initElements(driver, AccountsPagePF.class);
		accObj.accountName();				//Clicking Mark Canter in the side window panel
		accObj.action();					//Click on the Record a Call button.
		accObj.explicitWait(80);
	}
	
	@Test (dependsOnMethods={"accountHolder"})
	public void saveCallRreport() throws InterruptedException {			//This function creates a new call report
		AddMassPromoCallPF promoCallObj = PageFactory.initElements(driver, AddMassPromoCallPF.class);
		promoCallObj.recordType("Mass Add Promo Call");
		promoCallObj.explicitWait(80);
		String checkBox1 = promoCallObj.checkboxDetails("Cholecap");	//click Cholecap & Labrinone check-box
		String checkBox2 = promoCallObj.checkboxDetails("Labrinone");
		String product1 = promoCallObj.productDropdown("Cholecap");		//To get the text for 1st product drop-down value
		String product2 = promoCallObj.productDropdown("Labrinone");	//To get the text for 2nd product drop-down value 
		//Assert.assertEquals(promoCallObj.productsRowCount(), 2, "Possible defect - Product row count mismatch.");	//Get the count of the call Discussion sub-section
		Assert.assertEquals(checkBox1, product2, "Possible defect - Cholecap product mismatch");
		Assert.assertTrue(product1.contains(checkBox2), "Possible defect - Lebrinone product mismatch");
		promoCallObj.samplePromoItem();		//Checking Restolar Video check-box
		promoCallObj.quantity("2");
		promoCallObj.clickSave();			//Saving a Call Report	
		Assert.assertEquals(promoCallObj.callRepeortStatus(), "Saved", "Possible defect - Call Report is not saved.");
	}
}