package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_Page {

	WebDriver driver;

	@Given("I open Amazon login page")
	public void i_open_amazon_login_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(
				"https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		driver.manage().window().maximize();
		   System.setProperty("webdriver.chrome.driver",
	                 "C:\\Users\\user\\Desktop\\Selenium_Project\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
	}

	@When("I enter valid email and password")
	public void i_enter_valid_email_and_password() {
		driver.findElement(By.id("ap_email")).sendKeys("peeyushsingh0707@gmail.com");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("thorTHUNDER$0707");
	}

	@When("I click on login button")
	public void i_click_on_login_button() {
		driver.findElement(By.id("signInSubmit")).click();
	}

	@Then("I should be redirected to my account page")
	public void i_should_be_redirected_to_my_account_page() {
		boolean result = driver.getTitle().contains("Amazon");
		if (result) {
			System.out.println("Login successful.");
		} else {
			System.out.println("Login failed.");
		}
		driver.quit();
	}
}