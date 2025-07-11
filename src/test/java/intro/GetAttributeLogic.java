package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class GetAttributeLogic {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");

        WebElement name = driver.findElement(By.xpath("//input[@value='John Doe']"));
        System.out.println(name.getText());
        System.out.println(name.getDomAttribute("value"));
        System.out.println(name.getDomAttribute("placeholder"));



    }
}
