package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class registration_page {

    WebDriver driver;

    @Given("I open Amazon registration page")
    public void i_open_amazon_registration_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(
				"https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		driver.manage().window().maximize();
		   System.setProperty("webdriver.chrome.driver",
	                 "C:\\Users\\user\\Desktop\\Selenium_Project\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
    }

    @When("I enter valid registration details")
    public void i_enter_valid_registration_details() {
        driver.findElement(By.id("ap_customer_name")).sendKeys("Peeyush Pal Singh");
        driver.findElement(By.id("ap_phone_number")).sendKeys("8868929664");
        driver.findElement(By.id("ap_email")).sendKeys("peeyushsingh0707@gmail.com");
        driver.findElement(By.id("ap_password")).sendKeys("thorTHUNDER$0707");
    }

    @When("I click on create account button")
    public void i_click_on_create_account_button() {
        driver.findElement(By.id("continue")).click();
    }

    @Then("I should see account creation success or OTP verification page")
    public void i_should_see_account_creation_success_or_otp_verification_page() {
        boolean result = driver.getPageSource().contains("OTP") 
                      || driver.getTitle().contains("Authentication");
        if (result) {
            System.out.println("Registration step passed. OTP verification required.");
        } else {
            System.out.println("Registration may have failed.");
        }
        driver.quit();
    }

    @When("I enter invalid email in registration form")
    public void i_enter_invalid_email_in_registration_form() {
        driver.findElement(By.id("ap_customer_name")).sendKeys("Test User");
        driver.findElement(By.id("ap_phone_number")).sendKeys("9876543210");
        driver.findElement(By.id("ap_email")).sendKeys("invalidemail"); // no @
        driver.findElement(By.id("ap_password")).sendKeys("Test@1234");
    }

    @Then("I should see error messages for required fields")
    public void i_should_see_error_messages_for_required_fields() {
        boolean result = driver.getPageSource().contains("Enter your name") 
                      || driver.getPageSource().contains("Enter your mobile number")
                      || driver.getPageSource().contains("Enter your email or mobile phone number");
        if (result) {
            System.out.println("Validation error displayed as expected.");
        } else {
            System.out.println("Validation error NOT displayed.");
        }
        driver.quit();
    }

    @Then("I should see an invalid email error message")
    public void i_should_see_an_invalid_email_error_message() {
        boolean result = driver.getPageSource().contains("Enter a valid email address");
        if (result) {
            System.out.println("Invalid email error displayed as expected.");
        } else {
            System.out.println("Invalid email validation failed.");
        }
        driver.quit();
    }
}
