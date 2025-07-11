package seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class XPATH1 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/");

        WebElement abTesting = driver.findElement(By.linkText("A/B Testing"));
        abTesting.click();

        // Absolute XPATH: single slash and start from beginning to end
        WebElement header = driver.findElement(By.xpath("/html/body/div[2]/div/div/h3"));
        System.out.println(header.getText());

        WebElement paragraph = driver.findElement(By.xpath("/html/body/div[2]/div/div/p"));
        System.out.println(paragraph.getText());

        WebElement paragraph1=driver.findElement(By.xpath("//h3"));
        System.out.println(paragraph1.getText());

        WebElement paragraph2=driver.findElement(By.xpath("//h3[.='A/B Test Control']"));
        System.out.println(paragraph2.getText());

        WebElement paragraph3=driver.findElement(By.xpath("//h3[contains(text(),'Control')]"));
        System.out.println(paragraph3.getText());

        WebElement paragraph4 = driver.findElement(By.xpath("//a[@target='_blank']"));
        System.out.println(paragraph4.getText());











    }
}
