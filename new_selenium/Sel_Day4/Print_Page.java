package Sel_Day4;

import org.openqa.selenium.Pdf;
import org.openqa.selenium.PrintsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.print.PrintOptions;
import org.openqa.selenium.print.PageMargin;
import org.openqa.selenium.print.PageSize;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class Print_Page {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\user\\Desktop\\Selenium_Project\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
 
            driver.get("https://www.selenium.dev/");

            PrintOptions printOptions = new PrintOptions();
            printOptions.setOrientation(PrintOptions.Orientation.LANDSCAPE);
            printOptions.setPageRanges("1-2");
            printOptions.setPageSize(new PageSize(29.7, 21.0));
            PageMargin margins = new PageMargin(1.0, 1.0, 1.0, 1.0);
            printOptions.setPageMargin(margins);
            printOptions.setScale(0.50);
            printOptions.setBackground(true);
            printOptions.setShrinkToFit(true);

            if (driver instanceof PrintsPage) {
                PrintsPage printer = (PrintsPage) driver;
                Pdf pdf = printer.print(printOptions);

                byte[] pdfBytes = Base64.getDecoder().decode(pdf.getContent());

                FileOutputStream fos = new FileOutputStream("selenium_printed_page.pdf");
                fos.write(pdfBytes);
                fos.close();

                System.out.println("Web page printed successfully! File saved as selenium_printed_page.pdf");
            } else {
                System.out.println("This driver does not support page printing.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
