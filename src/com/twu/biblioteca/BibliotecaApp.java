package com.twu.biblioteca;


import java.util.Scanner;

public class BibliotecaApp {

    private static MainMenu mainMenu = new MainMenu();

    public static void main(String[] args) {
        mainMenu.showWelcomeMessage();
        mainMenu.showOptions();
        manageOptions(mainMenu);
    }

    public static void manageOptions(MainMenuInterface mainMenuInterface) {
        Scanner optionsScanner = new Scanner(System.in);
        boolean active = true;
        while (active) {
            if (optionsScanner.hasNext()) {
                String userInput = optionsScanner.next();
                switch (userInput.trim()) {
                    case "1":
                        mainMenuInterface.displayAvailableBooks();
                        mainMenuInterface.showOptions();
                        break;
                    case "2":
                        mainMenuInterface.displayAvailableBooksToCheckOut();
                        mainMenuInterface.showOptions();
                        break;
                    case "3":
                        mainMenuInterface.showGoodbyeMessage();
                        active = false;
                        break;
                    default:
                        mainMenuInterface.showInvalidMessage();
                        break;
                }
            }
            else {
                //Allows test to stop the loop
                break;
            }
        }
    }
}
