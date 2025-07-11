package intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RealTestCase {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.thespruceeats.com/");

        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        String exceptedTitle = "5 Recipes To Warm Up Your Kitchen in March";

        if(actualTitle.equals(exceptedTitle)) {
            System.out.println("Title is passed");
        }else{
            System.out.println("Title is failed");
        }

        String actualGoDaddyURL = driver.getCurrentUrl();
        String expectedGoDaddyURL = "https://www.thespruceeats.com/";
        System.out.println(actualGoDaddyURL.equals(expectedGoDaddyURL) ? "URL is passed" : "URL is failed");
//        Thread.sleep(2000);// it will pause your sustem for 2 second
        driver.quit();
    }
}
