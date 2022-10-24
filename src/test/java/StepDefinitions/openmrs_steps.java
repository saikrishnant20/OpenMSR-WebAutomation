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
import openmrspages.FindPatientRecord;
import openmrspages.HomePage;
import openmrspages.LoginPage;
import openmrspages.PatientDetailPage;
import openmrspages.RegisterPage;
import openmrspages.ScheduleAppointment;
import openmrspages.baseDriver;
import testdatafilereader.ExistingPatientDetails;
import testdatafilereader.RegisterNewPatientDetails;
import testdatafilereader.URLProperties;
import testdatafilereader.UserLoginDetails;

public class openmrs_steps {
	
	public static WebDriver driver;
	LoginPage login;
	HomePage homepage;
	RegisterPage registerpage;
	PatientDetailPage patientdetailpage;
	FindPatientRecord findpatientrecord;
	ScheduleAppointment schedulesppointment;
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
		homepage.clickOnFindPatientRecordIcon();
	}

	@Then("User should redirect to Find Patient Record page")
	public void user_should_redirect_to_find_patient_record_page() {
		findpatientrecord=new FindPatientRecord(driver);
		findpatientrecord.findPatientRecordPage();
	}

	@When("User is enter the Patient ID in the Search text box")
	public void user_is_enter_the_patient_id_in_the_search_text_box() throws IOException {
		String patientId=ExistingPatientDetails.getValue("Identifier");
		findpatientrecord.searchPatientID(patientId);
	}

	@Then("User is able to see the Patient record result for the Patient ID")
	public void user_is_able_to_see_the_patient_record_result_for_the_patient_id() throws IOException, InterruptedException {
		Thread.sleep(2000);
		String patientId=ExistingPatientDetails.getValue("Identifier");
		String name=ExistingPatientDetails.getValue("Name");
		String gender=ExistingPatientDetails.getValue("Gender");
		String age=ExistingPatientDetails.getValue("Age");
		String birthDate=ExistingPatientDetails.getValue("Birthdate");
		findpatientrecord.patientRecordResult(patientId,name,gender,age,birthDate);
	}
	
	@When("Click the Patient record from the search result")
	public void click_the_patient_record_from_the_search_result() {
		findpatientrecord.openpatientRecord();
	}

	@Then("User should able to view and validate the full history of existing Patient record")
	public void user_should_able_to_view_and_validate_the_full_history_of_existing_patient_record() throws IOException {
		patientdetailpage = new PatientDetailPage(driver);
		String givenName=ExistingPatientDetails.getValue("Given");
		String familyName=ExistingPatientDetails.getValue("FamilyName");
		String phoneNumber=ExistingPatientDetails.getValue("Phone-Number");
		String patientId=ExistingPatientDetails.getValue("Identifier");
		patientdetailpage.viewPatientIDDetails(givenName,familyName,phoneNumber,patientId);
	}
	
	@When("Click the Schedule Appointment under General Actions section")
	public void click_the_schedule_appointment_under_general_actions_section() {
		patientdetailpage = new PatientDetailPage(driver);
		patientdetailpage.clickScheduleAppointmentLink();
	}

	@Then("User able to see the Schedule a New Appointment option")
	public void user_able_to_see_the_schedule_a_new_appointment_option() {
		schedulesppointment=new ScheduleAppointment(driver);
		schedulesppointment.scheduleNewAppointment();
	}

	@Then("User able to select Service Type using search box")
	public void user_able_to_select_service_type_using_search_box() throws IOException {
		String serviceType=ExistingPatientDetails.getValue("ServiceType");
		schedulesppointment.selectServiceType(serviceType);
	}

	@Then("Click the Search button")
	public void click_the_search_button() {
		schedulesppointment.clickSearchbuuton();
	}

	@Then("User able to select the available slots")
	public void user_able_to_select_the_available_slots() {
		schedulesppointment.selectSlot();
	}

	@Then("Click the Next button after select slot")
	public void click_the_next_button_after_select_slot() {
		schedulesppointment.clickNextButton();
	}

	@Then("User should redirect to Appointment Requests page")
	public void user_should_redirect_to_appointment_requests_page() {
		schedulesppointment.appointmentRequestFinalPage();
	}

	@Then("Click the Save the Appointment request")
	public void click_the_save_the_appointment_request() throws InterruptedException {
		Thread.sleep(3000);
		schedulesppointment.saveAppointmentRequest();
	}

	@Then("User able to see the booked Appointment details")
	public void user_able_to_see_the_booked_appointment_details() {
		schedulesppointment.getAppointmentDetails();
	}
	
	@Then("Click the Start Visit")
	public void click_the_start_visit() {
		patientdetailpage = new PatientDetailPage(driver);
		patientdetailpage.clickStartVisit();
	}

	@Then("Click the Confirm")
	public void click_the_confirm() {
		patientdetailpage.clickConfirm();
	}

	@Then("Click the Attachments button")
	public void click_the_attachments_button() {
		patientdetailpage.clickAttachement();
	}

	@Then("Click the area contain Click or drop a file here")
	public void click_the_area_contain_click_or_drop_a_file_here() {
		patientdetailpage.uploadFile();
	}

	@Then("Enter the Caption")
	public void enter_the_caption() {
		patientdetailpage.enterCaption();
	}

	@Then("Click the Upload file button")
	public void click_the_upload_file_button() {
		patientdetailpage.clickUploadFileButton();
	}
	
	@Then("Click the Delete Patient link under General Actions section")
	public void click_the_delete_patient_link_under_general_actions_section() {
		patientdetailpage = new PatientDetailPage(driver);
		patientdetailpage.clickDeletePatient();
	}

	@Then("User able to get popup for confirmation with Reason and Cancel and Confirm button")
	public void user_able_to_get_popup_for_confirmation_with_reason_and_cancel_and_confirm_button() {
		patientdetailpage.getPopupConfDelete();
	}

	@Then("Enter the Reason for DELETE the patient details")
	public void enter_the_reason_for_delete_the_patient_details() {
		patientdetailpage.enterReasonDelete();
	}

	@Then("Click the Confirm button for DELETE the patient details")
	public void click_the_confirm_button_for_delete_the_patient_details() {
		patientdetailpage.confirmDeletePatient();
	}
	
	@After public static void TearDown()
	{
		driver.quit();
	}
}
