package testngConcept;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderLogic {

//    @DataProvider(name = "pairs")
//    public Object[][] getData(){
//        return new Object[][]{
//                {"Ahmet", "Aiza"},
//                {"Rose", "Jack"},
//                {"Begi", "Brad"},
//                {"Aigerim", "Renat"}
//        };
//    }
    @Test(dataProvider = "pairs", dataProviderClass = DataForTest.class)
    public void pair1(String firstPair, String secondPair){
        System.out.println("We are pairs " + firstPair + " and " + secondPair+" ");
    }

//    @Test
//    public void pair2(){
//        System.out.println("We are pairs Rose and Jack");
//    }
//
//    @Test
//    public void pair3(){
//        System.out.println("We are pairs Begi and Brad");
//    }
//
//    @Test
//    public void pair4(){
//        System.out.println("We are pairs Aigerim and Renat");
//    }
}
