package seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LocatorIntro2 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("file:///C:/Users/Aigerim%20M/Downloads/codeWiseWebsite.html");

        //Locator TAGNAME
        WebElement javaVersion = driver.findElement(By.tagName("u"));
        System.out.println(javaVersion.getText());

        //Locator LINKTEXT
        WebElement javaLinkedText= driver.findElement(By.linkText("Java"));
        javaLinkedText.click();

        WebElement javapage = driver.findElement(By.tagName("h1"));
        System.out.println(javapage.getText());
        driver.navigate().back();
        WebElement selenium = driver.findElement(By.linkText("Selenium"));
        selenium.click();
        WebElement seleniumHeader = driver.findElement(By.tagName("h1"));
        System.out.println(seleniumHeader.getText());
        driver.navigate().back();

        //Locator Partial-LinkText

        WebElement restApiLink = driver.findElement(By.partialLinkText("Rest"));
        restApiLink.click();










    }
}
