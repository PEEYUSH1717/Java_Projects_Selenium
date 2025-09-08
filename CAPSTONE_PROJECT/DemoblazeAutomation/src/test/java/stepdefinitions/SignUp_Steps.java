package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;

public class SignUp_Steps {

    WebDriver driver = Hooks.driver;

    @Given("I signup with username {string} and password {string}")
    public void i_signup(String username, String password) throws InterruptedException {
        
        driver.findElement(By.id("signin2")).click();
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sign-username")));

        
        driver.findElement(By.id("sign-username")).sendKeys(username);
        driver.findElement(By.id("sign-password")).sendKeys(password);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[text()='Sign up']")).click();
        Thread.sleep(2000);
       
        wait.until(ExpectedConditions.alertIsPresent());
        String alertText = driver.switchTo().alert().getText();
        System.out.println("Signup alert: " + alertText);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
    }
}
