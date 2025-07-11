package exceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import javax.swing.plaf.TableHeaderUI;
import java.time.Duration;

public class HandlingPopup {

    @Test
    public void testSmallModalPopup() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/modal-dialogs");

        Thread.sleep(2000);
        WebElement smallModalButton = driver.findElement(By.xpath("//button[@id='showSmallModal']"));
        smallModalButton.click();

        WebElement popUp = driver.findElement(By.xpath("//div[@class='modal-content']"));
        popUp.click();

        try{
        WebElement largeModalPopup = driver.findElement(By.id("showLargeModal"));
        largeModalPopup.click();

    }catch(ElementClickInterceptedException e){
//            e.printStackTrace();
            System.out.println(e.getMessage());
            driver.findElement(By.id("closeSmallModal")).click();
            WebElement largeModalPopup = driver.findElement(By.id("showLargeModal"));
            largeModalPopup.click();
        }




    }
}
