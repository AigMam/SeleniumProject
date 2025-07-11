package actionsclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionMethod {

    @Test
    public void ContextClick() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/context_menu");

        WebElement box = driver.findElement(By.cssSelector("#hot-spot"));
        Actions action = new Actions(driver);

        //*****DON'T FORGET "PERFORM" AT THE END*****
        action.contextClick(box).perform();
    }

    @Test
    public void practiceContextClick() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.navigate().to("https://demo.guru99.com/test/simple_context_menu.html");

        WebElement rightButton = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
        Actions action1 = new Actions(driver);
        action1.contextClick(rightButton).perform();
    }

    @Test
    public void doubleClick() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.navigate().to("https://demo.guru99.com/test/simple_context_menu.html");

        WebElement doubleClickBox = driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickBox).perform();
    }


}
