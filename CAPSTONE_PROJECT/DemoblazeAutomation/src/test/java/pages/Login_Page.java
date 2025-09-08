package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Login_Page {
    private WebDriver driver;
    private WebDriverWait wait;

    private By loginLink = By.id("login2");
    private By usernameField = By.id("loginusername");
    private By passwordField = By.id("loginpassword");
    private By loginButton = By.xpath("//button[text()='Log in']");
    private By loggedInUser = By.id("nameofuser");
    private By logoutButton = By.id("logout2");

    public Login_Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openLoginModal() {
        driver.findElement(loginLink).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
    }

    public void enterLoginDetails(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(loggedInUser));
    }

    public boolean isUserLoggedIn() {
        return driver.findElement(loggedInUser).isDisplayed();
    }

    public void logout() {
        driver.findElement(logoutButton).click();
    }
}
