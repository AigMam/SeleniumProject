package intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.smartcardio.ATR;


public class IntroToSelenium {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();// make my window maximize

        driver.get("https://www.amazon.com/");

        //actual comes from website
        String actualTitle = driver.getTitle(); // to make sure we are on the right page
        System.out.println(actualTitle);
        String exceptedTitle = "Amazon.com. Spend less. Smile more.";// it will come from you(story)

        if(actualTitle.equals(exceptedTitle)) {
            System.out.println("Title is passed");
        }else{
            System.out.println("Title is failed");
        }


        driver.get("https://www.facebook.com/");

        String actualTitleFacebook = driver.getTitle();
        System.out.println(actualTitleFacebook);
        String expectedTiTleFacebook = "Facebook - log in or sign up";

        if(actualTitleFacebook.equals(expectedTiTleFacebook)){
            System.out.println("FacebookTitle is passed");
        }else{
            System.out.println("FacebookTitle is failed");
        }

        String actualFacebookURL = driver.getCurrentUrl();// to make sure you are on right page
        String expectedFacebookURL = ("https://www.facebook.com/");

        System.out.println(actualFacebookURL.equals(expectedFacebookURL) ? "URL passed" : "URL failed");

//        driver.quit();// it closes the browser








    }
}
