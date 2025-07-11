package seleniumLocators;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class XPATHPractice {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Faker faker = new Faker();

        driver.navigate().to("https://formy-project.herokuapp.com/form");

        WebElement firstName =driver.findElement(By.xpath("//input[@id='first-name']"));
        firstName.sendKeys(faker.name().firstName());

        WebElement lastName = driver.findElement(By.xpath("//input[@id='last-name']"));
        lastName.sendKeys(faker.name().lastName());

        WebElement jobtitle = driver.findElement(By.xpath("//input[@id='job-title']"));
        jobtitle.sendKeys(faker.job().position());

        WebElement education = driver.findElement(By.xpath("//input[@id='radio-button-2']"));
        education.click();

        WebElement gender = driver.findElement(By.xpath("//input[@id='checkbox-2']"));
        if(gender.isDisplayed() && gender.isEnabled() && !gender.isSelected()){
            gender.click();
        }else{
            System.out.println("Invalid!");
        }

        WebElement experience = driver.findElement(By.xpath("//select[@id='select-menu']"));
        experience.sendKeys("2-4");
        Thread.sleep(2000);

        WebElement DOB = driver.findElement(By.xpath("//input[@id='datepicker']"));
        DOB.sendKeys("03/11/1991");

        Thread.sleep(5000);

        WebElement submit = driver.findElement(By.xpath("//a[@class='btn btn-lg btn-primary']"));
        submit.click();

        WebElement thanksheader = driver.findElement(By.xpath("//h1[.='Thanks for submitting your form']"));
        String actualHeader = thanksheader.getText();
        String expectedHeader = "Thanks for submitting your form";
        System.out.println(actualHeader.equals(expectedHeader) ? "Header is passed" : "Header is failed");

        WebElement finalform = driver.findElement(By.xpath("//div[contains(text(),'form')]"));
        String actualMessage = finalform.getText();
        String expectedMessage = "The form was successfully submitted!";
        System.out.println(actualMessage.equals(expectedMessage) ? "Header is passed" : "Header is failed");

        driver.quit();

    }
}
