package com.qa.bank.tests;

import com.qa.bank.pages.BankLoginPage;
import com.qa.bank.pages.BankManagerPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class BankManagerTest extends BankTestBase {

    @Test
    public void validateAddcustomerFunctionality() {
        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.clickManagerLoginButton();

        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.fillOutTheInformation(driver, "Aigerim", "Mam",
                "60016", "Customer added successfully");
    }

    @Test
    public void validateOpenAccountFunctionality() {
        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.clickManagerLoginButton();

        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.fillOutTheInformation(driver, "Aigerim", "Mam",
                "60016", "Customer added successfully");

        bankManagerPage.checkOpenAccountFunctionality(driver, "Aigerim Mam",
                "Dollar", "Account created successfully");
    }

    @Parameters({"name", "lastName", "zipCode","message" ,"customer", "currency", "message2"})
    @Test
    public void validateBankTransaction(String name, String lastName, String zipCode, String customer,
                                        String currency, String message, String message2) {
        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.clickManagerLoginButton();

        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.fillOutTheInformation(driver, name, lastName,
                zipCode, message);

        bankManagerPage.checkOpenAccountFunctionality(driver, customer,
                currency, message2);
        bankManagerPage.getCustomerInformationFunctionality(name,lastName,zipCode);




    }
}

