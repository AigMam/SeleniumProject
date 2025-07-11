package testngConcept;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SauceLab {
    @Test
    public void validateHappyPathLogin() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");


        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Swag Labs";
        Assert.assertEquals(actualTitle, expectedTitle);

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(actualURL, expectedURL);
    }

    @Test
    public void validateLoginErrorMessage() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("sdfhads");

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.xpath("//h3"));
        String actualMessage = errorMessage.getText();
        String expectedMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualMessage, expectedMessage);
    }

//    @Test
//    public void validateProductInformation() {
//
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://www.saucedemo.com/");
//
//        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
//        userName.sendKeys("standard_user");
//
//        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
//        password.sendKeys("secret_sauce");
//
//        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
//        loginButton.click();
//
//        List<WebElement> items = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
//        Assert.assertEquals(items.size(), 6);
//
//        for (WebElement item : items) {
//            if (item.getText().equals("Sauce Labs Bolt T-Shirt")) {
//                item.click();
//                break;
//            }
//        }
//        WebElement header = driver.findElement(By.xpath("//div[@data-test='inventory-item-name']"));
//        String actualHeader = header.getText();
//        String expectedHeader = "Sauce Labs Bolt T-Shirt";
//        Assert.assertEquals(actualHeader, expectedHeader);
//
//        WebElement description = driver.findElement(By.xpath("//div[@data-test='inventory-item-desc']"));
//        Assert.assertTrue(description.getText().contains("heather gray"));
//
//        WebElement price = driver.findElement(By.xpath("//div[@data-test='inventory-item-price']"));
//        Assert.assertEquals(price.getText(), "$15.99");
//
//        WebElement addToCartButton = driver.findElement(By.xpath("//button[@id='add-to-cart']"));
//        Assert.assertTrue(addToCartButton.isDisplayed() && addToCartButton.isEnabled());
//
//        driver.quit();
//    }

    @Test
    public void validate() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");

        Faker faker = new Faker();

        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();

        List<WebElement> items = driver.findElements(By.cssSelector(".inventory_item_name"));
        Assert.assertEquals(items.size(), 6);

        for (WebElement item : items) {
            if (item.getText().equals("Sauce Labs Bolt T-Shirt")) {
                item.click();
                break;
            }
        }

        Thread.sleep(3000);

        WebElement addToCartButton = driver.findElement(By.xpath("//button[@id='add-to-cart']"));
        Assert.assertTrue(addToCartButton.isDisplayed() && addToCartButton.isEnabled());
        addToCartButton.click();

        WebElement cartButton = driver.findElement(By.xpath("//span[@data-test='shopping-cart-badge']"));
        Assert.assertTrue(cartButton.getText().equals("1"));
        cartButton.click();

        WebElement headerText = driver.findElement(By.xpath("//div[@data-test='inventory-item-name']"));
        Assert.assertEquals(headerText.getText(), "Sauce Labs Bolt T-Shirt");

        WebElement checkoutButton = driver.findElement(By.xpath("//button[@id='checkout']"));
        checkoutButton.click();

        WebElement firstName = driver.findElement(By.xpath("//input[@id='first-name']"));
        firstName.sendKeys(faker.name().firstName());

        WebElement lastName = driver.findElement(By.xpath("//input[@id='last-name']"));
        lastName.sendKeys(faker.name().lastName());

        WebElement zipcode = driver.findElement(By.xpath("//input[@id='postal-code']"));
        zipcode.sendKeys(faker.address().zipCode());

        WebElement continueButton = driver.findElement(By.xpath("//input[@id='continue']"));
        continueButton.click();

        WebElement totalPrice = driver.findElement(By.xpath("//div[@data-test='total-label']"));
        Assert.assertEquals(totalPrice.getText(), "Total: $17.27");

        WebElement finishButton = driver.findElement(By.xpath("//button[@id='finish']"));
        finishButton.click();

        WebElement header = driver.findElement(By.xpath("//h2[@data-test='complete-header']"));
        Assert.assertEquals(header.getText(), "Thank you for your order!");

        driver.quit();
    }
}