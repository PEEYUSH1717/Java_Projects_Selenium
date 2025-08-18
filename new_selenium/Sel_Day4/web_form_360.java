package Sel_Day4;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class web_form_360 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://360homedecor.uk/book-appointment");
		Thread.sleep(3000);

		WebElement dropdown = driver.findElement(By.tagName("select"));
		Select select = new Select(dropdown);
		select.selectByIndex(3);
		Thread.sleep(3000);

		WebElement dropdown2 = driver
				.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div/div/div/div/form/div[2]/div/select"));
		Select select2 = new Select(dropdown2);
		select2.selectByIndex(3);
		Thread.sleep(3000);

		WebElement f_name = driver.findElement(By.id("first_name"));
		f_name.sendKeys("Peeyush");
		Thread.sleep(1000);

		WebElement l_name = driver.findElement(By.id("last_name"));
		l_name.sendKeys("Pal Singh");
		Thread.sleep(1000);

		WebElement town = driver.findElement(By.id("apt_city"));
		town.sendKeys("Agra");
		Thread.sleep(1000);

		WebElement phone = driver.findElement(By.id("phone_number"));
		phone.sendKeys("8868929664");
		Thread.sleep(1000);

		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("peeyushsingh0707@gmail.com");
		Thread.sleep(1000);

		File resume = new File("C:/Users/user/Downloads/REPORT_FORM.pdf");
		WebElement uploadInput = driver.findElement(By.id("layoutFiles"));
		uploadInput.sendKeys(resume.getAbsolutePath());

		WebElement book = driver
				.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div/div/div/div/form/div[10]/button"));
		book.click();
		Thread.sleep(5000);

		System.out.println("Done");

	}

}