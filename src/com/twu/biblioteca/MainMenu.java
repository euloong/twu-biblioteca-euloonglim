package com.twu.biblioteca;

import java.util.Scanner;

public class MainMenu {
    public static void showOptions() {
        System.out.println("Please select an option from the following:\n" + "1. List of books");
        System.out.print(">");
    }

    public static void manageOptions() {
        // create scanner to read command-line input
        Scanner scanner = new Scanner(System.in);
        // get the input as a string
        int option = scanner.nextInt();

        if (option == 1) {
            Book.showList();
        }
    }
}
