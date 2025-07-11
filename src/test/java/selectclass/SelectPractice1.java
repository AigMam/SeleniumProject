package selectclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SelectPractice1 {

    @Test
    public void selectMethodsPractice() throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("file:///C:/Users/Aigerim%20M/Downloads/codeWiseWebsite.html");

        WebElement defaultValue = driver.findElement(By.xpath("//select[@name='country']"));

        Select select = new Select(defaultValue);

        String actualDefault = select.getFirstSelectedOption().getText();
        String expectedDefault = "UNITED STATES";
        Assert.assertEquals(actualDefault, expectedDefault);

        select.selectByVisibleText("KYRGYZSTAN");
        Thread.sleep(2000);

        select.selectByValue("65");
        Thread.sleep(2000);

        select.selectByIndex(5);
        Thread.sleep(2000);

        List<WebElement> allOptions = select.getOptions();
        System.out.println("The total number of countries: " + allOptions.size());
        Assert.assertEquals(allOptions.size(), 264);
        for (WebElement allOption : allOptions) {
            System.out.println(allOption.getText());
        }
        driver.quit();
    }

}
