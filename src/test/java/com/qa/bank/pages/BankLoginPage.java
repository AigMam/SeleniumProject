package com.qa.bank.pages;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BankLoginPage {

    // We store our WebElements and Metdhods from LoginPage in this Class
    // CONSTRUCTOR is a way initialize your INSTANCE VARIABLE (belongs to class)
    // Every page,  we will create CONSTRUCTOR
    public BankLoginPage (WebDriver driver){
        //It means it will initialize the web element in this class
        PageFactory.initElements(driver, this);
    }

   @FindBy(xpath = "//button[.='Home']")
    WebElement homeButton;

    @FindBy(tagName = "strong")
    WebElement header;

    @FindBy(xpath = "//button[.='Customer Login']")
    WebElement customerLoginButton;

    @FindBy(xpath = "//button[contains(@ng-click,'manager()')]")
    WebElement managerLoginButton;

    public void checkLoginPageInformation(String expectedBankName){
        Assert.assertTrue(homeButton.isDisplayed() && homeButton.isEnabled());
        Assert.assertEquals(header.getText(), expectedBankName);
        Assert.assertTrue(customerLoginButton.isDisplayed() && customerLoginButton.isEnabled());
        Assert.assertTrue(managerLoginButton.isDisplayed() && managerLoginButton.isEnabled());
        // CTRL + D = duplicates the line
        // DO NOT provide any data in method(hard code)
    }

    public void clickManagerLoginButton(){
        managerLoginButton.click();
    }

    public void clickHomeButton(){
        homeButton.click();
    }

    public void clickCustomerLoginButton(){
        customerLoginButton.click();
    }









}
