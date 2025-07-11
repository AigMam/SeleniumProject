package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class FindElements {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("file:///C:/Users/Aigerim%20M/Downloads/codeWiseWebsite.html");

        List<WebElement> boxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        for(WebElement box : boxes){
            if(box.isDisplayed() && box.isEnabled() && !box.isSelected()){
                box.click();
            }
        }

        driver.navigate().to("https://the-internet.herokuapp.com/");
        List<WebElement> examples = driver.findElements(By.xpath("//ul//li"));
        int counter = 0;

        for (WebElement example : examples){
                counter++;
            System.out.println(example.getText());
        }
        System.out.println(counter);

        //someone's example
        List<WebElement>links= driver.findElements(By.xpath("//li//a[@href]"));
        for (WebElement link : links){
            System.out.println(link.getText());
        }
        System.out.println(links.size());

        int count = 0;
        for (WebElement example : examples){
            if(example.getText().length() >= 12){
                System.out.println(example.getText());
                count++;
            }
            System.out.println(count);
        }
    }
}

