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

	public HomePage openMRSLandingPage() {
		try {
			WebDriverWait waitopenmrs = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitopenmrs.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='content']/div[2]/div/h4")));
			String actualtext=driver.findElement(By.xpath("//*[@id='content']/div[2]/div/h4")).getText();
			Assert.assertEquals(actualtext, "Logged in as Super User (admin) at Inpatient Ward.");
		}
		catch(Exception e){
			fail("Unable to find the 'Logged in as Super User (admin) at Inpatient Ward.' in the Home page");
		}
		return new HomePage(driver);
		
	}

	public HomePage clickOnLogout() {
		try {
			WebDriverWait waitlogout = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitlogout.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[3]/a")));
			driver.findElement(By.xpath("//*[@id='navbarSupportedContent']/ul/li[3]/a")).click();
		}
		catch(Exception e){
			fail("Unable to click the Logout button");
		}
		return new HomePage(driver);
		
	}

	public HomePage clickOnRegisterAPatientIcon() {
		try {
			WebDriverWait waitclickregpatient = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitclickregpatient.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension")));
			driver.findElement(By.cssSelector("#referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension")).click();
		}
		catch(Exception e){
			fail("Unable to click on Register a Patient Icon from HomePage");
		}
		return new HomePage(driver);
		
	}

}
