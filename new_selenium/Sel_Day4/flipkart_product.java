package Sel_Day4;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class flipkart_product {
    public static void main(String[] args) throws IOException {

        Properties props = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        props.load(fis);
        String mobile = props.getProperty("flipkart.mobile");

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\user\\Desktop\\Selenium_Project\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        driver.get("https://www.flipkart.com/");

        // ✅ Updated locators for login page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input._2IX_2-")));
        driver.findElement(By.cssSelector("input._2IX_2-")).sendKeys(mobile);

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button._2KpZ6l._2HKlqd._3AWRsL"))).click();

        // ✅ Wait for search box to appear after OTP login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));

        List<String> products = new ArrayList<>();
        products.add("laptop");
        products.add("headphones");
        products.add("wireless mouse");
        products.add("keyboard");
        products.add("smartwatch");

        for (String product : products) {
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.clear();
            searchBox.sendKeys(product);
            driver.findElement(By.cssSelector("button[type='submit']")).click();

            // ✅ Wait for product list to load
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a._1fQZEK, a._2UzuFa")));

            List<WebElement> items = driver.findElements(By.cssSelector("a._1fQZEK, a._2UzuFa"));
            if (!items.isEmpty()) {
                items.get(0).click();
                ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
                driver.switchTo().window(tabs.get(1));
                try {
                    WebElement addToCartBtn = wait.until(
                            ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'Add to cart')]")));
                    addToCartBtn.click();
                } catch (Exception e) {
                    System.out.println("Add to cart not available for " + product);
                }
                driver.close();
                driver.switchTo().window(tabs.get(0));
            }
        }
        driver.quit();
    }
}
