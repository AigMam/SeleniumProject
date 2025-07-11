package com.qa.blaze.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class SignUpPage {

    public SignUpPage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='sign-username']")
    WebElement userName;

    @FindBy(xpath = "//input[@id='sign-password']")
    WebElement password;

    @FindBy(xpath = "//button[@onclick='register()']")
    WebElement singUpButton;

    public void signUpFunctionality(WebDriver driver, String userName, String password, String expectedMessage) throws InterruptedException {
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        singUpButton.click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),expectedMessage);
        alert.accept();
    }



}
