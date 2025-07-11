package com.qa.bank.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class BankManagerPage {

    public BankManagerPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@ng-class='btnClass1']")
    WebElement addCustomer;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postCode;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement addCustomerButton;

    @FindBy(xpath = "//button[@ng-class='btnClass2']")
    WebElement openAccountButton;

    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement customerNameBox;

    @FindBy(xpath = "//select[@id='currency']")
    WebElement currencyBox;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;

    @FindBy(xpath = "//button[@ng-class='btnClass3']")
    WebElement customerButton;

//    @FindBy(xpath = "//button[@class='btn home']")
//    WebElement homeButton;

    @FindBy(tagName = "input")
    WebElement searchBar;

    @FindBy(xpath = "//td[@class='ng-binding']")
    List<WebElement> customerInformation;


    public void fillOutTheInformation(WebDriver driver, String firstName,
                                      String lastName, String postCode, String expectedMessage) {
        addCustomer.click();
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.postCode.sendKeys(postCode);
        addCustomerButton.click();

        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(expectedMessage));
        alert.accept();
    }

    public void checkOpenAccountFunctionality(WebDriver driver, String customer,
                                              String currencyBox, String
                                                      expectedMessage) {
        openAccountButton.click();
        BrowserUtils.selectBy(customerNameBox, customer, "text");
        BrowserUtils.selectBy(this.currencyBox, currencyBox, "value");
        submitButton.click();

        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(expectedMessage));
    }

    public void getCustomerInformationFunctionality(String customerName, String lastName, String zipCode) {
        customerButton.click();
        searchBar.sendKeys(customerName);

        List<String> expectedInformation = Arrays.asList(customerName, lastName, zipCode);

        for (int i = 0; i < customerInformation.size(); i++) {

            Assert.assertEquals(customerInformation.get(i).getText(), expectedInformation.get(i));

        }
    }
}

