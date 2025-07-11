package testngConcept.grouping;

import org.testng.annotations.Test;

public class CheckoutTest {

    @Test(groups = {"checkout","regression"})
    public void addItemToCard(){


    }
    @Test (groups = {"checkout","regression"})
    public void applyCouponCode(){

    }

    @Test(groups = {"checkout","regression","smoke"})
    public void completeCheckOut(){


    }
}

