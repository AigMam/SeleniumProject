package com.qa.saucelab.tests;

import org.testng.annotations.*;

public class Hooks {
    @BeforeSuite
    public static void beforeSuite(){
        System.out.println("This is before suite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("This is before test");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("This is before test");
    }

    @AfterSuite
    public static  void afterSuite(){
        System.out.println("This is before suite");
    }
}
