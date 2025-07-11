package alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BrowserPopUpPractice {

    @Test
    public void regularBrowser() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/geolocation");

        WebElement whereAmIbutton = driver.findElement(By.xpath("//button[@onclick='getLocation()']"));
        whereAmIbutton.click();
    }

    @Test
    public void browserWithDisabledLocation() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/geolocation");

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.geolocation", 0);
        options.setExperimentalOption("prefs",prefs);


        WebDriver driver1 = new ChromeDriver(options);
        WebElement whereAmIbutton = driver1.findElement(By.xpath("//button[@onclick='getLocation()']"));
        whereAmIbutton.click();
    }
}
