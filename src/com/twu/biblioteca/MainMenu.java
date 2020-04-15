package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainMenu {

    private ArrayList<String> options = new ArrayList<>(Arrays.asList(
            "1. List of books",
            "2. Checkout a book",
            "3. Quit"));

    private ArrayList<Book> books = new ArrayList<>(Arrays.asList(
            new Book("Clean Code", "Robert C. Martin", 2008, false),
            new Book("Don't Make Me Think", "Steve Krug", 2000, false),
            new Book("Test Driven Development", "Kent Beck", 2000, false)));

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

    public void showSuccessfulCheckOutMessage() { System.out.println("Thank you! Enjoy the book"); }

    public void showOptions() {
        System.out.print("Please select an option from the following:\n");
        for (String option : options) {
            System.out.println(option);
        }
        System.out.print(">");
    }

    public void displayAvailableBooks() {
        for (int i = 0; i < this.books.size(); i++) {
            Book book = this.books.get(i);
            if (book.isCheckedOut() == false) {
                int reference = i + 1;
                System.out.println(reference + ". " + book);
           }
        }
    }

    public void checkOutBook() {
        showBookCheckOutReferenceMessage();
        Scanner bookScanner = new Scanner(System.in);

        String userInput = bookScanner.next();
           try {
               int index = Integer.parseInt(userInput) - 1;
               if(index >= 0 && index < this.books.size()) {
                   Book book = this.books.get(index);
                   book.setCheckedOut();
                   showSuccessfulCheckOutMessage();
               } else {
                   System.out.println("Sorry, that book is not available");
               }
           } catch (NumberFormatException e) {
               System.out.println("Sorry, that book is not available");
           }
    }

    public int countCheckedOutBooks() {
        int numberOfCheckedOutBooks = 0;
        for (Book book : this.books){
            if (book.isCheckedOut()) {
                numberOfCheckedOutBooks++;
            }
        }
        return numberOfCheckedOutBooks;
    }

    public void checkForAvailableBooks() {
        if (this.books.size() == countCheckedOutBooks()) {
            showNoBooksMessage();
        }
    }
}
