package selectclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class SelectBasics {

    @Test
    public  void selectMethods() throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/dropdown");

        WebElement optionBox = driver.findElement(By.xpath("//select[@id='dropdown']"));

        Select select = new Select(optionBox); //it works on the box that you provided

        String actualDefault = select.getFirstSelectedOption().getText();
        String expectedDefault = "Please select an option";
        Assert.assertEquals(actualDefault, expectedDefault);

        select.selectByVisibleText("Option 1"); // it will choose option 1 with visible text
        Thread.sleep(2000);

        select.selectByValue("2"); // it will choose option 2 with Value of value
        Thread.sleep(2000);

        select.selectByIndex(1); // it will choose option 1 with index value

        // It will print out all the option from dropdown
        List<WebElement> allOptions = select.getOptions();
        List<String> expectedOptions = Arrays.asList("Please select an option", " Option 1", " Option 2");

        for (int i = 0; i < allOptions.size(); i++) {
            Assert.assertEquals(allOptions.get(i), expectedOptions.get(i));
        }
    }
}

