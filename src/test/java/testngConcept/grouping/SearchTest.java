package testngConcept.grouping;

import org.testng.annotations.Test;

public class SearchTest {

    @Test (groups = {"smoke","regression"})
    public void searchByKeyWord(){


    }
    @Test(groups = "regression")
    public void searchByFilter(){

    }
}

