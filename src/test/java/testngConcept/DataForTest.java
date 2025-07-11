package testngConcept;

import org.testng.annotations.DataProvider;

public class DataForTest {


    @DataProvider(name = "pairs")
    public Object[][] getData(){
        return new Object[][]{
                {"Ahmet", "Aiza"},
                {"Rose", "Jack"},
                {"Begi", "Brad"},
                {"Aigerim", "Renat"}
        };
    }


}
