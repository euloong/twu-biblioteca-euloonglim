package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

public class UserSessionTest {

    @Test
    public void shouldValidateUser() {
        UserSession userSession = new UserSession();
        boolean validUser = userSession.validateUser("123-1234", "password");
        System.out.print(validUser);
        Assert.assertTrue(validUser);
    }
}
