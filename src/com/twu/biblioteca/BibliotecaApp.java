package com.twu.biblioteca;


public class BibliotecaApp {

    private static MainMenu mainMenu = new MainMenu();

    public static void main(String[] args) {
        mainMenu.showWelcomeMessage();
        mainMenu.showOptions();
        manageOptions();
    }

    public static void manageOptions() {
        boolean active = true;
       while (active == true) {
               switch (mainMenu.cleanUserInput()) {
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
    }
}
