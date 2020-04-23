package com.twu.biblioteca;


import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        MainMenuImplementation mainMenuImplementation = new MainMenuImplementation();
        BibliotecaApp bibliotecaApp = new BibliotecaApp();

        mainMenuImplementation.showWelcomeMessage();
        mainMenuImplementation.showOptions();
        bibliotecaApp.manageOptions(mainMenuImplementation);
    }

    public void manageOptions(MainMenu mainMenu) {
        Scanner optionsScanner = new Scanner(System.in);
       boolean active = true;
       while (active) {
            if (optionsScanner.hasNext()) {
                String userInput = optionsScanner.next();
                active = switchOptions(mainMenu, userInput);
            }
        }
    }

    public boolean switchOptions(MainMenu mainMenu, String userInput) {
        boolean active = true;
        switch (userInput.trim()) {
          case "1":
              mainMenu.displayAvailableBooks();
               mainMenu.showOptions();
                break;
            case "2":
                mainMenu.displayAvailableBooksToCheckOut();
                mainMenu.showOptions();
                break;
            case "3":
                mainMenu.displayAvailableMovies();
                mainMenu.showOptions();
                break;
            case "4":
                mainMenu.showGoodbyeMessage();
               active = false;
                break;
            default:
               mainMenu.showInvalidMessage();
                break;
        }
        return active;
    }
}
