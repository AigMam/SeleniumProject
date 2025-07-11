package JSMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class JavaScriptMethods {

    @Test
    public void practice() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://codewise.academy/");

        WebElement watchVideo = driver.findElement(By.linkText("Watch Presentation"));
//        watchVideo.click();// if it does not work!

        Actions actions = new Actions(driver);
//        actions.click(watchVideo).perform();// if it does not work as well!!

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", watchVideo);
    }


    @Test
    public void practiceJS() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/radio-button");

        Actions actions = new Actions(driver);

        WebElement yesButton = driver.findElement(By.xpath("//input[@id='yesRadio']"));
//        yesButton.click();

//        actions.click(yesButton).perform();

//        JavascriptExecutor java = (JavascriptExecutor) driver;
//        java.executeScript("arguments[0].click()", yesButton);

        BrowserUtils.clickJS(driver, yesButton);

        WebElement selectedText = driver.findElement(By.xpath("//p[@class='mt-3']"));
        Assert.assertEquals(selectedText.getText(), "You have selected Yes");
    }

    @Test
    public void scrollIntoViewPractice() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://codewise.academy/");

        WebElement AhmetInstructor = driver.findElement(By.xpath("//div[.='Ahmet']"));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//
//        js.executeScript("arguments[0].scrollIntoView(true)", AhmetInstructor);
        BrowserUtils.scrollWithJS(driver,AhmetInstructor);
        Thread.sleep(2000);

        WebElement startYourC = driver.findElement(By.xpath("//div[contains(text(),'Start your')]"));
        BrowserUtils.scrollWithJS(driver, startYourC);
//        js.executeScript("arguments[0].scrollIntoView(true)", startYourC);
    }

    @Test
    public void practiceScroll() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        WebElement button3 = driver.findElement(By.cssSelector("#newWindowsBtn"));
        BrowserUtils.scrollWithJS(driver, button3);
        button3.click();


    }
}
