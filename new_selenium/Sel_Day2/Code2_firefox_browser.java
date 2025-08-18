package Sel_Day2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxBinary;

public class Code2_firefox_browser {
    @SuppressWarnings("deprecation")
	public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver",
                "C:\\Users\\user\\Desktop\\Selenium_Project\\geckodriver-v0.36.0-win32\\geckodriver.exe");

        FirefoxBinary binary = new FirefoxBinary(
                new java.io.File("C:\\Program Files\\Mozilla Firefox\\firefox.exe")
        );

        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(binary);

        WebDriver driver = new FirefoxDriver(options);

        driver.get("https://www.google.com");

        System.out.println("Page title: " + driver.getTitle());

        driver.quit();
    }
}
