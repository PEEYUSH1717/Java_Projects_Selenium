package Sel_Day3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class facebook_login {

    public static void main(String[] args) throws IOException, InterruptedException {

        Properties props = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        props.load(fis);

        String facebookUrl = props.getProperty("facebook.url");
        String email = props.getProperty("facebook.email");
        String password = props.getProperty("facebook.password");
        String chromeDriverPath = props.getProperty("chromedriver.path");

        System.setProperty("webdriver.chrome.driver", 
        		"C:\\Users\\user\\Desktop\\Selenium_Project\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            driver.get(facebookUrl);

            driver.findElement(By.id("email")).sendKeys(email);

            driver.findElement(By.id("pass")).sendKeys(password);

            driver.findElement(By.name("login")).click();

            Thread.sleep(10000);

            System.out.println("Facebook Login Successful!");

        } finally {
            driver.quit();
        }
    }
}
