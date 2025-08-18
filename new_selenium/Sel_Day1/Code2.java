package Sel_Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Code2 {
    public static void main(String[] args) {
        
        System.setProperty("webdriver.chrome.driver", 
            "C:\\Users\\user\\Desktop\\Selenium_Project\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.google.com");
            driver.manage().window().maximize();       

            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("Selenium WebDriver");

            searchBox.sendKeys(Keys.RETURN);

            System.out.println("Search Results Page Title: " + driver.getTitle());

            Thread.sleep(20000); 
            var results = driver.findElements(By.cssSelector("h3"));
            System.out.println("Top Search Results:");
            for (int i = 0; i < Math.min(5, results.size()); i++) {
                System.out.println((i + 1) + ". " + results.get(i).getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
