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
import openmrspages.baseDriver;
import testdatafilereader.URLProperties;
import testdatafilereader.UserLoginDetails;

public class openmrs_steps {
	
	public static WebDriver driver;
	LoginPage login;
	HomePage homepage;
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
	   login.Userlogin(UserName,Password);
	}

	@When("Choose the Inpatient Ward from the Loaction for this session")
	public void choose_the_inpatient_ward_from_the_loaction_for_this_session() {
		login.ChooseLocSession();
	}

	@Then("User click on Log in button")
	public void user_click_on_log_in_button() {
		login.LoginButtonClick();
	}

	@Then("OpenMRS home page should be opened successfully")
	public void open_mrs_home_page_should_be_opened_successfully() {
		homepage = new HomePage(driver);
		homepage.OpenMRSLandingPage();
	}
	
	@Then("User click on Logout button from the OpenMRS Application")
	public void user_click_on_logout_button_from_the_open_mrs_application() throws InterruptedException {
		homepage.ClickOnLogout();
		Thread.sleep(5000);
	}

	@Then("User able to see the Login page successfully")
	public void user_able_to_see_the_login_page_successfully() {
		login.LoginMainPage();
	}
	
	@After public static void TearDown()
	{
		driver.quit();
	}
}
