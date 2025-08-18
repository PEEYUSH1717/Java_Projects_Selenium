package Sel_Day4;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class alert_message {
    public static void main(String[] args) throws InterruptedException {
    	
        WebDriver driver = new ChromeDriver();
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")).click();

        Alert alrt=driver.switchTo().alert();
        System.out.println(alrt.getText());
        Thread.sleep(2000);
        alrt.dismiss();
        Thread.sleep(3000);
    }
}