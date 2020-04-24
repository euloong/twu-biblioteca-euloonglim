package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UserSession {

    private ArrayList<User> users = new ArrayList<>(Arrays.asList(
            new User("123-1234", "password")));

    public boolean validateUserLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please login with your library number (in the format xxx-xxxx):\n");
        String libraryNumber = scanner.nextLine();
        System.out.print("Please enter your password):\n");
        String password = scanner.nextLine();

        return validateUser(libraryNumber, password);
    }

    public boolean validateUser(String libraryNumber, String password) {
        boolean validUser = false;

        for (User user : this.users) {
            validUser = user.isUserValid(libraryNumber, password);
        }
        return validUser;
    }

    public void showInvalidLoginMessage() {
        System.out.println("Sorry, those login details were not recognised. Goodbye!");
    }
}
