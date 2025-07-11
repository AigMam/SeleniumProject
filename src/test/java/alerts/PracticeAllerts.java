package alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class PracticeAllerts {

    @Test
    public void deleteCustomer() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/delete_customer.php");

        WebElement idtext = driver.findElement(By.xpath("//input[@name='cusid']"));
        idtext.sendKeys("Good morning!");

        WebElement submitButton = driver.findElement(By.xpath("//input[@name='submit']"));
        submitButton.click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }

    @Test
    public void practiceAlerts() throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsButton = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        jsButton.click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        WebElement jsConfirm = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        jsConfirm.click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();


        WebElement jsPrompt = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        jsPrompt.click();
        System.out.println(driver.switchTo().alert().getText());
        Thread.sleep(2000);
        driver.switchTo().alert().sendKeys("Summer");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
    }
}
