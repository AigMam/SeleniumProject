package testngConcept.grouping;

import org.testng.annotations.Test;

public class LoginTest {

    @Test (groups = {"smoke","regression"})
    public void validLogin() {

    }

    @Test (groups = "regression")
    public void invalidLogin() {

    }

    @Test(groups = "regression")
    public void forgotPassword() {

    }
}

