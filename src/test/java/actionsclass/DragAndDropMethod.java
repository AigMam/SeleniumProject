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

import javax.swing.*;
import java.time.Duration;

public class DragAndDropMethod {

    @Test
    public void practice() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement acceptCookies = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        wait.until(ExpectedConditions.visibilityOf(acceptCookies));
        Actions actions = new Actions(driver);
        actions.click(acceptCookies).perform();
        actions.scrollByAmount(300, 300).perform();

        WebElement blueCircle = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement orangeBox = driver.findElement(By.xpath("//div[@class='test2']"));

        String actualText = orangeBox.getText();// before Drag and Drop
        String expectedText = "... Or here.";
        Assert.assertEquals(actualText, expectedText);

        actions.dragAndDrop(blueCircle, orangeBox).perform();
        orangeBox = driver.findElement(By.xpath("//div[@class='test2']"));//Reasssign the orangeBox

//        Thread.sleep(2000);
        actualText = orangeBox.getText();// after Drag and Drop
        expectedText = "You did great!";
        Assert.assertEquals(actualText, expectedText);

        String actualColor = orangeBox.getCssValue("background-color");//It validates the color
        String expectedColor = "rgba(238, 111, 11, 1)";
        Assert.assertEquals(actualColor, expectedColor);
    }

    @Test
    public void validateDragAndDropFunctionality() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement dropHereText = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
        WebElement dropMeText = dropHereText.findElement(By.xpath("//div[@id='draggable']"));

        String actualText = dropHereText.getText();
        String expectedText = "Drop here";
        Assert.assertEquals(actualText, expectedText);


        Actions actions = new Actions(driver);
        actions.dragAndDrop(dropMeText,dropHereText).perform();

        actualText = dropHereText.getText();
        expectedText = "Dropped!";
        Assert.assertEquals(actualText, expectedText);

        String actualColor = dropHereText.getCssValue("background-color");
        String expectedColor = "rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualColor, expectedColor);




    }
}

