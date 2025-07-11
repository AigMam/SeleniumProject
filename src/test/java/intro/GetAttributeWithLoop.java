package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class GetAttributeWithLoop {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.w3.org/TR/2019/NOTE-wai-aria-practices-1.1-20190814/examples/checkbox/checkbox-1/checkbox-1.html");

        Thread.sleep(2000);

        WebElement collapsebutton = driver.findElement(By.tagName("button"));
        collapsebutton.click();
        Thread.sleep(3000);
       List<WebElement> checkboxes = driver.findElements(By.xpath("//div[@role='checkbox']"));

        for(WebElement checkbox : checkboxes){
                if (checkbox.getDomAttribute("aria-checked").equals("false")) {
                    checkbox.click();
                    Thread.sleep(2000);
            }

        }
    }
}
