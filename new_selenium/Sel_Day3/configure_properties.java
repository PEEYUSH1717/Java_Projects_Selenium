package Sel_Day3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class configure_properties {


	public static void main(String[] args) throws IOException, InterruptedException {
		
		Properties props = new Properties();
		
        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        props.load(fis);
 
        String email = props.getProperty("naukri.email");
        String password = props.getProperty("naukri.password");
        String resumePath = props.getProperty("resume.path");
        String chromeDriverPath = props.getProperty("chromedriver.path");
 
        System.setProperty("webdriver.chrome.driver",
            "C:\\Users\\user\\Desktop\\Selenium_Project\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            driver.get("https://www.naukri.com/nlogin/login");

            driver.findElement(By.id("usernameField")).sendKeys("peeyushsingh0707@gmail.com");
            driver.findElement(By.id("passwordField")).sendKeys("GZhjs4F$Yw7Nqf.");
            driver.findElement(By.xpath("//button[text()='Login']")).click();

            Thread.sleep(4000);
            driver.get("https://www.naukri.com/mnjuser/profile");

            Thread.sleep(4000);

            driver.findElement(By.cssSelector("input[type='file']"))
                  .sendKeys("C:/Users/user/Downloads/CV/Resume_PeeyushPalSingh.pdf");
            Thread.sleep(4000);

            System.out.println("Resume Uploaded Successfully!");

        } finally {
            driver.quit();
        }
    }
}