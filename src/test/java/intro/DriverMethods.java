package intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
1-driver.get()
2-driver.manage.window.maximize()
3-driver.getTitle()
4-driver.getCurrentURl()
5-driver.close()
6-driver.quit()
7-driver.navigate.to()
8-driver.navigate.back()
9-driver.navigate.forward()
10-driver.navigate.refresh()
11-driver.getPageSource()
 */

public class DriverMethods {
    public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);

        driver.get("https://www.facebook.com/");
        System.out.println(driver.getTitle());

        Thread.sleep(2000);

        driver.navigate().back();//Google

        Thread.sleep(2000);

        driver.navigate().forward();//Facebook

        Thread.sleep(2000);

        driver.navigate().refresh();

        System.out.println(driver.getPageSource());// HTML structure of the page

        driver.quit();


    }
}
