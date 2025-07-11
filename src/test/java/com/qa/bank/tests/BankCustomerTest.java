package com.qa.bank.tests;

import com.qa.bank.pages.BankCustomerPage;
import com.qa.bank.pages.BankLoginPage;
import com.qa.bank.pages.BankManagerPage;
import org.testng.annotations.Test;

public class BankCustomerTest extends BankTestBase{

    @Test
    public void validateTransactionFunctionality() throws InterruptedException {

        BankLoginPage bankLoginPage =new BankLoginPage(driver);
        bankLoginPage.clickManagerLoginButton();

        BankManagerPage bankManagerPage =new BankManagerPage(driver);
        bankManagerPage.fillOutTheInformation(driver,"Aigerim","Mam","60016", "Customer added successfully");
        bankManagerPage.checkOpenAccountFunctionality(driver,"Aigerim Mam","Dollar","Account created successfully with account Number :");
        Thread.sleep(2000);
        bankManagerPage.getCustomerInformationFunctionality("Aigerim","Mam","60016");
        Thread.sleep(3000);
        bankLoginPage.clickHomeButton();
        bankLoginPage.clickCustomerLoginButton();
        BankCustomerPage bankCustomerPage =new BankCustomerPage(driver);
        bankCustomerPage.transactionFunctionality("Aigerim","Welcome Aigerim Mam !!","500","Deposit Successful",
                "300","Transaction successful","rgba(255, 0, 0, 1)");

    }
}
