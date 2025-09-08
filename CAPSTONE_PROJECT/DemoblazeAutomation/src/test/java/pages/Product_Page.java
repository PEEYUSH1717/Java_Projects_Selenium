package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Product_Page {
    private WebDriver driver;
    private WebDriverWait wait;

    public Product_Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    public void selectCategory(String category) {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText(category))).click();
    }

    public void selectProduct(String product) {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText(product))).click();
    }

    public void addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add to cart"))).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public void goToHomePage() {
        driver.navigate().to("https://www.demoblaze.com");
    }
}
