package actionsclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MoveToElement {

    @Test
    public void validateText() throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/hovers");

        List<WebElement> allUsers = driver.findElements(By.xpath("//h5"));
        List<WebElement> allPics = driver.findElements(By.xpath("//img[@alt='User Avatar']"));
        List<String> expectedUsers = Arrays.asList("name: user1" ,"name: user2" ,"name: user3");

        Actions actions = new Actions(driver);

        for (int i = 0; i < allPics.size(); i++) {
            //it will be hoverover each pic one by one
            actions.moveToElement(allPics.get(i)).perform();
            System.out.println(allUsers.get(i).getText());
            // it is the way of validation the List of usernames
            Assert.assertEquals(allUsers.get(i).getText(), expectedUsers.get(i));
            Thread.sleep(2000);
        }
    }

    @Test
    public void getProducts() throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/fx/expand");

        Thread.sleep(3000);
        WebElement acceptCookies = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        acceptCookies.click();

        Actions actions = new Actions(driver);
        actions.scrollByAmount(350,350).perform();

        List<WebElement> allImg = driver.findElements(By.xpath("//div[@class='product k-listview-item']//img"));
        List<WebElement> allProducts = driver.findElements(By.xpath("//h3"));
        List<WebElement> allPrice = driver.findElements(By.xpath("//div[@class='product-description']//p"));

        Map<String, String> productInf = new HashMap<>();
        for (int i = 0; i < allImg.size(); i++) {
            actions.moveToElement(allImg.get(i)).perform();
            productInf.put(allProducts.get(i).getText(), allPrice.get(i).getText());
            Thread.sleep(300);
        }
        System.out.println(productInf);
    }
}
