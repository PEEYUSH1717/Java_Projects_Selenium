package Sel_Day3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class instagram_login {

    public static void main(String[] args) throws IOException, InterruptedException {

        // Load properties file
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        props.load(fis);

        String instaUrl = props.getProperty("instagram.url");
        String username = props.getProperty("instagram.username");
        String password = props.getProperty("instagram.password");
        String chromeDriverPath = props.getProperty("chromedriver.path");

        System.setProperty("webdriver.chrome.driver",
        		"C:\\Users\\user\\Desktop\\Selenium_Project\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {

            driver.get(instaUrl);
            Thread.sleep(3000);


            driver.findElement(By.name("username")).sendKeys(username);

     
            driver.findElement(By.name("password")).sendKeys(password);

 
            driver.findElement(By.xpath("//button[@type='submit']")).click();

            Thread.sleep(20000); 

            System.out.println("Instagram Login Successful!");

        } finally {
            driver.quit();
        }
    }
}
