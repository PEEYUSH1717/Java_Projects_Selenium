package Sel_Day4;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class myntra_products {
    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String url = prop.getProperty("url");
        String mobile = prop.getProperty("mobile");
        String searchItem = prop.getProperty("searchItem");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(url);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement profileIcon = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Profile']")));
            profileIcon.click();

            WebElement loginButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='login / Signup']")));
            loginButton.click();
            WebElement mobileField = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='tel']")));
            mobileField.sendKeys(mobile);

            try {
                WebElement otpCheckbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
                if (!otpCheckbox.isSelected()) {
                    otpCheckbox.click();
                }
            } catch (Exception ignore) {
                System.out.println("OTP checkbox not found, skipping...");
            }

            WebElement continueBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='CONTINUE']")));
            continueBtn.click();

            System.out.println("Enter OTP manually on your phone now...");

            Thread.sleep(45000); 

            WebElement searchBox = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search for products, brands and more']")));
            searchBox.sendKeys(searchItem);
            searchBox.submit();

            for (int i = 1; i <= 5; i++) {
                WebElement product = wait.until(
                        ExpectedConditions.elementToBeClickable(By.xpath("(//li[@class='product-base'])[" + i + "]")));
                product.click();

                for (String handle : driver.getWindowHandles()) {
                    driver.switchTo().window(handle);
                }

                WebElement addToBag = wait.until(
                        ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='ADD TO BAG']")));
                addToBag.click();
                System.out.println("✅ Product " + i + " added to cart.");

                driver.close(); 
                for (String handle : driver.getWindowHandles()) {
                    driver.switchTo().window(handle);
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            Thread.sleep(5000);
            driver.quit();
        }
    }
}
