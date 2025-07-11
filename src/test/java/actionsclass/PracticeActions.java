package actionsclass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class PracticeActions {

    @Test
    public void test1() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://skpatro.github.io/demo/iframes/");


        String firstPageWindowHandle = driver.getWindowHandle();
        WebElement pavilionButton = driver.findElement(By.xpath("//a[.='Pavilion']"));
        pavilionButton.click();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String window : windowHandles) {
            if (!window.equals(firstPageWindowHandle)) {
                driver.switchTo().window(window);
            }
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='primary-menu']//span[.='Selenium' and @class='menu-text']")));

        Actions actions = new Actions(driver);
        WebElement seleniumButtton = driver.findElement(By.xpath("//ul[@id='primary-menu']/li[2]/a"));
        actions.moveToElement(seleniumButtton).perform();

        WebElement seleniumPython = driver.findElement(By.xpath("//ul[@id='primary-menu']//li//span[@class='menu-item-text']//span[.='Selenium-Python']"));
        seleniumPython.click();

        List<WebElement> alllinks = driver.findElements(By.xpath("//p/a"));
        int actualSize = alllinks.size();
        int expectedsize = 22;
        Assert.assertEquals(actualSize, expectedsize);

        for(WebElement link : alllinks){
            System.out.println(link.getDomAttribute("href"));
        }
    }

    @Test
    public void test2() {

        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://skpatro.github.io/demo/iframes/");

        driver.switchTo().frame("Frame1");

        String firstPage = driver.getWindowHandle();

        WebElement category1 = driver.findElement(By.xpath("//a[.='Category1']"));
        category1.click();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String window : windowHandles) {
            if (!window.equals(firstPage)) {
                driver.switchTo().window(window);
            }
        }

        WebElement header = driver.findElement(By.xpath("//h1"));
        System.out.println(header.getText());

        List<WebElement> allheader = driver.findElements(By.xpath("//h3//a"));
        for (WebElement element : allheader){
            System.out.println(element.getText());
        }
        Assert.assertEquals(allheader.size(), "9");
    }

    @Test
    public void test3() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.saucedemo.com/");

        WebElement firstName = driver.findElement(By.cssSelector("input[id ='user-name']"));
        firstName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.cssSelector("input[id ='password']"));
        password.sendKeys("secret_sauce");

        WebElement login = driver.findElement(By.cssSelector("input[id ='login-button']"));
        login.click();

        String mainWindow = driver.getWindowHandle();

        WebElement twitter = driver.findElement(By.xpath("//a[@data-test='social-twitter']"));
        BrowserUtils.scrollWithJS(driver,twitter);
        twitter.click();

        for (String windowHandle : driver.getWindowHandles()){
            if(!mainWindow.equals(windowHandle)){
                driver.switchTo().window(windowHandle);
            }
        }
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.close();

        driver.switchTo().window(mainWindow);
        System.out.println(driver.getCurrentUrl());

        WebElement facebook = driver.findElement(By.xpath("//a[.='Facebook']"));
        BrowserUtils.scrollWithJS(driver, facebook);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click()", facebook);
    }
}
