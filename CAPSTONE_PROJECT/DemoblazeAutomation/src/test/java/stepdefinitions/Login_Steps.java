package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;

public class Login_Steps {

    WebDriver driver = Hooks.driver;

    @Given("I login with username {string} and password {string}")
    public void i_login(String username, String password) throws InterruptedException {
        driver.get("https://www.demoblaze.com/");
        Thread.sleep(2000);
        
        driver.findElement(By.id("login2")).click();
        Thread.sleep(2000);
        
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
        Thread.sleep(2000);   
        
        driver.findElement(By.id("loginusername")).sendKeys(username);
        driver.findElement(By.id("loginpassword")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        Thread.sleep(1000);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
    }
}
