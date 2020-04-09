package com.twu.biblioteca;

import java.util.Scanner;

public class MainMenu {

    public void welcome() {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public void showOptions() {
        System.out.println("Please select an option from the following:\n" + "1. List of books");
        System.out.print(">");
    }

    public void showList() {
        System.out.println("1. Clean Code | Robert C. Martin | 2008\n" + "2. Don't Make Me Think | Steve Krug | 2000\n" + "3. Test Driven Development | Kent Beck | 2000\n");
    }

    public void showInvalidMessage() {
        System.out.println("Please select a valid option!");
    }

    public void manageOptions() {
        int i = 0;
        Scanner scanner = new Scanner(System.in);

        while (i == 0) {
            String input = scanner.next();
            if(input.equals("1")) {
                showList();
                i = 1;
            }
            else {
                showInvalidMessage();
                //i = 1;
            }
        }
    }
}
