package com.qa.bank.tests;

import com.qa.bank.pages.BankLoginPage;
import com.qa.bank.pages.BankManagerPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BankLoginTest extends  BankTestBase{ //parent=child

    // In test class, Ahmet generally use Validate keyword in test class
    @Parameters("bankName")
    @Test
    public  void validateLoginPageInformation(String bankName){
        BankLoginPage bankLoginPage = new BankLoginPage(driver);
//        bankLoginPage
//        Assert.assertFalse(driver.getTitle(),bankName);


    }
}
