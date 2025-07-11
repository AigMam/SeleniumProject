package checkboxesradiobuttons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class PracticeHeroku {


    @Test
    public void selectCheckBox() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkBox2 = driver.findElement(By.xpath("//form/input/following::input"));
        Assert.assertTrue(checkBox2.isSelected());

        WebElement checkBox1 = driver.findElement(By.xpath("//form/input/preceding::input"));
        checkBox1.click();
        Assert.assertTrue(checkBox1.isSelected());
    }

    @Test
    public void practiceOrangeHRM() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/");

        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        WebElement recbutton = driver.findElement(By.xpath("//span[.='Recruitment']"));
        recbutton.click();

//        Thread.sleep(3000);
//        WebElement firstcheckbox = driver.findElement(By.xpath("//div[@class='oxd-table-body']/div[1]//label"));
//        firstcheckbox.click();

        List<WebElement> allboxes = driver.findElements(By.xpath("//div[@class='oxd-table-body']/div//label"));
        for (WebElement element : allboxes){
            element.click();
        }





    }
}
