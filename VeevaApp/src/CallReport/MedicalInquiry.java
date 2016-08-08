/**
 * 
 */
package CallReport;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import utility.SetUpTearDown;

import com.veeva.pages.HomePagePF;
import com.veeva.pages.LoginPagePF;
import com.veeva.pages.LogoutPF;
import com.veeva.pages.MedicalInquiryPF;

/**
 * @author Pratik
 *
 */
public class MedicalInquiry extends SetUpTearDown {
	@Test
	public void login() {
		LoginPagePF obj = PageFactory.initElements(driver, LoginPagePF.class);
		obj.loginToapp("****", "****");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test (dependsOnMethods = {"login"})
	public void MedInqHomePage() {
		HomePagePF homeObj = PageFactory.initElements(driver, HomePagePF.class);
		MedicalInquiryPF medObj = PageFactory.initElements(driver, MedicalInquiryPF.class);
		homeObj.menuItem("Medical Inquiries");	//Clicking the Medical Inquiries menu item
		medObj.verifyMedInquiryPageTitle();
	}
	
	@Test(dependsOnMethods={"MedInqHomePage"}, description = "Logging out from application")
	public void logout() {
		LogoutPF logoutObj = PageFactory.initElements(driver, LogoutPF.class);
		logoutObj.userLogout();
	}
}
