package com.qa.saucelab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceLabLoginPage {

    public SauceLabLoginPage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='user-name']")
    WebElement userName;

   @FindBy(xpath = "//input[@id='password']")
    WebElement password;

   @FindBy(xpath = "//input[@id='login-button']")
   WebElement loginButton;

   public void loginFunctionality(String userName, String password){
       this.userName.sendKeys(userName);
       this.password.sendKeys(password);
       loginButton.click();

   }
}
