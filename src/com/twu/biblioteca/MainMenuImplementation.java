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
            new Book("Clean Code", "Robert C. Martin", 2008, false),
            new Book("Don't Make Me Think", "Steve Krug", 2000, false),
            new Book("Test Driven Development", "Kent Beck", 2000, false)));
    // private Object index;

    private ArrayList<Item> movies = new ArrayList<Item>(Arrays.asList(
            new Movie("Star Wars: Episode IV - A New Hope", "George Lucas", 1977, "9", false),
            new Movie("Star Wars: Episode V - The Empire Strikes Back", "Irvin Kershner", 1980, "10", false),
            new Movie("Star Wars: Episode VI - Return of the Jedi", "Richard Marquand", 1983, "8", false)));

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
        System.out.println("Enter the number of the " + items + " you want to checkout:"); //To Fix: prints object
    }

    private void showNoItemsMessage(ArrayList<Item> items) {
        System.out.println("Sorry, no " + items + " left!"); //To Fix: prints object
    }

    public void showSuccessfulItemCheckOutMessage(ArrayList<Item> items) {
        System.out.println("Thank you! Enjoy the " + items); //To Fix: prints object
    }

    private void showUnsuccessfulItemCheckOutMessage(ArrayList<Item> items) {
        System.out.println("Sorry, that " + items + " is not available"); //To Fix: prints object
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

   public void checkOutBook() { //used by test to check display
        checkOutItems(this.books);
    }

    public void checkOutMovie() { //used by test to check display
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
