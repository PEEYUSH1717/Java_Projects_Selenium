package Sel_Day2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;

public class microsoft_edge_version {
    @SuppressWarnings("deprecation")
	public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver",
                "C:\\Users\\user\\Desktop\\Selenium_Project\\geckodriver-v0.36.0-win32\\geckodriver.exe");

        FirefoxBinary binary = new FirefoxBinary(
                new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe")
        );
        
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(binary);
        options.addArguments("--start-maximized");

        WebDriver driver = new FirefoxDriver(options);

        Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
        System.out.println("Browser Name: " + caps.getBrowserName());
        System.out.println("Browser Version: " + caps.getBrowserVersion());

        driver.get("https://www.google.com");
        System.out.println("Page Title: " + driver.getTitle());

        driver.quit();
    }
}
