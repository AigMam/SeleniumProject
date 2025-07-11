package selectclass;

import io.opentelemetry.context.Scope;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.text.BreakIterator;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class SelectPractice2 {

    @Test
    public void validateTravelTicketWithUtils() throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement onewayButton = driver.findElement(By.xpath("//input[@value='oneway']"));
        onewayButton.click();

       WebElement fourPass = driver.findElement(By.xpath("//select[@name='passCount']"));
//        Select select = new Select(fourPass);
//        select.selectByValue("4");

        BrowserUtils.selectBy(fourPass,"4", "value");

        WebElement defaultCountry = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select select1 = new Select(defaultCountry);
//        String actualDefault = select1.getFirstSelectedOption().getText();
//        String expectedDefault = "Acapulco";
//        Assert.assertEquals(actualDefault, expectedDefault);

//        select1.selectByValue("Paris");
//        Thread.sleep(2000);
        BrowserUtils.selectBy(defaultCountry,"Paris", "value");

//        WebElement monthBox = driver.findElement(By.xpath("//select[@name='fromMonth']"));
//        Select select2 = new Select(monthBox);
//        select2.selectByIndex(8);

        WebElement dayBox = driver.findElement(By.xpath("//select[@name='fromDay']"));
//        Select select3 = new Select(dayBox);
//        select3.selectByVisibleText("15");
        BrowserUtils.selectBy(dayBox, "15", "text");

        WebElement arrivingBox = driver.findElement(By.xpath("//select[@name='toPort']"));
//        Select select4 = new Select(arrivingBox);
//        select4.selectByVisibleText("San Francisco");
        BrowserUtils.selectBy(arrivingBox, "San Francisco", "text");

        WebElement arrivingMonth = driver.findElement(By.xpath("//select[@name='toMonth']"));
//        Select select5 = new Select(arrivingMonth);
//        select5.selectByValue("12");
        BrowserUtils.selectBy(arrivingMonth, "12", "value");

        WebElement arrivingDate = driver.findElement(By.xpath("//select[@name='toDay']"));
//        Select select6 = new Select(arrivingDate);
//        select6.selectByVisibleText("15");
        BrowserUtils.selectBy(arrivingDate,"15", "text");

        WebElement firstClass = driver.findElement(By.xpath("//input[@value='First']"));
        firstClass.click();

        WebElement airlines = driver.findElement(By.xpath("//select[@name='airline']"));
        Select select7 = new Select(airlines);
        List<WebElement> allOptions = select7.getOptions();
        System.out.println("All airlines: " + allOptions.size());
        Assert.assertEquals(allOptions.size(), 4);

//        List<WebElement> allAirlinesOptions=airlines.getOptions();
//        List<String> expectedOptions= Arrays.asList("No Preference","Blue Skies Airlines","Unified Airlines",
//                "Pangea Airlines");
//
//        for(int i=0; i<allAirlinesOptions.size();i++){
//            Assert.assertEquals(allAirlinesOptions.get(i).getText(),expectedOptions.get(i));
//        }

       select7.selectByVisibleText("Unified Airlines");

        WebElement continueButton = driver.findElement(By.xpath("//input[@type='image']"));
        continueButton.click();

        WebElement header = driver.findElement(By.xpath("//font[@size='4']"));
        Assert.assertEquals(header.getText(), "After flight finder - No Seats Available");
    }


    @Test
    public void validateTravelTicket() throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement onewayButton = driver.findElement(By.xpath("//input[@value='oneway']"));
        onewayButton.click();

        WebElement fourPass = driver.findElement(By.xpath("//select[@name='passCount']"));
        Select select = new Select(fourPass);
        select.selectByValue("4");

        WebElement defaultCountry = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select select1 = new Select(defaultCountry);
        String actualDefault = select1.getFirstSelectedOption().getText();
        String expectedDefault = "Acapulco";
        Assert.assertEquals(actualDefault, expectedDefault);

        select1.selectByValue("Paris");
        Thread.sleep(2000);

        WebElement monthBox = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select select2 = new Select(monthBox);
        select2.selectByIndex(8);

        WebElement dayBox = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select select3 = new Select(dayBox);
        select3.selectByVisibleText("15");

        WebElement arrivingBox = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select select4 = new Select(arrivingBox);
        select4.selectByVisibleText("San Francisco");

        WebElement arrivingMonth = driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select select5 = new Select(arrivingMonth);
        select5.selectByValue("12");

        WebElement arrivingDate = driver.findElement(By.xpath("//select[@name='toDay']"));
        Select select6 = new Select(arrivingDate);
        select6.selectByVisibleText("15");

        WebElement firstClass = driver.findElement(By.xpath("//input[@value='First']"));
        firstClass.click();

        WebElement airlines = driver.findElement(By.xpath("//select[@name='airline']"));
        Select select7 = new Select(airlines);
        List<WebElement> allOptions = select7.getOptions();
        System.out.println("All airlines: " + allOptions.size());
        Assert.assertEquals(allOptions.size(), 4);

//        List<WebElement> allAirlinesOptions=airlines.getOptions();
//        List<String> expectedOptions= Arrays.asList("No Preference","Blue Skies Airlines","Unified Airlines",
//                "Pangea Airlines");
//
//        for(int i=0; i<allAirlinesOptions.size();i++){
//            Assert.assertEquals(allAirlinesOptions.get(i).getText(),expectedOptions.get(i));
//        }

        select7.selectByVisibleText("Unified Airlines");

        WebElement continueButton = driver.findElement(By.xpath("//input[@type='image']"));
        continueButton.click();

        WebElement header = driver.findElement(By.xpath("//font[@size='4']"));
        Assert.assertEquals(header.getText(), "After flight finder - No Seats Available");
    }
}


