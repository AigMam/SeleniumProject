package seleniumLocators;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class XPATHPractice2 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Faker faker = new Faker();

        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");

        WebElement makeAnApp = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        makeAnApp.click();

        WebElement firstName = driver.findElement(By.xpath("//input[@id='txt-username']"));
        firstName.sendKeys("John Doe");

        WebElement password = driver.findElement(By.xpath("//input[@id='txt-password']"));
        password.sendKeys("ThisIsNotAPassword");

        WebElement loginButton = driver.findElement(By.xpath("//button[@id='btn-login']"));
        loginButton.click();

        WebElement facility = driver.findElement(By.xpath("//select[@id='combo_facility']"));
        facility.sendKeys("Hongkong CURA Healthcare Center");

        WebElement applyForHospital = driver.findElement(By.xpath("//input[@id='chk_hospotal_readmission']"));
        applyForHospital.click();

        WebElement healtprogramm = driver.findElement(By.xpath("//input[@id='radio_program_medicaid']"));
        healtprogramm.click();

        WebElement data = driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
        data.sendKeys("20/04/2025");

        WebElement comment = driver.findElement(By.xpath("//textarea[@id='txt_comment']"));
        comment.sendKeys("I love Selenium!");

        WebElement bookButton = driver.findElement(By.xpath("//button[@id='btn-book-appointment']"));
        bookButton.click();

        WebElement header = driver.findElement(By.xpath("//h2[contains(text(),'Appointment Confirmation')]"));
        String actualHeader = header.getText();
        String expectedHeader = "Appointment Confirmation";
        System.out.println(actualHeader.equals(expectedHeader) ? "Header is passed" : "Header is failed");

        WebElement nfacility = driver.findElement(By.xpath("//p[@id='facility']"));
        WebElement applyforhos = driver.findElement(By.xpath("//p[@id='hospital_readmission']"));
        WebElement healhprogramm = driver.findElement(By.xpath("//p[@id='program']"));
        WebElement visitdata = driver.findElement(By.xpath("//p[@id='visit_date']"));

        System.out.println(nfacility.getText());
        System.out.println(applyforhos.getText());
        System.out.println(healhprogramm.getText());
        System.out.println(visitdata.getText());

        WebElement gotohome = driver.findElement(By.xpath("//a[@class=btn btn-default]"));
        gotohome.click();

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://katalon-demo-cura.herokuapp.com/";
        System.out.println(actualURL.equals(expectedURL)? "URL passed" : "URL failed");
        System.out.println(actualURL);
        driver.quit();











    }
}
