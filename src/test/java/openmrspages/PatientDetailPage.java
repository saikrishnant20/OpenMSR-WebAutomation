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

	public PatientDetailPage viewPatientIDDetails(String expectedGivenName, String expectedFamilyName, String expectedPhoneNumber, String expectedPatientId) {
		try {
			WebDriverWait waitgivenname = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitgivenname.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".PersonName-givenName")));
			String actualGivenName=driver.findElement(By.cssSelector(".PersonName-givenName")).getText();
			Assert.assertEquals(actualGivenName, expectedGivenName);
		}
		catch(Exception e){
			fail("Unable to view Given Name in the Patient detail");
		}
		
		try {
			WebDriverWait waitfamilyname = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitfamilyname.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".PersonName-familyName")));
			String actualFamilyName=driver.findElement(By.cssSelector(".PersonName-familyName")).getText();
			Assert.assertEquals(actualFamilyName, expectedFamilyName);
		}
		catch(Exception e){
			fail("Unable to view Family Name in the Patient detail");
		}
		
		try {
			WebDriverWait waitshowcontact = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitshowcontact.until(ExpectedConditions.visibilityOfElementLocated(By.id("coreapps-showContactInfo")));
			driver.findElement(By.id("coreapps-showContactInfo")).click();
		}
		catch(Exception e){
			fail("Unable to click Show Contact in the Patient detail");
		}
		
		try {
			WebDriverWait waitphonenumber = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitphonenumber.until(ExpectedConditions.visibilityOfElementLocated(By.id("coreapps-telephoneNumber")));
			String actualPhoneNumber=driver.findElement(By.id("coreapps-telephoneNumber")).getText();
			Assert.assertEquals(actualPhoneNumber, expectedPhoneNumber);
		}
		catch(Exception e){
			fail("Unable to view Phone Number in the Patient detail");
		}
		
		try {
			WebDriverWait waitgetpatientid = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitgetpatientid.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='float-sm-right'] span")));
			String ActualpatientID=driver.findElement(By.cssSelector("div[class='float-sm-right'] span")).getText();
			Assert.assertEquals(ActualpatientID, expectedPatientId);
		}
		catch(Exception e){
			fail("Unable to view Patient ID in the Patient detail");
		}
		return new PatientDetailPage(driver);
		
	}

	public PatientDetailPage clickScheduleAppointmentLink() {
		try {
			WebDriverWait waitscheapp = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitscheapp.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"appointmentschedulingui.schedulingAppointmentDashboardLink\"]/div/div[2]")));
			driver.findElement(By.xpath("//*[@id=\"appointmentschedulingui.schedulingAppointmentDashboardLink\"]/div/div[2]")).click();
		}
		catch(Exception e){
			fail("Unable to click Schedule Appointment Link in the Patient detail page");
		}
		return new PatientDetailPage(driver);
		
	}

	public PatientDetailPage clickStartVisit() {
		try {
			WebDriverWait waitsvisit = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitsvisit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Start Visit')]")));
			driver.findElement(By.xpath("//div[contains(text(),'Start Visit')]")).click();
		}
		catch(Exception e){
			fail("Unable to click start visit in the Patient detail page");
		}
		return new PatientDetailPage(driver);
		
	}

	public PatientDetailPage clickConfirm() {
		try {
			WebDriverWait waitsconfirm = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitsconfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='start-visit-with-visittype-confirm']")));
			driver.findElement(By.xpath("//button[@id='start-visit-with-visittype-confirm']")).click();
		}
		catch(Exception e){
			fail("Unable to click confirm in the Patient detail page");
		}
		return new PatientDetailPage(driver);
		
	}

	public PatientDetailPage clickAttachement() {
		try {
			WebDriverWait waitsattach = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitsattach.until(ExpectedConditions.visibilityOfElementLocated(By.id("attachments.attachments.visitActions.default")));
			driver.findElement(By.id("attachments.attachments.visitActions.default")).click();
		}
		catch(Exception e){
			fail("Unable to click Attachement button");
		}
		return new PatientDetailPage(driver);
		
	}

	public PatientDetailPage uploadFile() {
		try {
			WebDriverWait waitsupload = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitsupload.until(ExpectedConditions.visibilityOfElementLocated(By.id("visit-documents-dropzone")));
			driver.findElement(By.id("visit-documents-dropzone")).sendKeys("H:\\Undostres\\Openmrs-WebAutomation\\TestAttachmentFile\\dummy.pdf");
		}
		catch(Exception e){
			fail("Unable to click file upload button");
		}
		return new PatientDetailPage(driver);
		
	}

	public PatientDetailPage enterCaption() {
		try {
			WebDriverWait waitsCap = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitsCap.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@placeholder='Enter a caption']")));
			driver.findElement(By.xpath("//textarea[@placeholder='Enter a caption']")).sendKeys("Enter Caption");
		}
		catch(Exception e){
			fail("Unable to enter caption");
		}
		return new PatientDetailPage(driver);
		
	}

	public PatientDetailPage clickUploadFileButton() {
		try {
			WebDriverWait waitsupl = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitsupl.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Upload file']")));
			driver.findElement(By.xpath("//button[normalize-space()='Upload file']")).sendKeys("Enter Caption");
		}
		catch(Exception e){
			fail("Unable to click upload button");
		}
		return new PatientDetailPage(driver);
		
	}

	public PatientDetailPage clickDeletePatient() {
		try {
			WebDriverWait waitdelete = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitdelete.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Delete Patient')]")));
			driver.findElement(By.xpath("//div[contains(text(),'Delete Patient')]")).click();
		}
		catch(Exception e){
			fail("Unable to click delete patient button");
		}
		return new PatientDetailPage(driver);
		
	}

	public PatientDetailPage getPopupConfDelete() {
		try {
			WebDriverWait waitdeleteconf = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitdeleteconf.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[normalize-space()='Reason:']")));
			String reasonText=driver.findElement(By.xpath("//label[normalize-space()='Reason:']")).getText();
			Assert.assertEquals(reasonText, "Reason:");
		}
		catch(Exception e){
			fail("Unable to see the 'Reason:' text in the delete popup");
		}
		return new PatientDetailPage(driver);
		
	}

	public PatientDetailPage enterReasonDelete() {
		try {
			WebDriverWait waitResdelete = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitResdelete.until(ExpectedConditions.visibilityOfElementLocated(By.id("delete-reason")));
			driver.findElement(By.id("delete-reason")).sendKeys("Testing");
		}
		catch(Exception e){
			fail("Unable to enter reason for delete patient");
		}
		return new PatientDetailPage(driver);
		
	}

	public PatientDetailPage confirmDeletePatient() {
		try {
			WebDriverWait waitcondelete = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitcondelete.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='delete-patient-creation-dialog']//button[@class='confirm right'][normalize-space()='Confirm']")));
			driver.findElement(By.xpath("//div[@id='delete-patient-creation-dialog']//button[@class='confirm right'][normalize-space()='Confirm']")).click();
		}
		catch(Exception e){
			fail("Unable to click confirm delete patient");
		}
		return new PatientDetailPage(driver);
		
	}

}
