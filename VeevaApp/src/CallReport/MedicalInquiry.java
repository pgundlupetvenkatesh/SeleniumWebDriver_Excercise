/**
 * 
 */
package CallReport;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
	
	@Test(dependsOnMethods = {"login"})
	public void MedInqHomePage() {
		HomePagePF homeObj = PageFactory.initElements(driver, HomePagePF.class);
		MedicalInquiryPF medHomeObj = PageFactory.initElements(driver, MedicalInquiryPF.class);
		homeObj.menuItem("Medical Inquiries");	//Clicking the Medical Inquiries menu item
		medHomeObj.verifyMedInquiryPageTitle();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(dependsOnMethods={"MedInqHomePage"})
	public void newMedicalInq() throws Exception {
		MedicalInquiryPF medInqObj = PageFactory.initElements(driver, MedicalInquiryPF.class);
		medInqObj.ButtonClick("New");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		medInqObj.medInquiryRecordType("Medical Inquiry");
		medInqObj.ButtonClick("Continue");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("itarget");
		medInqObj.ButtonClick("Submit");
		medInqObj.validationMessage();
		medInqObj.setInfoAccount("James Scales");
		medInqObj.setInfoSource("E-MIRF-CSP");
		medInqObj.setReqDate("8/9/2016");
		medInqObj.setReqTime("7:00 AM");
		medInqObj.setLocation("Select Address");
		medInqObj.setAddress("10 Buist Rd, Bldg 2, Milford, PA 18337");
		medInqObj.setInqProduct("Granix");
		medInqObj.setInqText("Inquiry Text.");
		driver.switchTo().defaultContent();
		medInqObj.ButtonClick("Submit");
	}
	
	@Test(dependsOnMethods={"newMedicalInq"}, description = "Logging out from application")
	public void logout() {
		LogoutPF logoutObj = PageFactory.initElements(driver, LogoutPF.class);
		logoutObj.userLogout();
	}
}
