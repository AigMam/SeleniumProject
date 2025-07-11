package seleniumLocators;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class XPATHMethods {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://magento.softwaretestingboard.com/");

        WebElement searchbutton = driver.findElement(By.xpath("//input[@id='search']"));
        searchbutton.sendKeys("pants" + Keys.ENTER);

        WebElement size = driver.findElement(By.xpath("//div[@id='option-label-size-143-item-175']"));
        size.click();

        WebElement pantsSize = driver.findElement(By.xpath("//a[contains(text(), 'Caesar Warm-Up Pant ')]/../..//div[text()='32']"));
        pantsSize.click();

        WebElement pantsColor = driver.findElement(By.xpath("//a[contains(text(), 'Caesar Warm-Up Pant ')]/../../..//div[@aria-label='Black']"));
        pantsColor.click();

        WebElement addtoCartButton = driver.findElement(By.xpath("//a[contains(text(), 'Caesar Warm-Up Pant ')]/../../..//button[@title='Add to Cart']"));
        addtoCartButton.click();

        Thread.sleep(2000);

        WebElement goToCart = driver.findElement(By.xpath("//a[contains(text(), 'shopping cart')]"));
        goToCart.click();


    }
}
