package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainMenuImplementation implements MainMenu {

    private ArrayList<String> options = new ArrayList<>(Arrays.asList(
            "1. List books",
            "2. Checkout a book",
            "3. List movies",
            "4. Checkout a movie",
            "5. Quit"));

    private ArrayList<Item> books = new ArrayList<Item>(Arrays.asList(
            new Book("Clean Code", "Robert C. Martin", 2008),
            new Book("Don't Make Me Think", "Steve Krug", 2000),
            new Book("Test Driven Development", "Kent Beck", 2000)));

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

    private void showItemsCheckOutReferenceMessage(ArrayList<Item> items) {
        if (items == this.books) {
            System.out.println("Enter the number of the book you want to checkout:");
        } else if (items == this.movies) {
            System.out.println("Enter the number of the movie you want to checkout:");
        }
    }

    private void showNoItemsMessage(ArrayList<Item> items) {
        if (items == this.books) {
            System.out.println("Sorry, no books left!");
        } else if (items == this.movies) {
            System.out.println("Sorry, no movies left!");
        }
    }

    public void showSuccessfulItemCheckOutMessage(ArrayList<Item> items) {
        if (items == this.books) {
            System.out.println("Thank you! Enjoy the book");
        } else if (items == this.movies) {
            System.out.println("Thank you! Enjoy the movie");
        }
    }

    private void showUnsuccessfulItemCheckOutMessage(ArrayList<Item> items) {
        if (items == this.books) {
            System.out.println("Sorry, that book is not available");
        } else if (items == this.movies) {
            System.out.println("Sorry, that movie is not available");
        }
    }

    private int countCheckedOutItems(ArrayList<Item> items) {
        int numberOfCheckedOutItems = 0;
        for (Item item : items) {
            if (item.isCheckedOut()) {
                numberOfCheckedOutItems++;
            }
        }
        return numberOfCheckedOutItems;
    }

    public void displayAvailableBooks() {
        displayAvailableItems(this.books);
    }

    public void displayAvailableMovies() {
        displayAvailableItems(this.movies);
    }

    private void displayAvailableItems(ArrayList<Item> items) {
        if (items.size() == countCheckedOutItems(items)) {
            showNoItemsMessage(items);
        } else {
            displayItems(items);
        }
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
        displayAvailableItemsToCheckOut(this.books);
    }

    public void displayAvailableMoviesToCheckOut() {
        displayAvailableItemsToCheckOut(this.movies);
    }

    public void displayAvailableItemsToCheckOut(ArrayList<Item> items) {
        if (items.size() == countCheckedOutItems(items)) {
            showNoItemsMessage(items);
        } else {
            displayAvailableItems(items);
            showItemsCheckOutReferenceMessage(items);
            checkOutItems(items);
        }
    }

    //used by test to check only available books are displayed
    public void checkOutBook() {
        checkOutItems(this.books);
    }

    //used by test to check only available books are displayed
    public void checkOutMovie() {
        checkOutItems(this.movies);
    }

    private void checkOutItems(ArrayList<Item> items) {
        try {
            checkUserSelectedValidItem(items);
        } catch (NumberFormatException e) {
            showUnsuccessfulItemCheckOutMessage(items);
        }
    }

    public void checkUserSelectedValidItem(ArrayList<Item> items) {
        int index = Integer.parseInt(userInput()) - 1;
        if (index >= 0 && index < items.size()) {
            itemIsCheckedOutOrNot(items, index);
        } else {
            showUnsuccessfulItemCheckOutMessage(items);
        }
    }

    public String userInput() {
        Scanner itemScanner = new Scanner(System.in);
        return itemScanner.next();
    }

    public void itemIsCheckedOutOrNot(ArrayList<Item> items, int index) {
        Item item = items.get(index);
        if (!item.isCheckedOut()) {
            item.setCheckedOut();
            showSuccessfulItemCheckOutMessage(items);
        } else {
            showUnsuccessfulItemCheckOutMessage(items);
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
