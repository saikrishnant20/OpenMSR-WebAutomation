package openmrspages;

import static org.testng.Assert.fail;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FindPatientRecord extends baseDriver {

	public FindPatientRecord(WebDriver driver) {
		super(driver);
	}

	public FindPatientRecord findPatientRecordPage() {
		try {
			WebDriverWait waitredirect = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitredirect.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='content'] h2")));
			String findPatientPageHeader=driver.findElement(By.cssSelector("div[id='content'] h2")).getText();
			Assert.assertEquals(findPatientPageHeader, "Find Patient Record");
		}
		catch(Exception e){
			fail("Unable to view 'Find Patient Record' text on Find Patient page");
		}
		return new FindPatientRecord(driver);
		
	}

	public FindPatientRecord searchPatientID(String patientId) {
		try {
			WebDriverWait waitsearchpatientid = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitsearchpatientid.until(ExpectedConditions.visibilityOfElementLocated(By.id("patient-search")));
			driver.findElement(By.id("patient-search")).sendKeys(patientId);
		}
		catch(Exception e){
			fail("Unable to search the Patient Id on the Find Patient page");
		}
		return new FindPatientRecord(driver);
		
	}

	public FindPatientRecord patientRecordResult(String expectedPatientId, String expectedName, String expectedGender, String expectedAge, String expectedBirthDate) {
		try {
			WebDriverWait waitpatientrecord = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitpatientrecord.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='patient-search-results-table_wrapper']/table/tbody/tr/td[1]")));
			String actualPatientId=driver.findElement(By.xpath("//div[@id='patient-search-results-table_wrapper']/table/tbody/tr/td[1]")).getText().split("Re")[0];
			Assert.assertEquals(actualPatientId, expectedPatientId);
		}
		catch(Exception e){
			fail("Unable to view Patient id on Find Patient page");
		}
		
		try {
			WebDriverWait waitname = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitname.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='patient-search-results-table_wrapper']/table/tbody/tr/td[2]")));
			String actualName=driver.findElement(By.xpath("//div[@id='patient-search-results-table_wrapper']/table/tbody/tr/td[2]")).getText();
			Assert.assertEquals(actualName, expectedName);
		}
		catch(Exception e){
			fail("Unable to view Patient Name on Find Patient page");
		}
		
		try {
			WebDriverWait waitgender = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitgender.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='patient-search-results-table_wrapper']/table/tbody/tr/td[3]")));
			String actualGender=driver.findElement(By.xpath("//div[@id='patient-search-results-table_wrapper']/table/tbody/tr/td[3]")).getText();
			Assert.assertEquals(actualGender, expectedGender);
		}
		catch(Exception e){
			fail("Unable to view Patient Gender on Find Patient page");
		}
		
		try {
			WebDriverWait waitage = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitage.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='patient-search-results-table_wrapper']/table/tbody/tr/td[4]")));
			String actualAge=driver.findElement(By.xpath("//div[@id='patient-search-results-table_wrapper']/table/tbody/tr/td[4]")).getText();
			Assert.assertEquals(actualAge, expectedAge);
		}
		catch(Exception e){
			fail("Unable to view Patient Age on Find Patient page");
		}
		
		try {
			WebDriverWait waitbirthdate = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitbirthdate.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='patient-search-results-table_wrapper']/table/tbody/tr/td[5]")));
			String actualBirthDate=driver.findElement(By.xpath("//div[@id='patient-search-results-table_wrapper']/table/tbody/tr/td[5]")).getText().trim();
			Assert.assertEquals(actualBirthDate, expectedBirthDate);
		}
		catch(Exception e){
			fail("Unable to view Patient Birth Date on Find Patient page");
		}
		return new FindPatientRecord(driver);
		
	}

	public FindPatientRecord openpatientRecord() {
		try {
			WebDriverWait waitopenpatientrecord = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitopenpatientrecord.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='patient-search-results-table_wrapper']/table/tbody/tr/td[1]")));
			driver.findElement(By.xpath("//div[@id='patient-search-results-table_wrapper']/table/tbody/tr/td[1]")).click();
		}
		catch(Exception e){
			fail("Unable to open Patient id on Find Patient page");
		}
		return new FindPatientRecord(driver);
		
	}

}
