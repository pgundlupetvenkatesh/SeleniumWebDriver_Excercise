/**
 * 
 */
package helper;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * @author Pratik
 *
 */
public class HelperFunctions {
	
	public boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	//MouseHover function
	public void mouseHover(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}
	
	public void dragDrop(WebDriver driver, WebElement sourceElement, WebElement targetElement) {
		Actions act = new Actions(driver);
		act.dragAndDrop(sourceElement, targetElement);
	}
	
	public static void screenShot(WebDriver driver, String screenShotName) {
		try {
			TakesScreenshot screenShot = (TakesScreenshot)driver;
			File ssFile = screenShot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(ssFile, new File("./ScreenShot/"+ screenShotName +".png"));
		} catch (Exception e) {
			System.out.println("Possible defect - Error while taking screen shots: " +e.getMessage());
			e.printStackTrace();
		}
	}
}
