package unitTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestUserName {


    public boolean isValidUsername(String username) {
        if (username == null) return false;
        if (username.length() < 5 || username.length() > 15) return false;
        if (!Character.isLetter(username.charAt(0))) return false;
        return username.matches("[a-zA-Z0-9_]+");
    }

   @Test
    public void test1(){
       Assert.assertEquals(isValidUsername(null), false);
   }

   @Test
    public void test2(){
        Assert.assertTrue(isValidUsername("Aigerim"));
   }

   @Test
    public void testMinLength(){
        Assert.assertFalse(isValidUsername("Begi"));
   }

   @Test
    public void testMaxLength(){
        Assert.assertFalse(isValidUsername("BradPittttttttttttttttttttt"));
   }
   @Test
    public void testChars(){
        Assert.assertFalse(isValidUsername("sjgudsj()ghj"));
        Assert.assertFalse(isValidUsername("fg^58hj"));
        Assert.assertFalse(isValidUsername("0llow"));
        Assert.assertTrue(isValidUsername("hello_world"));
   }


}
