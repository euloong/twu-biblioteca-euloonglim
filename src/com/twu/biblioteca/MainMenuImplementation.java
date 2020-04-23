package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainMenuImplementation implements MainMenu {

    private ArrayList<String> options = new ArrayList<>(Arrays.asList(
            "1. List books",
            "2. Checkout a book",
            "3. List movies",
            "4. Quit"));

    private ArrayList<Item> books = new ArrayList<Item>(Arrays.asList(
            new Book("Clean Code", "Robert C. Martin", 2008, false),
            new Book("Don't Make Me Think", "Steve Krug", 2000, false),
            new Book("Test Driven Development", "Kent Beck", 2000, false)));
    // private Object index;

    private ArrayList<Item> movies = new ArrayList<Item>(Arrays.asList(
            new Movie("Star Wars: Episode IV - A New Hope", "George Lucas", 1977, "9"),
            new Movie("Star Wars: Episode V - The Empire Strikes Back", "Irvin Kershner", 1980, "10"),
            new Movie("Star Wars: Episode VI - Return of the Jedi", "Richard Marquand", 1983, "8")));

    public void showWelcomeMessage() {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public void showInvalidMessage() {
        System.out.println("Please select a valid option!");
    }

    public void showGoodbyeMessage() {
        System.out.println("Goodbye!");
    }

    public void showBookCheckOutReferenceMessage() {
        System.out.println("Enter the number of the book you want to checkout:");
    }

    public void showNoBooksMessage() {
        System.out.println("Sorry, no books left!");
    }

    public void showSuccessfulCheckOutMessage() {
        System.out.println("Thank you! Enjoy the book");
    }

    public void showUnsuccessfulCheckOutMessage() {
        System.out.println("Sorry, that book is not available");
    }

    public int countCheckedOutBooks() {
        int numberOfCheckedOutBooks = 0;
        for (Item item : this.books) {
            if (item.isCheckedOut()) {
                numberOfCheckedOutBooks++;
            }
        }
        return numberOfCheckedOutBooks;
    }

    public void displayAvailableBooks() {
        if (this.books.size() == countCheckedOutBooks()) {
            showNoBooksMessage();
        } else {
            displayItems(this.books);
        }
    }

    public void displayAvailableMovies() {
        //  if (this.movies.size() == countCheckedOutMovies()) {
        //      showNoMoviesMessage();
        //  } else {
        displayItems(this.movies);
    }

    private void displayItems(ArrayList<Item> items) {
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (!item.isCheckedOut()) {
                int reference = i + 1;
                System.out.println(reference + ". " + item);
            }
        }
    }

    public void displayAvailableBooksToCheckOut() {
        if (this.books.size() == countCheckedOutBooks()) {
            showNoBooksMessage();
        } else {
            displayAvailableBooks();
            showBookCheckOutReferenceMessage();
            checkOutBook();
        }
    }

    public void checkOutBook() {
        try {
            checkUserSelectedValidBook();
        } catch (NumberFormatException e) {
            showUnsuccessfulCheckOutMessage();
        }
    }

    public void checkUserSelectedValidBook() {
        int index = Integer.parseInt(userInput()) - 1;
        if (index >= 0 && index < this.books.size()) {
            bookIsCheckedOutOrNot(index);
        } else {
            showUnsuccessfulCheckOutMessage();
        }
    }

    public String userInput() {
        Scanner bookScanner = new Scanner(System.in);
        return bookScanner.next();
    }

    public void bookIsCheckedOutOrNot(int index) {
        Item item = this.books.get(index);
        if (!item.isCheckedOut()) {
            item.setCheckedOut();
            showSuccessfulCheckOutMessage();
        } else {
            showUnsuccessfulCheckOutMessage();
        }
    }

    public void showOptions() {
        System.out.print("Please select an option from the following:\n");
        for (String option : options) {
            System.out.println(option);
        }
        System.out.print(">");
    }
}
