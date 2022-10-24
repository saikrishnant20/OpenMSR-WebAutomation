package openmrspages;

import static org.testng.Assert.fail;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RegisterPage extends baseDriver {

	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	public RegisterPage redirectRegisterAPatientPage() {
		try {
			WebDriverWait waitredirect = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitredirect.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='content']/h2")));
			String registerPageHeader=driver.findElement(By.xpath("//*[@id='content']/h2")).getText();
			Assert.assertEquals(registerPageHeader, "Register a patient");
		}
		catch(Exception e){
			fail("Unable to view 'Register a patient' text on Register page");
		}
		return new RegisterPage(driver);
		
	}
	
	public RegisterPage enterNameDetails(String givenName, String familyName) {
		try {
			WebDriverWait waitnameheader = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitnameheader.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("fieldset[id='demographics-name'] h3:nth-child(1)")));
			String nameHeaderText=driver.findElement(By.cssSelector("fieldset[id='demographics-name'] h3:nth-child(1)")).getText();
			Assert.assertEquals(nameHeaderText, "What's the patient's name?");
		}
		catch(Exception e){
			fail("Unable to view the 'What's the patient's name?' header");
		}
		
		try {
			WebDriverWait waitentergivenname = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitentergivenname.until(ExpectedConditions.visibilityOfElementLocated(By.name("givenName")));
			driver.findElement(By.name("givenName")).sendKeys(givenName);
		}
		catch(Exception e){
			fail("Unable to enter the Given name in the textbox");
		}
		
		try {
			WebDriverWait waitenterfamilyname = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitenterfamilyname.until(ExpectedConditions.visibilityOfElementLocated(By.name("familyName")));
			driver.findElement(By.name("familyName")).sendKeys(familyName);
		}
		catch(Exception e){
			fail("Unable to enter the Family name in the textbox");
		}
		return new RegisterPage(driver);
		
		
	}

	public RegisterPage clickNextIconButton() {
		try {
			WebDriverWait waitnextIconbutton = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitnextIconbutton.until(ExpectedConditions.visibilityOfElementLocated(By.id("next-button")));
			driver.findElement(By.id("next-button")).click();
		}
		catch(Exception e){
			fail("Unable to click Next Icon button in the regsiter a patient page");
		}
		return new RegisterPage(driver);
		
	}

	public RegisterPage selectPatientGender(String gender) {
		try {
			WebDriverWait waitgenderheader = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitgenderheader.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("label[for='gender-field']")));
			String genderHeaderText=driver.findElement(By.cssSelector("label[for='gender-field']")).getText();
			Assert.assertEquals(genderHeaderText, "What's the patient's gender? (required)");
		}
		catch(Exception e){
			fail("Unable to view 'What's the patient's gender? (required)' header");
		}
		
		try {
			Select selectgenderdropdown=new Select(driver.findElement(By.id("gender-field")));
			selectgenderdropdown.selectByVisibleText(gender);
		}
		catch(Exception e){
			fail("Unable to select the Gender");
		}
		return new RegisterPage(driver);
		
	}

	public RegisterPage enterPatientBirthDate(String day, String month, String year) {
		
		try {
			WebDriverWait waitbirthday = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitbirthday.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='birthdateDay-field']")));
			driver.findElement(By.xpath("//input[@id='birthdateDay-field']")).sendKeys(day);
		}
		catch(Exception e){
			fail("Unable to enter the 'Day' in the Patient birth date details");
		}
		
		try {
			Select selectmonthdropdown=new Select(driver.findElement(By.id("birthdateMonth-field")));
			selectmonthdropdown.selectByVisibleText(month);
		}
		catch(Exception e){
			fail("Unable to select the 'Month' in the Patient birth date details");
		}
		
		try {
			WebDriverWait waitbirthyear = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitbirthyear.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='birthdateYear-field']")));
			driver.findElement(By.xpath("//input[@id='birthdateYear-field']")).sendKeys(year);
		}
		catch(Exception e){
			fail("Unable to select the 'Year' in the Patient birth date details");
		}
		return new RegisterPage(driver);
	}

	public RegisterPage enterPatientAddress(String address1, String address2, String cityvillage, String state, String country,
			String postalcode) {
		try {
			WebDriverWait waitaddressheader = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitaddressheader.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//label[normalize-space()=\"What is the patient's address?\"])[1]")));
			String addressHeaderText=driver.findElement(By.xpath("(//label[normalize-space()=\"What is the patient's address?\"])[1]")).getText();
			Assert.assertEquals(addressHeaderText, "What is the patient's address?");
		}
		catch(Exception e){
			fail("Unable to view 'What is the patient's address?' header");
		}
		
		try {
			WebDriverWait waitaddress1 = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitaddress1.until(ExpectedConditions.visibilityOfElementLocated(By.id("address1")));
			driver.findElement(By.id("address1")).sendKeys(address1);
		}
		catch(Exception e){
			fail("Unable to enter the 'Address1' in the Patient address details");
		}
		
		try {
			WebDriverWait waitaddress2 = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitaddress2.until(ExpectedConditions.visibilityOfElementLocated(By.id("address2")));
			driver.findElement(By.id("address2")).sendKeys(address2);
		}
		catch(Exception e){
			fail("Unable to enter the 'Address2' in the Patient address details");
		}
		
		try {
			WebDriverWait waitcity = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitcity.until(ExpectedConditions.visibilityOfElementLocated(By.id("cityVillage")));
			driver.findElement(By.id("cityVillage")).sendKeys(cityvillage);
		}
		catch(Exception e){
			fail("Unable to enter the 'City/Village' in the Patient address details");
		}
		
		try {
			WebDriverWait waitstate = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitstate.until(ExpectedConditions.visibilityOfElementLocated(By.id("stateProvince")));
			driver.findElement(By.id("stateProvince")).sendKeys(state);
		}
		catch(Exception e){
			fail("Unable to enter the 'State/Province' in the Patient address details");
		}
		
		try {
			WebDriverWait waitcountry = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitcountry.until(ExpectedConditions.visibilityOfElementLocated(By.id("country")));
			driver.findElement(By.id("country")).sendKeys(country);
		}
		catch(Exception e){
			fail("Unable to enter the 'Country' in the Patient address details");
		}
		
		try {
			WebDriverWait waitpostalcode = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitpostalcode.until(ExpectedConditions.visibilityOfElementLocated(By.id("postalCode")));
			driver.findElement(By.id("postalCode")).sendKeys(postalcode);
		}
		catch(Exception e){
			fail("Unable to enter the 'Postal Code' in the Patient address details");
		}
		return new RegisterPage(driver);
	}

	public RegisterPage enterPatientPhoneNumber(String phoneNumber) {
		try {
			WebDriverWait waitphonenumberheader = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitphonenumberheader.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//label[normalize-space()=\"What's the patient phone number?\"])[1]")));
			String phoneNumberHeaderText=driver.findElement(By.xpath("(//label[normalize-space()=\"What's the patient phone number?\"])[1]")).getText();
			Assert.assertEquals(phoneNumberHeaderText, "What's the patient phone number?");
		}
		catch(Exception e){
			fail("Unable to view 'What's the patient phone number?' header");
		}
		try {
			WebDriverWait waitphonenum = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitphonenum.until(ExpectedConditions.visibilityOfElementLocated(By.name("phoneNumber")));
			driver.findElement(By.name("phoneNumber")).sendKeys(phoneNumber);
		}
		catch(Exception e){
			fail("Unable to enter the 'Phone Number' in the Patient Phone details");
		}
		return new RegisterPage(driver);
		
	}

	public RegisterPage enterPatientRelative(String relationshipType, String personName) {
		try {
			WebDriverWait waitrelationheader = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitrelationheader.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("fieldset[id='null'] h3")));
			String relativeHeaderText=driver.findElement(By.cssSelector("fieldset[id='null'] h3")).getText();
			Assert.assertEquals(relativeHeaderText, "Who is the patient related to?");
		}
		catch(Exception e){
			fail("Unable to view 'Who is the patient related to?' header");
		}
		
		try {
			Select selectrelativetypedropdown=new Select(driver.findElement(By.id("relationship_type")));
			selectrelativetypedropdown.selectByVisibleText(relationshipType);
		}
		catch(Exception e){
			fail("Unable to select the 'Relationship Type' in the Patient Relative details");
		}
		
		try {
			WebDriverWait waitpersonname = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitpersonname.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Person Name']")));
			driver.findElement(By.cssSelector("input[placeholder='Person Name']")).sendKeys(personName);
		}
		catch(Exception e){
			fail("Unable to enter the person name");
		}
		return new RegisterPage(driver);
		
	}

	public RegisterPage confirmPatientDetails() {
		try {
			WebDriverWait waitconfirm = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitconfirm.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#submit")));
			driver.findElement(By.cssSelector("#submit")).click();
		}
		catch(Exception e){
			fail("Unable to click Confirm button");
		}
		return new RegisterPage(driver);
		
	}

	
}
