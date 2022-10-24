package openmrspages;

import static org.testng.Assert.fail;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PatientDetailPage extends baseDriver {

	public PatientDetailPage(WebDriver driver) {
		super(driver);
	}

	public PatientDetailPage ViewPatientDetails(String expectedGivenName, String expectedFamilName, String expectedPhoneNumber) {
		try {
			WebDriverWait waitgivenname = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitgivenname.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".PersonName-givenName")));
			String actualGivenName=driver.findElement(By.cssSelector(".PersonName-givenName")).getText();
			Assert.assertEquals(actualGivenName, expectedGivenName);
		}
		catch(Exception e){
			fail("Unable to view Given Name in the Patient detail page");
		}
		
		try {
			WebDriverWait waitfamilyname = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitfamilyname.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".PersonName-familyName")));
			String actualFamilyName=driver.findElement(By.cssSelector(".PersonName-familyName")).getText();
			Assert.assertEquals(actualFamilyName, expectedFamilName);
		}
		catch(Exception e){
			fail("Unable to view Family Name in the Patient detail page");
		}
		
		try {
			WebDriverWait waitshowcontact = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitshowcontact.until(ExpectedConditions.visibilityOfElementLocated(By.id("coreapps-showContactInfo")));
			driver.findElement(By.id("coreapps-showContactInfo")).click();
		}
		catch(Exception e){
			fail("Unable to click Show Contact in the Patient detail page");
		}
		
		try {
			WebDriverWait waitphonenumber = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitphonenumber.until(ExpectedConditions.visibilityOfElementLocated(By.id("coreapps-telephoneNumber")));
			String actualPhoneNumber=driver.findElement(By.id("coreapps-telephoneNumber")).getText();
			Assert.assertEquals(actualPhoneNumber, expectedPhoneNumber);
		}
		catch(Exception e){
			fail("Unable to view Phone Number in the Patient detail page");
		}
		
		try {
			WebDriverWait waitgetpatientid = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitgetpatientid.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='float-sm-right'] span")));
			String patientID=driver.findElement(By.cssSelector("div[class='float-sm-right'] span")).getText();
			System.out.println("Patient ID" +patientID);
		}
		catch(Exception e){
			fail("Unable to view Phone Number in the Patient detail page");
		}
		return new PatientDetailPage(driver);
		
	}

}
