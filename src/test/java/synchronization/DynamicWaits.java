package synchronization;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class DynamicWaits {

    @Test
    public void implicitWaitSyntax() {
        WebDriver driver = new ChromeDriver();
        //this waits for the element to appear on page before throwing NoSuchElementException.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //waits for the page load to complete.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    @Test
    public void explicitWaitSyntax() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element = driver.findElement(By.id("eryuh"));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("eryuh")));
        element.click();

        WebElement element1 = driver.findElement(By.id("sdtfghj"));
        wait.until(ExpectedConditions.elementToBeClickable(element1));
        element1.click();
    }

    @Test
    public void fluentWaitSyntax() {
        WebDriver driver = new ChromeDriver();
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(30)).// total timeout
                        ignoring(NoSuchElementException.class).//ignoring exception
                        ignoring(StaleElementReferenceException.class).//ignoring exception
                        pollingEvery(Duration.ofSeconds(1));//how often do we want to check the condition
        fluentWait.until(ExpectedConditions.elementToBeClickable(By.xpath("rftgyh")));
    }
}
