package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SignUp_Page {
    private WebDriver driver;
    private WebDriverWait wait;

    private By signupLink = By.id("signin2");
    private By usernameField = By.id("sign-username");
    private By passwordField = By.id("sign-password");
    private By signupButton = By.xpath("//button[text()='Sign up']");

    public SignUp_Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openSignupModal() {
        driver.findElement(signupLink).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
    }

    public void enterSignupDetails(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSignupButton() {
        driver.findElement(signupButton).click();
    }

    public String getSignupAlertText() {
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    }

    public void acceptSignupAlert() {
        driver.switchTo().alert().accept();
    }
}
