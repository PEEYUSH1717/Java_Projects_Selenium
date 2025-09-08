package stepdefinitions;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class Order_Steps {

    WebDriver driver;
    WebDriverWait wait;

    public Order_Steps() {
        this.driver = Hooks.driver; 
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @And("I place the order with details Name {string}, Country {string}, City {string}, CreditCard {string}, Month {string}, Year {string}")
    public void i_place_order(String name, String country, String city, String creditCard, String month, String year) {
        try {
           
            WebElement cartLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("cartur")));
            cartLink.click();
            Thread.sleep(2000);
         
            WebElement placeOrderBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Place Order']")));
            placeOrderBtn.click();
            Thread.sleep(2000);
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).sendKeys(name);
            driver.findElement(By.id("country")).sendKeys(country);
            driver.findElement(By.id("city")).sendKeys(city);
            driver.findElement(By.id("card")).sendKeys(creditCard);
            driver.findElement(By.id("month")).sendKeys(month);
            driver.findElement(By.id("year")).sendKeys(year);
            Thread.sleep(1000);
            
            driver.findElement(By.xpath("//button[text()='Purchase']")).click();
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Error placing order: " + e.getMessage());
        }
    }

    @Then("the order should be placed successfully")
    public void order_successfully() {
        try {
            
            WebElement confirmationModal = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sweet-alert.showSweetAlert.visible"))
            );

            String confirmationText = confirmationModal.getText();
            System.out.println("Order Confirmation: " + confirmationText);

            
            if (confirmationText.contains("Thank you for your purchase!")) {
                System.out.println("Order placed successfully!");
            }
            Thread.sleep(2000);
            
            WebElement okBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='OK']")));
            okBtn.click();
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Error confirming order: " + e.getMessage());
        }
    }

    @Then("I log out from the application")
    public void i_log_out_from_the_application() {
        try {
            WebElement logoutBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("logout2")));
            logoutBtn.click();
            Thread.sleep(2000);
            System.out.println("User logged out successfully!");
        } catch (Exception e) {
            System.out.println("Error during logout: " + e.getMessage());
        }
    }
}

