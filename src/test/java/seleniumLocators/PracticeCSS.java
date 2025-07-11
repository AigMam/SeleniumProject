package seleniumLocators;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeCSS {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demoqa.com/text-box");

        Faker faker = new Faker();

        WebElement fullname = driver.findElement(By.cssSelector("input#userName"));
        fullname.sendKeys(faker.name().fullName());

        WebElement userEmail = driver.findElement(By.cssSelector("input#userEmail"));
        userEmail.sendKeys("jhsjhlk@gmail.com");

        WebElement currentAddress = driver.findElement(By.cssSelector("textarea#currentAddress"));
        currentAddress.sendKeys(faker.address().fullAddress());

        WebElement permanentAddress = driver.findElement(By.cssSelector("textarea#permanentAddress"));
        permanentAddress.sendKeys(faker.address().fullAddress());

        WebElement submitButton = driver.findElement(By.cssSelector("button#submit"));
        submitButton.click();

        driver.quit();







    }
}
