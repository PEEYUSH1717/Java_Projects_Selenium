package Sel_Day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class microsoft_edge_browser {
    public static void main(String[] args) {

        System.setProperty("webdriver.edge.driver",
                "C:\\Users\\user\\Desktop\\Selenium_Project\\edgedriver_win64\\msedgedriver.exe");

        WebDriver driver = new EdgeDriver();

        driver.get("https://www.google.com");

        System.out.println("Page title: " + driver.getTitle());

        driver.quit();
    }
}
