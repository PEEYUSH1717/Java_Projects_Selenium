package Sel_Day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Code1 {
    public static void main(String[] args) {
    	
        System.setProperty("webdriver.chrome.driver", 
            "C:\\Users\\user\\Desktop\\Selenium_Project\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        System.out.println("Page title: " + driver.getTitle());
        driver.quit();
        
        }
    }