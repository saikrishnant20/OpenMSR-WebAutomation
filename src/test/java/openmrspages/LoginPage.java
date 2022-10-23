package openmrspages;

import static org.testng.Assert.fail;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends baseDriver {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public LoginPage navigateTo(String URL) {
		// TODO Auto-generated method stub
		driver.get(URL);
		return new LoginPage(driver);
	}

	public  LoginPage Userlogin(String userName, String password) {
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username']")));
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys(userName);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		}
		catch(Exception e){
			fail("Unable to enter username or password");
		}
		return new LoginPage(driver);
	}

	public  LoginPage ChooseLocSession() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='Inpatient Ward']")));
			driver.findElement(By.xpath("//li[@id='Inpatient Ward']")).click();
		}
		catch(Exception e){
			fail("Unable to choose the location for this session");
		}
		return new LoginPage(driver);
		
	}

	public  LoginPage LoginButtonClick() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginButton")));
			driver.findElement(By.id("loginButton")).click();
		}
		catch(Exception e){
			fail("Unable to click the Login button");
		}
		return new LoginPage(driver);
		
		
	}

	public LoginPage LoginMainPage() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//legend[@class='w-auto'])[1]")));
			String loginText=driver.findElement(By.xpath("(//legend[@class='w-auto'])[1]")).getText();
			Assert.assertEquals(loginText, "LOGIN");
		}
		catch(Exception e){
			fail("Unable to see the 'LOGIN' text in the Login page");
		}
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("label[for='username']")));
			String usernamefield=driver.findElement(By.cssSelector("label[for='username']")).getText();
			Assert.assertEquals(usernamefield, "Username:");
		}
		catch(Exception e){
			fail("Unable to see the 'Username:' text in the Login page");
		}
		
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("label[for='password']")));
			String passwordfield=driver.findElement(By.cssSelector("label[for='password']")).getText();
			Assert.assertEquals(passwordfield, "Password:");
		}
		catch(Exception e){
			fail("Unable to see the 'Password:' textin the Login page");
		} 
		return new LoginPage(driver);
		
	}

}
