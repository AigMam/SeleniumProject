package com.qa.blaze.test;

import com.qa.blaze.pages.MainPage;
import com.qa.blaze.pages.SignUpPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static utils.Driver.driver;


public class SignUpTest extends BlazeTestBase{

    @Parameters({"userName", "password", "message"})
    @Test
    public void validateSignUpFunctionality(String userName, String password, String message) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSignUpButton();

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.signUpFunctionality(driver, userName, password, message);
    }


}
