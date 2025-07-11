package selectclass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;

public class SelectPracticeFinal {

    @Test
    public void valideFilterSearchFunctionality() {

        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.cars.com/shopping/");

        WebElement acceptCookies=driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        acceptCookies.click();

        WebElement newusedButton = driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
        BrowserUtils.selectBy(newusedButton, "new_cpo", "value");

        WebElement makeButton = driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.selectBy(makeButton, "Lexus", "text");

        WebElement modelsButton = driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.selectBy(modelsButton, "lexus-rx_350", "value");

        WebElement nomaxButton = driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        Select select = new Select(nomaxButton);
        String actualDefault = select.getFirstSelectedOption().getText();
        String expectedDefault = "No max price";
        Assert.assertEquals(actualDefault, expectedDefault);

        WebElement distanceButton = driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.selectBy(distanceButton, "40", "value");

        WebElement zipcodeButton = driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zipcodeButton.clear();

        zipcodeButton.sendKeys("60018", Keys.ENTER);

        WebElement header = driver.findElement(By.xpath("//h1[@class='spark-heading-1 sds-page-section__title']"));
        String actualHead = header.getText();
        Assert.assertTrue(actualHead.contains("New and certified used Lexus RX 350 for sale near"));

        List<WebElement> allTitles = driver.findElements(By.xpath("//h2[@class='title']"));
        for (WebElement title : allTitles) {
            Assert.assertTrue(title.getText().contains("Lexus RX 350"));
        }
    }
}

