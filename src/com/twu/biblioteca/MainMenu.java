package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainMenu {

    private final String welcome = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    private final String invalidMessage = "Please select a valid option!";
    private final String goodBye = "Goodbye!";
    private final String checkOutBookReference = "Enter the number of the book you want to checkout:";

    ArrayList<String> options = new ArrayList<>(Arrays.asList(
            "Please select an option from the following:",
            "1. List of books",
            "2. Checkout a book",
            "3. Quit"));

   ArrayList<Book> books = new ArrayList<>(Arrays.asList(
            new Book("Clean Code", "Robert C. Martin", 2008, false),
            new Book("Don't Make Me Think", "Steve Krug", 2000, false),
            new Book("Test Driven Development", "Kent Beck", 2000, false)));

    public void showWelcomeMessage() {
        System.out.println(welcome);
    }

    public void showInvalidMessage() {
        System.out.println(invalidMessage);
    }

    public void showGoodbyeMessage() {
        System.out.println(goodBye);
    }

    public void showBookCheckOutReferenceMessage() {
        System.out.println(checkOutBookReference);
    }

    public void showOptions() {
        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i));
        }
        System.out.print(">");
    }

    public void manageOptions() {
        int counter = 0;
        Scanner optionsScanner = new Scanner(System.in);

        while (counter == 0) {
            String userInput = optionsScanner.next();
            if (userInput.equals("1")) {
                showBookList();
                showOptions();
            } else if (userInput.equals("2")) {
                showBookList();
                manageBookList();
            } else if (userInput.equals("3")) {
                showGoodbyeMessage();
                System.exit(0);
            } else {
                showInvalidMessage();
            }
        }
    }

    public void showBookList() {
        for (int i = 0; i < this.books.size(); i++) {
            Book book = this.books.get(i);
            if (book.getCheckedOut() == false) {
                int count = countCheckedOutBooks();
                System.out.println(String.format(
                        "%d. %s | %s | %d",
                        (i + 1) - count, book.getTitle(), book.getAuthor(), book.getYearPublished()));
            }
        }
    }

    public int countCheckedOutBooks() {
        int count = 0;
        for (Book b : this.books){
            if (b.getCheckedOut()) count++;
        }
        return count;
    }

    public void manageBookList() {
        int count = countCheckedOutBooks();
      if ((this.books.size() - count) == 0) {
          System.out.println("Sorry, no books left!");
      } else {
          showBookCheckOutReferenceMessage();
          Scanner bookScanner = new Scanner(System.in);
          String userInput = bookScanner.next();
          int index = (Integer.parseInt(userInput) - 1) + count;
          Book book = this.books.get(index);
          book.setCheckedOut();
      }
        showOptions();
        manageOptions();
    }
}
