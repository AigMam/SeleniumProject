package com.qa.bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class BankCustomerPage {


    public BankCustomerPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement yourName;

    @FindBy(xpath = "//button[@class='btn btn-default']")
    WebElement loginButton;

    @FindBy(xpath = "//strong/span")
    WebElement validateYourName;

    @FindBy(xpath = "//button[@ng-class='btnClass2']")
    WebElement depositButton;

    @FindBy(xpath = "//input[@ng-model='amount']")
    WebElement amountOfDeposit;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitDepositButton;

    @FindBy(xpath = "//span[@ng-show='message']")
    WebElement depositMessage;

    @FindBy(xpath = "//button[@ng-class='btnClass3']")
    WebElement withdrawalButton;

    @FindBy(xpath = "//input[@type='number']")
    WebElement amountOfWithdrawal;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitWithdrawButton;

    @FindBy(xpath = "//span[@ng-show='message']")
    WebElement withdrawMessage;

    @FindBy(xpath = "//strong[@class='ng-binding'][2]")
    WebElement balance;

    @FindBy(xpath = "//button[@ng-class='btnClass1']")
    WebElement transactionButton;

    @FindBy(xpath = "//tr[@id='anchor0']//td[@class='ng-binding'][2]")
    WebElement credit;

    @FindBy(xpath = "//tr[@id='anchor1']//td[@class='ng-binding'][2]")
    WebElement debit;

    public void transactionFunctionality(String customerName, String expectedMessage, String depositAmount, String expectedDepositMessage,
                                         String withDrawAmount, String expectedWithDrawMessage, String expectedColor) throws InterruptedException {

        //Login as Customer
        BrowserUtils.selectBy(yourName, customerName, "text");
        Thread.sleep(2000);
        loginButton.click();
        Assert.assertEquals(validateYourName.getText(), expectedMessage);

        //Do deposit Transaction
        depositButton.click();
        amountOfDeposit.sendKeys(depositAmount);
        submitDepositButton.click();
        Assert.assertEquals(depositMessage.getText(), expectedDepositMessage);
        Assert.assertEquals(depositMessage.getCssValue("color"), expectedColor);
        Thread.sleep(3000);
        //Do WithDrawl Transaction
        withdrawalButton.click();
        Thread.sleep(1000);
        amountOfWithdrawal.sendKeys(withDrawAmount);
        Thread.sleep(1000);
        submitWithdrawButton.click();
        Thread.sleep(1000);
        Assert.assertEquals(withdrawMessage.getText(), expectedWithDrawMessage);
        Assert.assertEquals(withdrawMessage.getCssValue("color"), expectedColor);
        Thread.sleep(3000);
        //Save the balance
        int balanceAmount = Integer.parseInt(balance.getText());

        //Do Validation of Transaction
        transactionButton.click();
        int finalAmount = Integer.parseInt(credit.getText()) - Integer.parseInt(debit.getText());
        Assert.assertEquals(finalAmount, balanceAmount);

    }


}





