package testngConcept;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgIntro {

    public int sum(int number1, int number2){
        return number1 + number2;
    }

    @Test(priority = 2, invocationCount = 8)
    public void test1() {
        System.out.println("This is test 1");
        int actualValue = sum(4,3);
        int expectedValue = 7;
//        if(actualValue == expectedValue){
//            System.out.println("Passed");
//        }else{
//            System.out.println("Failed");
//        }
        Assert.assertEquals(actualValue,expectedValue);
    }

    @Test(priority = 3)
    public void test2(){
        System.out.println("This is test 2");
        int actualValue = sum(4,3);
        int expectedValue = 7;
        Assert.assertTrue(actualValue==expectedValue);
    }

    @Test(priority = 1)
    public void test3(){
        System.out.println("This is test 3");
    }


}

