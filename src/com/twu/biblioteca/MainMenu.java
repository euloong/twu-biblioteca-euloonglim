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

    public void manageOptions() {
        // create scanner to read command-line input
        Scanner scanner = new Scanner(System.in);
        // get the input as a string
        int option = scanner.nextInt();

        if (option == 1) {
            showList();
        }
    }
}
