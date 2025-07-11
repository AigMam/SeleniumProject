package com.qa.saucelab.tests;

import com.qa.saucelab.pages.SauceLabLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceLabLoginTest extends SauceLabTestBase {

    @Test(dataProvider = "positiveLogin", dataProviderClass = TestData.class)
    public void validateSauceLabLoginPage(String username, String password, String title, String url){
        SauceLabLoginPage sauceLabLoginPage = new SauceLabLoginPage(driver);
        sauceLabLoginPage.loginFunctionality(username, password);
        Assert.assertEquals(driver.getTitle(), title);
        Assert.assertEquals(driver.getCurrentUrl(), url);


    }
}
