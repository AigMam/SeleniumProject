package unitTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeUnitTesting {
    public static void main(String[] args) {
//        String text = "apple";
//        String text2 = replaceA(text);
//        System.out.println(text2);
        System.out.println(replaceA("apple"));
        System.out.println(replaceA("banana"));
        System.out.println(replaceA("Aigerim"));
        System.out.println(replaceA(" "));
    }

    @Test
    public void test1(){
        Assert.assertEquals(replaceA("apple"), "*pple");
    }

    public static String replaceA(String str){
        if(str == null){
            return null;
//            if (str.trim().isEmpty()) System.out.println();

            }
//        return "*" + str.substring(1);// with first "a".
        return str.replace('A', '*').replace('a', '*');
    }
}
