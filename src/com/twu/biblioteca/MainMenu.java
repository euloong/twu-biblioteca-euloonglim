package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

public class MainMenu {

    private ArrayList<String> options = new ArrayList<>(Arrays.asList(
            "1. List of books",
            "2. Checkout a book",
            "3. Quit"));

    public void showWelcomeMessage() { System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!"); }

    public void showInvalidMessage() {
        System.out.println("Please select a valid option!");
    }

    public void showGoodbyeMessage() {
        System.out.println("Goodbye!");
    }

    public void showBookCheckOutReferenceMessage() { System.out.println("Enter the number of the book you want to checkout:"); }

    public void showNoBooksMessage() {
        System.out.println("Sorry, no books left!");
    }

    public void showOptions() {
        System.out.print("Please select an option from the following:\n");
        for (String option : options) {
            System.out.println(option);
        }
        System.out.print(">");
    }

    public void displayAvailableBooks() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        // I'm stuck here, created a new instance of the class to access the books array but it does not store the setCheckedOut

        for (int i = 0; i < bibliotecaApp.books.size(); i++) {
            Book book = bibliotecaApp.books.get(i);
            if (!book.isCheckedOut()) {
                int reference = i + 1;
                System.out.println(reference + ". " + book);
           }
        }
    }
}
