package Sel_Day2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.PageLoadStrategy;

public class Page_loader {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", 
        		"C:\\Users\\user\\Desktop\\Selenium_Project\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");

        ChromeOptions normalOptions = new ChromeOptions();
        normalOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driverNormal = new ChromeDriver(normalOptions);
        System.out.println("Opening Google with NORMAL strategy...");
        driverNormal.get("https://www.google.com");
        driverNormal.quit();

        ChromeOptions eagerOptions = new ChromeOptions();
        eagerOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        WebDriver driverEager = new ChromeDriver(eagerOptions);
        System.out.println("Opening Google with EAGER strategy...");
        driverEager.get("https://www.google.com");
        driverEager.quit();

        ChromeOptions noneOptions = new ChromeOptions();
        noneOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
        WebDriver driverNone = new ChromeDriver(noneOptions);
        System.out.println("Opening Google with NONE strategy...");
        driverNone.get("https://www.google.com");
        driverNone.quit();
    }
}