package alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class IntroToAlerts {

    @Test
    public void acceptAlertTest() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/alerts");

        WebElement acceptBox = driver.findElement(By.xpath("//button[@id='alertButton']"));
        acceptBox.click();
        driver.switchTo().alert().accept();
    }

    @Test
    public void dismissAlerts() throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/alerts");

        WebElement dismiss = driver.findElement(By.xpath("//button[@id='confirmButton']"));
        Thread.sleep(2000);
        dismiss.click();
        driver.switchTo().alert().dismiss();
    }

    @Test
    public void sendKeysAcceptAerts() throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/alerts");

        WebElement senKeys = driver.findElement(By.xpath("//button[@id='promtButton']"));
        Thread.sleep(2000);
        senKeys.click();
        driver.switchTo().alert().sendKeys("Aigerim");
        driver.switchTo().alert().accept();
    }
}
