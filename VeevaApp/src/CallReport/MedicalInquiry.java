/**
 * 
 */
package CallReport;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.veeva.pages.HomePagePF;
import com.veeva.pages.LogoutPF;
import com.veeva.pages.MedicalInquiryPF;

/**
 * @author Pratik
 *
 */
public class MedicalInquiry extends Login {
	@Test(dependsOnMethods = {"login"})
	public void MedInqHomePage() {
		HomePagePF homeObj = PageFactory.initElements(driver, HomePagePF.class);
		MedicalInquiryPF medHomeObj = PageFactory.initElements(driver, MedicalInquiryPF.class);
		homeObj.menuItem("Medical Inquiries");	//Clicking the Medical Inquiries menu item
		medHomeObj.verifyMedInquiryPageTitle();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(dependsOnMethods={"MedInqHomePage"})
	public void newMedicalInq() {
		MedicalInquiryPF medInqObj = PageFactory.initElements(driver, MedicalInquiryPF.class);
		medInqObj.ButtonClick("New");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		medInqObj.medInquiryRecordType("Medical Inquiry");
		medInqObj.ButtonClick("Continue");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("itarget");
		medInqObj.ButtonClick("Submit");
		medInqObj.validationChecks();
		medInqObj.setInfoSource("E-MIRF-Convention");
		medInqObj.setInfoAccountLookup("James Scales");
		driver.switchTo().frame("itarget");
		medInqObj.setReqDate("8/9/2016");
		medInqObj.setReqTime("7:00 AM");
		medInqObj.setLocation("Select Address");
		medInqObj.setAddress("10 Buist Rd, Bldg 2, Milford, PA 18337");
		medInqObj.setInqProduct("Granix");
		medInqObj.setInqText("Inquiry Text.");
		medInqObj.setInfoSource("E-MIRF-CSP");
		medInqObj.ButtonClick("Submit");
		driver.switchTo().defaultContent();
	}
	
	@Test(dependsOnMethods={"newMedicalInq"}, description = "Logging out from application")
	public void logout() {
		LogoutPF logoutObj = PageFactory.initElements(driver, LogoutPF.class);
		logoutObj.userLogout();
	}
}
