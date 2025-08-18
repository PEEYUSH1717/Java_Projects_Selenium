package Sel_Day2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class firefox_version {
    public static void main(String[] args) {
    	
        System.setProperty("webdriver.gecko.driver", 
            "C:\\Users\\user\\Desktop\\Selenium_Project\\geckodriver-v0.36.0-win32\\geckodriver.exe");

        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--start-maximized");

        WebDriver driver = new FirefoxDriver(options);

        Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = caps.getBrowserName();
        String browserVersion = caps.getBrowserVersion();

        System.out.println("Browser Name: " + browserName);
        System.out.println("Browser Version: " + browserVersion);

        driver.get("https://www.google.com");

        driver.quit();
    }
}
