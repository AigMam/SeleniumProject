package com.qa.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {

    public MainPage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//a[@id='signin2']")
    WebElement signUpButton;

    @FindBy(xpath = "//a[@id='login2']")
    WebElement loginButton;

    @FindBy(xpath = "//a[@id='itemc']")
    List<WebElement> categories;

    public void clickSignUpButton(){
        signUpButton.click();
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public void chooseCategory(String chooseCategory){
        for (WebElement category:categories){
            if(category.getText().contains(chooseCategory)){
                category.click();
                break;
            }
        }
    }


}
