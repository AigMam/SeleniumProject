package checkboxesradiobuttons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CheckboxesPtactice {

    @Test
    public void selectCheckbox() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/checkbox");

        WebElement mainbutton = driver.findElement(By.xpath("//button[@title='Toggle']"));
        mainbutton.click();

        WebElement desktop = driver.findElement(By.xpath("//input[@id='tree-node-desktop']/.."));
        desktop.click();

        WebElement document = driver.findElement(By.xpath("//input[@id='tree-node-documents']/.."));
        document.click();

        List<WebElement> results = driver.findElements(By.xpath("//div[@id='result']/span"));

        List<String> textresult = new ArrayList<>();
        for (WebElement element : results) {
            textresult.add(element.getText());
        }
        Assert.assertTrue(textresult.contains("desktop"));
        Assert.assertTrue(textresult.contains("documents"));
    }

    @Test
    public void selectRadioButton() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/checkbox");

        WebElement yesbutton = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        yesbutton.click();

        Thread.sleep(1000);
        WebElement yesRadio = driver.findElement(By.id("yesRadio"));
        Assert.assertTrue(yesRadio.isSelected());

        Assert.assertTrue(yesRadio.isSelected());
    }
}


