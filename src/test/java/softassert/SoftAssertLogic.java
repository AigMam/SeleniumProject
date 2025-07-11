package softassert;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertLogic {

    public int sum(int number1, int number2) {
        return number1 + number2;
    }

    @Test
    public void hardAssert() {
        Assert.assertEquals(sum(5, 6), 11);
        System.out.println("I am test 1");
        Assert.assertEquals(sum(1, 3), 5); //when it fails, it stops the execution
        System.out.println("I am test 2");
        Assert.assertEquals(sum(0, 7), 7);
        System.out.println("I am test 3");
    }


    @Test
    public void softAssert() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(sum(5, 6), 11);
        System.out.println("I am test 1");
        softAssert.assertEquals(sum(1, 3), 5);
        System.out.println("I am test 2");
        softAssert.assertEquals(sum(0, 7), 7);
        System.out.println("I am test 3");
        softAssert.assertEquals(sum(0, 7), 7);
        System.out.println("I am test 3");
        softAssert.assertEquals(sum(0, 8), 7);
        System.out.println("I am test 3");
        softAssert.assertAll();
    }
}
