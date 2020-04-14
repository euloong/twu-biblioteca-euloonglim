package com.twu.biblioteca;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BibliotecaApp {

    public ArrayList<Book> books = new ArrayList<>(Arrays.asList(
            new Book("Clean Code", "Robert C. Martin", 2008, false),
            new Book("Don't Make Me Think", "Steve Krug", 2000, false),
            new Book("Test Driven Development", "Kent Beck", 2000, false)));

    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        mainMenu.showWelcomeMessage();
        mainMenu.showOptions();
        bibliotecaApp.manageOptions();
    }

    public void manageOptions() {
        MainMenu mainMenu = new MainMenu();
        Scanner optionsScanner = new Scanner(System.in);
        //boolean active = true;
       while (true) {
            if(optionsScanner.hasNext()) {
                String userInput = optionsScanner.next();
                String cleanUserInput = userInput.trim();
                switch (cleanUserInput) {
                    case "1":
                        checkForAvailableBooks();
                        mainMenu.displayAvailableBooks();
                        mainMenu.showOptions();
                        break;
                    case "2":
                        checkForAvailableBooks();
                        mainMenu.displayAvailableBooks();
                        checkOutBook();
                        mainMenu.showOptions();
                        manageOptions();
                        break;
                    case "3":
                        mainMenu.showGoodbyeMessage();
                        //active= false;
                        System.exit(0); //To do: update this to a variable instead
                    default:
                        mainMenu.showInvalidMessage();
                        break;
                }
            }
            else {
                break;
            }
       }
    }
    public void checkOutBook() {
        MainMenu mainMenu = new MainMenu();
        if (books.size() == countCheckedOutBooks()) {
            mainMenu.showNoBooksMessage();
        } else {
            mainMenu.showBookCheckOutReferenceMessage();
            Scanner bookScanner = new Scanner(System.in);
            String userInput = bookScanner.next();
            int index = Integer.parseInt(userInput) - 1;
            Book book = books.get(index);
            book.setCheckedOut();
            System.out.println(book.isCheckedOut()); // prints out to "true" so the setter works
        }
    }

    public int countCheckedOutBooks() { //To do: update to iterator
        int count = 0;
        for (Book book : books){
            if (book.isCheckedOut()) count++;
        }
        return count;
    }

    public void checkForAvailableBooks() {
        MainMenu mainMenu = new MainMenu();
        if (books.size() == countCheckedOutBooks()) {
            mainMenu.showNoBooksMessage();
            mainMenu.showOptions();
            manageOptions();
        }
    }
}
