package Sel_Day3;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class yahoo_login {

    public static void main(String[] args) throws IOException {

        Properties props = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        props.load(fis);

        String yahooUrl = props.getProperty("yahoo.url");
        String email = props.getProperty("yahoo.email");
        String password = props.getProperty("yahoo.password");

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\user\\Desktop\\Selenium_Project\\chromedriver-win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            driver.get(yahooUrl);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            WebElement emailField = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("login-username")));
            emailField.sendKeys(email);

            driver.findElement(By.id("login-signin")).click();
            
            WebElement passwordField = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("login-passwd")));
            passwordField.sendKeys(password);

            driver.findElement(By.id("login-signin")).click();

            System.out.println("Yahoo Login Successful!");
            Thread.sleep(5000);

        } catch (Exception e) {
            System.out.println("Login failed: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
