package actionsclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ClickAndHoldMethod {

    @Test
    public void practice() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement acceptCookies = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        wait.until(ExpectedConditions.visibilityOf(acceptCookies));

        Actions actions = new Actions(driver);
        actions.click(acceptCookies).perform();
        actions.scrollByAmount(300, 300).perform();

        WebElement blueCircle = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement blueBox = driver.findElement(By.xpath("//div[@class='test1']"));

        String actualText = blueBox.getText();
        String expectedText = "Drag the small circle here ...";
        Assert.assertEquals(actualText, expectedText);

        actions.clickAndHold(blueCircle).moveToElement(blueBox).release().perform();

        // need to reassign the WebElement because of StaleElementReference Exception!!!
        blueBox = driver.findElement(By.xpath("//div[@class='test1']"));
        actualText = blueBox.getText();
        expectedText = "You did great!";
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void validateFunctionality() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");

        Actions actions = new Actions(driver);
        actions.scrollByAmount(300,300);

        WebElement acceptButton = driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']"));
        acceptButton.click();

        WebElement dropHereBox = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
        String actualText = dropHereBox.getText();
        String expectedText = "Drop here";
        Assert.assertEquals(actualText, expectedText);

        WebElement notAcceptable = driver.findElement(By.xpath("//div[@id='notAcceptable']"));
        Thread.sleep(2000);
        actions.clickAndHold(notAcceptable).moveToElement(dropHereBox).release().perform();

        actualText = dropHereBox.getText();
        expectedText = "Drop here";
        Assert.assertEquals(actualText, expectedText);

        WebElement acceptableBox = dropHereBox.findElement(By.xpath("//div[@id='acceptable']"));
        actions.clickAndHold(acceptableBox).moveToElement(dropHereBox).release().perform();

        Assert.assertEquals(dropHereBox.getText(), "Dropped!");


        }
    }

