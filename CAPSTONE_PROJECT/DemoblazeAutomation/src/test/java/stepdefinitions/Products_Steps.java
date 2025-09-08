package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.When;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class Products_Steps {

    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
    WebDriver driver = Hooks.driver;

    @When("I add the following products to the cart")
    public void i_add_multiple_products(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            String category = row.get("Category");
            String product = row.get("Product");
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText(category))).click();
            Thread.sleep(2000);
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText(product))).click();
            Thread.sleep(2000);
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add to cart"))).click();
            Thread.sleep(2000);
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
            Thread.sleep(2000);
            driver.navigate().to("https://www.demoblaze.com"); // Go back to main page for next product
        }
    }
}
