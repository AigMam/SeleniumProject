package seleniumLocators;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IntroToCSS {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.cssSelector("input[id='user-name']"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.cssSelector("input[id='password']"));
        password.sendKeys("secret_sauce");

        WebElement login = driver.findElement(By.cssSelector("input[id=login-button]"));
        login.click();

//        driver.get("https://www.saucedemo.com/inventory.html");
//        System.out.println(driver.getCurrentUrl().contains("inventory.html") ?
//                "Test is passed" : "Test is failed");

        String url = driver.getCurrentUrl();
        if (url.contains("inventory")) {
            System.out.println("Test is passed");
        } else {
            System.out.println("Test is failed");
        }

        WebElement backpackadd = driver.findElement(By.cssSelector("button[id='add-to-cart-sauce-labs-backpack']"));
        backpackadd.click();

        WebElement tshirt = driver.findElement(By.cssSelector("button[id='add-to-cart-sauce-labs-bolt-t-shirt']"));
        tshirt.click();

        WebElement cart = driver.findElement(By.cssSelector("a[class='shopping_cart_link"));
        cart.click();

        WebElement checkout = driver.findElement(By.cssSelector("button[id='react-burger-menu-btn']"));
        checkout.click();

        Faker faker = new Faker();
        faker.name().firstName();

        faker.name().lastName();

        WebElement firstName = driver.findElement(By.cssSelector("input[id='first-name']"));
        firstName.sendKeys(faker.name().firstName());

        WebElement lastName = driver.findElement(By.cssSelector("input[id='last-name']"));
        lastName.sendKeys(faker.name().lastName());

        WebElement postalcode = driver.findElement(By.cssSelector("input[id='postal-code']"));
        postalcode.sendKeys(faker.address().zipCode());

        WebElement cont = driver.findElement(By.tagName("input[id='continue']"));
        cont.click();

        WebElement finish = driver.findElement(By.cssSelector("button[id='finish']"));
        finish.click();

        WebElement header = driver.findElement(By.cssSelector("h2[class='complete-header']"));
        if (header.isDisplayed()) {
            System.out.println("The Header is displayed");
        } else {
            System.out.println("The header is NOT displayed");
        }
        Thread.sleep(2000);
    }
}

