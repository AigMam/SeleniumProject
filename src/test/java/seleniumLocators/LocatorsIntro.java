package seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("file:///C:/Users/Aigerim%20M/Downloads/codeWiseWebsite.html");

        WebElement header = driver.findElement(By.id("codewise1"));

        String actualHeader = header.getText();
        String expectedHeader = "CodeWise Academy";
        System.out.println(actualHeader.equals(expectedHeader) ? "Header is passed" : "Header is failed");

        WebElement actualParagraph = driver.findElement(By.id("details2"));
        System.out.println(actualParagraph.getText());

        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.sendKeys("Aigerim");

        WebElement lastName = driver.findElement(By.name("lastName"));
        lastName.sendKeys("Mambeteminova");

        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("3125991283");

        WebElement email = driver.findElement(By.id("userName"));
        email.sendKeys("aigesha1103@gmail.com");

        WebElement address = driver.findElement(By.name("address1"));
        address.sendKeys("1551 Ashland");

        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys("Des Plaines");

        WebElement state = driver.findElement(By.name("state"));
        state.sendKeys("IL");

        WebElement postcode = driver.findElement(By.name("postalCode"));
        postcode.sendKeys("60016");

        WebElement alltools = driver.findElement(By.className("group_checkbox"));
        System.out.println(alltools.getText());

        WebElement javaBox = driver.findElement(By.id("cond1"));
        if (javaBox.isDisplayed() && javaBox.isEnabled() && !javaBox.isSelected()) {
            javaBox.click();
        }

        WebElement cucumberbox = driver.findElement(By.id("cond4"));
        if (cucumberbox.isDisplayed() && cucumberbox.isEnabled() && !cucumberbox.isSelected()) {
            cucumberbox.click();
        }

        WebElement javab = driver.findElement(By.id("cond3"));
        if (javab.isDisplayed() && javab.isEnabled() && !javab.isSelected()) {
            javab.click();
        }


    }
}

