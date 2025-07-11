package synchronization;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class PracticeWaits {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--host-resolver-rules=MAP *.doubleclick.net 127.0.0.1, MAP *.googlesyndication.com 127.0.0.1");

        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/automation-practice-form");
        Faker faker = new Faker();

        WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']"));
        firstName.sendKeys(faker.name().firstName());

        WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
        lastName.sendKeys(faker.name().lastName());

        WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
        email.sendKeys(faker.internet().emailAddress());

        WebElement femaleRadioButton = driver.findElement(By.cssSelector("label[for='gender-radio-2']"));
        femaleRadioButton.click();

        WebElement phoneNum = driver.findElement(By.xpath("//input[@placeholder='Mobile Number']"));
        phoneNum.sendKeys("3126751287");

        WebElement DOB = driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
        DOB.click();

        WebElement month = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
        Select select = new Select(month);
        select.selectByVisibleText("March");

        WebElement year = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
        Select selectYear = new Select(year);
        selectYear.selectByValue("1920");
        Thread.sleep(2000);
        WebElement subjectInput = driver.findElement(By.xpath("//div[@class='subjects-auto-complete__input']/input"));
        subjectInput.sendKeys("C");
        Thread.sleep(2000);

        WebElement compScie = driver.findElement(By.xpath("//div[.='Computer Science']"));
        compScie.click();

        WebElement sportCheckBox = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']"));
        sportCheckBox.click();

        WebElement uploadFileButton = driver.findElement(By.id("uploadPicture"));
        uploadFileButton.sendKeys("C:\\Users\\Aigerim M\\Desktop\\AigerimPhoto.jpg");

        WebElement curAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        curAddress.sendKeys("1110 Maple Dr, Des Plaines");
        Thread.sleep(2000);

        WebElement stateBox = driver.findElement(By.xpath("//div[@id='state']"));
        stateBox.click();
        Thread.sleep(2000);

        WebElement state = driver.findElement(By.xpath("//div[.='Haryana']"));
        state.click();
        Thread.sleep(2000);

        WebElement cityBox = driver.findElement(By.xpath("//div[.='Select City']"));
        cityBox.click();
        Thread.sleep(2000);

        WebElement city = driver.findElement(By.xpath("//div[.='Karnal']"));
        city.click();

        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
        submitButton.click();









    }
}
