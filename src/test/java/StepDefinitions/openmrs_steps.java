package StepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import openmrspages.HomePage;
import openmrspages.LoginPage;
import openmrspages.PatientDetailPage;
import openmrspages.RegisterPage;
import openmrspages.baseDriver;
import testdatafilereader.RegisterNewPatientDetails;
import testdatafilereader.URLProperties;
import testdatafilereader.UserLoginDetails;

public class openmrs_steps {
	
	public static WebDriver driver;
	LoginPage login;
	HomePage homepage;
	RegisterPage registerpage;
	PatientDetailPage patientdetailpage;
	@Before public static void browser()
	{
//		ChromeOptions options=new ChromeOptions();
//		options.addArguments("--headless");
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
//		driver=new ChromeDriver(options);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
	}

	@Given("User enters OpenMRS url in the browser")
	public void user_enters_open_mrs_url_in_the_browser() throws IOException {
	    String URL=URLProperties.getValue("URL");
	    login = new LoginPage(driver);
	    login.navigateTo(URL);
	}

	@When("Enter the valid Username and Password in the OpenMRS login page")
	public void enter_the_valid_username_and_password_in_the_open_mrs_login_page() throws IOException {
	   String UserName=UserLoginDetails.getValue("Username");
	   String Password=UserLoginDetails.getValue("Password");
	   login.userLogin(UserName,Password);
	}

	@When("Choose the Inpatient Ward from the Loaction for this session")
	public void choose_the_inpatient_ward_from_the_loaction_for_this_session() {
		login.chooseLocSession();
	}

	@Then("User click on Log in button")
	public void user_click_on_log_in_button() {
		login.loginButtonClick();
	}

	@Then("OpenMRS home page should be opened successfully")
	public void open_mrs_home_page_should_be_opened_successfully() {
		homepage = new HomePage(driver);
		homepage.openMRSLandingPage();
	}
	
	@Then("User click on Logout button from the OpenMRS Application")
	public void user_click_on_logout_button_from_the_open_mrs_application() throws InterruptedException {
		homepage.clickOnLogout();
//		Thread.sleep(5000);
	}

	@Then("User able to see the Login page successfully")
	public void user_able_to_see_the_login_page_successfully() {
		login.loginMainPage();
	}
	
	@Then("User able to click the Register a patient icon from home page")
	public void user_able_to_click_the_register_a_patient_icon_from_home_page() {
		homepage.clickOnRegisterAPatientIcon();
	}

	@Then("User should redirect to Register a patient page to fill the required fields")
	public void user_should_redirect_to_register_a_patient_page_to_fill_the_required_fields() {
		registerpage=new RegisterPage(driver);
		registerpage.redirectRegisterAPatientPage();
	}

	@Then("Enter the patient given and family Name detail")
	public void enter_the_patient_given_and_family_name_detail() throws IOException {
		String givenName=RegisterNewPatientDetails.getValue("Given");
		String familName=RegisterNewPatientDetails.getValue("FamilyName");
		registerpage.enterNameDetails(givenName,familName);
	}

	@Then("Click the next button")
	public void click_the_next_button() {
		registerpage.clickNextIconButton();
	}

	@Then("Select the patient gender detail")
	public void select_the_patient_gender_detail() throws IOException {
		String gender=RegisterNewPatientDetails.getValue("Gender");
		registerpage.selectPatientGender(gender);
	}

	@Then("Enter the patient birth date detail")
	public void enter_the_patient_birth_date_detail() throws IOException {
		String day=RegisterNewPatientDetails.getValue("Day");
		String month=RegisterNewPatientDetails.getValue("Month");
		String year=RegisterNewPatientDetails.getValue("Year");
		registerpage.enterPatientBirthDate(day,month,year);
	}

	@Then("Enter the patient address detail")
	public void enter_the_patient_address_detail() throws IOException {
		String address1=RegisterNewPatientDetails.getValue("Address");
		String address2=RegisterNewPatientDetails.getValue("Address2");
		String cityvillage=RegisterNewPatientDetails.getValue("City-Village");
		String state=RegisterNewPatientDetails.getValue("State-Province");
		String country=RegisterNewPatientDetails.getValue("Country");
		String postalcode=RegisterNewPatientDetails.getValue("Postal-Code");
		registerpage.enterPatientAddress(address1,address2,cityvillage,state,country,postalcode);
		
	}

	@Then("Enter the patient phone number detail")
	public void enter_the_patient_phone_number_detail() throws IOException {
		String phoneNumber=RegisterNewPatientDetails.getValue("Phone-Number");
		registerpage.enterPatientPhoneNumber(phoneNumber);
	}

	@Then("Enter the patient Relatives detail")
	public void enter_the_patient_relatives_detail() throws IOException {
		String RelationshipType=RegisterNewPatientDetails.getValue("Relationship-type");
		String personName=RegisterNewPatientDetails.getValue("Person-name");
		registerpage.enterPatientRelative(RelationshipType,personName);
	}

	@Then("Click the Confirm button")
	public void click_the_confirm_button() {
		registerpage.confirmPatientDetails();
	}

	@Then("User should see the registered patient details along with patient id")
	public void user_should_see_the_registered_patient_details_along_with_patient_id() throws IOException {
		patientdetailpage = new PatientDetailPage(driver);
		String givenName=RegisterNewPatientDetails.getValue("Given");
		String familName=RegisterNewPatientDetails.getValue("FamilyName");
		String phoneNumber=RegisterNewPatientDetails.getValue("Phone-Number");
		patientdetailpage.ViewPatientDetails(givenName,familName,phoneNumber);
	}
	
	@Then("User able to click the Find Patient Record icon from home page")
	public void user_able_to_click_the_find_patient_record_icon_from_home_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User should redirect to Find Patient Record page")
	public void user_should_redirect_to_find_patient_record_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User able to see the Search text box in the Find Patient Record page")
	public void user_able_to_see_the_search_text_box_in_the_find_patient_record_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User is enter the Patient ID in the Search text box")
	public void user_is_enter_the_patient_id_in_the_search_text_box() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User is able to see the Patient record result for the Patient ID")
	public void user_is_able_to_see_the_patient_record_result_for_the_patient_id() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@After public static void TearDown()
	{
		driver.quit();
	}
}
