package Sel_Day3;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class gmail_login {

    public static void main(String[] args) throws IOException, InterruptedException {

        Properties props = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        props.load(fis);

        String gmailUrl = props.getProperty("gmail.url");
        String email = props.getProperty("gmail.email");
        String password = props.getProperty("gmail.password");
        String edgeDriverPath = props.getProperty("edgedriver.path");


        System.setProperty("webdriver.edge.driver", 
        		"C:\\Users\\user\\Desktop\\Selenium_Project\\edgedriver_win64\\msedgedriver.exe");

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        try {
            driver.get(gmailUrl);

            driver.findElement(By.id("identifierId")).sendKeys(email);
            driver.findElement(By.id("identifierNext")).click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));

            driver.findElement(By.name("password")).sendKeys(password);
            driver.findElement(By.id("passwordNext")).click();

            Thread.sleep(10000);

            System.out.println("Gmail Login Successful!");

        } finally {
            driver.quit();
        }
    }
}
