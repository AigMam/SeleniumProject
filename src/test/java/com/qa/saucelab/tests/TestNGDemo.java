package com.qa.saucelab.tests;

import org.testng.annotations.*;

public class TestNGDemo {


    @BeforeClass
    public static void beforeClass(){
        System.out.println("This is after class");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("This is before method");
    }
    @Test
    public  void loginTest(){
        System.out.println("This login method");
    }
    @Test(groups = "checkoutTest")
    public  void checkOutTest(){
        System.out.println("This is checkout test");
    }
    @Test @Ignore
    public void searchTest(){
        System.out.println("This is search method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("This is after method");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("This is after class");
    }
}
