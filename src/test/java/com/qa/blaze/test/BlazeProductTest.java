package com.qa.blaze.test;

import com.qa.blaze.pages.MainPage;
import com.qa.blaze.pages.ProductPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigReader;

import java.time.Duration;

public class BlazeProductTest extends BlazeTestBase {

    @Test(dataProvider = "products", dataProviderClass = BlazeTestData.class)
    public void validateProductInformation(String category, String product,
                                           String price, String description, String message) throws InterruptedException {

        MainPage mainPage = new MainPage(driver);
        mainPage.chooseCategory(category);

        ProductPage productPage = new ProductPage(driver);
        productPage.chooseProduct(product);

        productPage.productInformation(driver, product, price, description, message);


    }
}
