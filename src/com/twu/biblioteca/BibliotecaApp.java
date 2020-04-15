package com.twu.biblioteca;


import java.util.Scanner;

public class BibliotecaApp {

    private static MainMenu mainMenu = new MainMenu();

    public static void main(String[] args) {
        mainMenu.showWelcomeMessage();
        mainMenu.showOptions();
        manageOptions();
    }

    public static void manageOptions() {
        Scanner optionsScanner = new Scanner(System.in);
        boolean active = true;
       while (active) {
           if (optionsScanner.hasNext()) {
               String userInput = optionsScanner.next();
               switch (userInput.trim()) {
                   case "1":
                       mainMenu.checkForAvailableBooks();
                       mainMenu.displayAvailableBooks();
                       mainMenu.showOptions();
                       break;
                   case "2":
                       mainMenu.checkForAvailableBooks();
                       mainMenu.displayAvailableBooks();
                       mainMenu.checkOutBook();
                       mainMenu.showOptions();
                       break;
                   case "3":
                       mainMenu.showGoodbyeMessage();
                       active = false;
                       break;
                   default:
                       mainMenu.showInvalidMessage();
                       break;
               }
           }
           else {
               break; //Allows test to stop
           }
       }
    }
}
