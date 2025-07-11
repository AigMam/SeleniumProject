package unitTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReverseStr {

    public static void main(String[] args) {
        System.out.println(reverseString("cat"));
        System.out.println(reverseString("Aigerim"));
        System.out.println(reverseString(null));
    }

    @Test
    public void test1(){
        Assert.assertEquals("tac", "tac");
    }


    public static String reverseString(String str){
        StringBuilder reverse = new StringBuilder();
        for (int i = str.length()-1; i >= 0; i--) {
            reverse.append(str.charAt(i));
        }
        return reverse.toString();
    }
}
