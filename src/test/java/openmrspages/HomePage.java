package openmrspages;

import static org.testng.Assert.fail;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class HomePage extends baseDriver {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public HomePage OpenMRSLandingPage() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='content']/div[2]/div/h4")));
			String actualtext=driver.findElement(By.xpath("//*[@id='content']/div[2]/div/h4")).getText();
			Assert.assertEquals(actualtext, "Logged in as Super User (admin) at Inpatient Ward.");
		}
		catch(Exception e){
			fail("Unable to find the 'Logged in as Super User (admin) at Inpatient Ward.' in the Home page");
		}
		return new HomePage(driver);
		
	}

	public HomePage ClickOnLogout() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[3]/a")));
			driver.findElement(By.xpath("//*[@id='navbarSupportedContent']/ul/li[3]/a")).click();
		}
		catch(Exception e){
			fail("Unable to click the Logout button");
		}
		return new HomePage(driver);
		
	}

}
