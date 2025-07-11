package actionsclass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HorizontalSlider {

    @Test
    public void practice() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");

        Thread.sleep(2000);
        WebElement slider = driver.findElement(By.tagName("input"));

        WebElement range = driver.findElement(By.xpath("//span[@id='range']"));

        String expectedRange = "3.5";
        while (!range.getText().equals(expectedRange)){
            slider.sendKeys(Keys.ARROW_RIGHT); // it presses right button on the keyboard
            Thread.sleep(1000);
        }
        Assert.assertEquals(range.getText(), expectedRange);
    }
}
