package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;



public class UserTest {

    @Test
    public void shouldValidateUser() {
        MainMenuImplementation mainMenuImplementation = new MainMenuImplementation();
        boolean validUser = mainMenuImplementation.validateUser("123-1234", "password");

        Assert.assertTrue(validUser);
    }
}
