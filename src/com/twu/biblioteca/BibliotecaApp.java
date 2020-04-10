package com.twu.biblioteca;


public class BibliotecaApp {

    public static void main(String[] args) {

        MainMenu mainMenu = new MainMenu();
        mainMenu.showWelcomeMessage();
        mainMenu.showOptions();
        mainMenu.manageOptions();
    }
}
