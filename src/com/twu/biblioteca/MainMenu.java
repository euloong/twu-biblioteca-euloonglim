package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainMenu {

    private final String welcome = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    private final String invalidMessage = "Please select a valid option!";
    private final String goodBye = "Goodbye!";

   ArrayList<String> books = new ArrayList<String>(Arrays.asList(
           "1. Clean Code | Robert C. Martin | 2008",
           "2. Don't Make Me Think | Steve Krug | 2000",
           "3. Test Driven Development | Kent Beck | 2000"));

   ArrayList<String> options = new ArrayList<String>(Arrays.asList(
           "Please select an option from the following:",
            "1. List of books",
            "2. Quit"));

    public void showWelcomeMessage() {
        System.out.println(welcome);
    }

    public void showInvalidMessage() {
        System.out.println(invalidMessage);
    }

    public void showGoodbyeMessage() {
        System.out.println(goodBye);
    }

    public void showOptions() {
        for(int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i));
        }
        System.out.print(">");
    }

    public void showList() {
        for(int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
    }

    public void manageOptions() {
        int counter = 0;
        Scanner scanner = new Scanner(System.in);

        while (counter == 0) {
            String userInput = scanner.next();
            if(userInput.equals("1")) {
                showList();
                counter = 1;
            }
            else if(userInput.equals("2")) {
                showGoodbyeMessage();
                System.exit(0);
            }
            else {
                showInvalidMessage();
            }
        }
    }
}
