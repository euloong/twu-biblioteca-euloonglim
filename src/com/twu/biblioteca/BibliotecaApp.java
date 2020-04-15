package com.twu.biblioteca;


public class BibliotecaApp {

    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        mainMenu.showWelcomeMessage();
        mainMenu.showOptions();
        bibliotecaApp.manageOptions();
    }

    public void manageOptions() {
        MainMenu mainMenu = new MainMenu();
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
                       manageOptions();
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
