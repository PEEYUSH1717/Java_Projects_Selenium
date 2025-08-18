package Sel_Day2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
 
@SuppressWarnings("unused")
public class chrome_browse_version {
    public static void main(String[] args) {
    	
        System.setProperty("webdriver.chrome.driver", 
            "C:\\Users\\user\\Desktop\\Selenium_Project\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver (options);

        Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();

        String browserName = caps.getBrowserName();

        String browserVersion = caps.getBrowserVersion();

        System.out.println("Browser Name:" + browserName);

        System.out.println("Browser Version: " + browserVersion);

        driver.get("https://www.google.com");

        driver.quit();
    }}