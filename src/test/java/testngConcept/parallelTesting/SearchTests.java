package testngConcept.parallelTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTests {


   WebDriver driver;
    @Parameters("browser")
    @BeforeClass
    public void setup(String browser) {
        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        }
    }

    @Test
    public void searchByArtist() throws InterruptedException {
        driver.get("https://www.google.com/");
       Thread.sleep(2000);
    }

    @Test
    public  void searchByDate() throws InterruptedException {
        driver.get("https://www.google.com/");
        Thread.sleep(2000);
    }

    @Test
    public  void searchByVenue() throws InterruptedException {
        driver.get("https://www.google.com/");
        Thread.sleep(2000);
    }

    @Test
    public void searchByCity() throws InterruptedException {
        driver.get("https://www.google.com/");
        Thread.sleep(2000);

    }


}
