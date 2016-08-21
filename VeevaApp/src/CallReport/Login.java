/**
 * 
 */
package CallReport;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.veeva.pages.LoginPagePF;

import utility.SetUpTearDown;

/**
 * @author Pratik
 *
 */
public class Login extends SetUpTearDown {
	@Test
	public void login() {
		LoginPagePF obj = PageFactory.initElements(driver, LoginPagePF.class);
		obj.loginToapp("****", "****");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
