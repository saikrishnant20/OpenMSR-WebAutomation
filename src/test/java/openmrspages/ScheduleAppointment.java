package openmrspages;

import static org.testng.Assert.fail;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ScheduleAppointment extends baseDriver {

	public ScheduleAppointment(WebDriver driver) {
		super(driver);
	}

	public ScheduleAppointment scheduleNewAppointment() {
		try {
			WebDriverWait waitscheappop = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitscheappop.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"appointmentscheduling-scheduleAppointment\"]/div[1]/h2")));
			String schApp=driver.findElement(By.xpath("//*[@id=\"appointmentscheduling-scheduleAppointment\"]/div[1]/h2")).getText();
			Assert.assertEquals(schApp, "Schedule a New Appointment");
		}
		catch(Exception e){
			fail("Unable to see New Schedule Appointment Link in the Appointment request page");
		}
		return new ScheduleAppointment(driver);
		
	}

	public ScheduleAppointment selectServiceType(String serviceType) {
		try {
			WebDriverWait waitservicetype = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitservicetype.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@ng-model='appointmentType']")));
			driver.findElement(By.xpath("//input[@ng-model='appointmentType']")).sendKeys(serviceType);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@ng-model='appointmentType']")).sendKeys(Keys.ENTER,Keys.ARROW_UP,Keys.ENTER);
			
		}
		catch(Exception e){
			fail("Unable to type the service type in the Appointment page");
		}
		return new ScheduleAppointment(driver);
		
	}

	public ScheduleAppointment clickSearchbuuton() {
		try {
			WebDriverWait waitsearchbt = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitsearchbt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".confirm[ng-click='findAvailableTimeSlots()']")));
			driver.findElement(By.cssSelector(".confirm[ng-click='findAvailableTimeSlots()']")).click();
		}
		catch(Exception e){
			fail("Unable to click search buuton in the Appointment page");
		}
		return new ScheduleAppointment(driver);
		
	}

	public ScheduleAppointment selectSlot() {
		try {
			WebDriverWait waitbookslot = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitbookslot.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body div[id='body-wrapper'] div[id='content'] div div[id='appointmentscheduling-manageAppointments'] div[id='appointmentscheduling-scheduleAppointment'] div[ng-show='showScheduleAppointment'] table[id='appointmentTable'] div[class='ngViewport ng-scope'] div[class='ngCanvas'] div[class='ng-scope ngRow even'] div[class='ng-scope'] div:nth-child(1) div:nth-child(2) div:nth-child(1)")));
			driver.findElement(By.cssSelector("body div[id='body-wrapper'] div[id='content'] div div[id='appointmentscheduling-manageAppointments'] div[id='appointmentscheduling-scheduleAppointment'] div[ng-show='showScheduleAppointment'] table[id='appointmentTable'] div[class='ngViewport ng-scope'] div[class='ngCanvas'] div[class='ng-scope ngRow even'] div[class='ng-scope'] div:nth-child(1) div:nth-child(2) div:nth-child(1)")).click();
		}
		catch(Exception e){
			fail("Unable to book slot in the Appointment page");
		}
		return new ScheduleAppointment(driver);
		
	}

	public ScheduleAppointment clickNextButton() {
		try {
			WebDriverWait waitnextbt = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitnextbt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Next']")));
			driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		}
		catch(Exception e){
			fail("Unable to click next buuton in the Appointment page");
		}
		return new ScheduleAppointment(driver);
		
	}

	public ScheduleAppointment appointmentRequestFinalPage() {
		try {
			WebDriverWait waitfinalappo = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitfinalappo.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='confirmAppointment'] h2")));
			String confirmAppointment=driver.findElement(By.cssSelector("div[id='confirmAppointment'] h2")).getText();
			Assert.assertEquals(confirmAppointment, "Confirm Appointment?");
		}
		catch(Exception e){
			fail("Unable to view 'Confirm Appointment?' in the Appointment page");
		}
		return new ScheduleAppointment(driver);
		
	}

	public ScheduleAppointment saveAppointmentRequest() {
		try {
			WebDriverWait waitsave = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitsave.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Save']")));
			driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
		}
		catch(Exception e){
			fail("Unable to save the Appointment in the Appointment page");
		}
		return new ScheduleAppointment(driver);
		
	}

	public ScheduleAppointment getAppointmentDetails() {
		try {
			WebDriverWait waitgetapp = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitgetapp.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul[id='miniPatientAppointments'] li")));
			String getAppointmentDetails=driver.findElement(By.cssSelector("ul[id='miniPatientAppointments'] li")).getText();
			System.out.println("getAppointmentDetails"+getAppointmentDetails);
		}
		catch(Exception e){
			fail("Unable to get the Appointmnet details in the Appointment page");
		}
		return new ScheduleAppointment(driver);
		
	}

}
