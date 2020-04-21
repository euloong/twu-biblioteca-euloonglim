package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BibliotecaAppTest {

    @Test //[#1.2 & #1.3]
    public void displayAvailableBooksCalled() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        DummyMainMenu dummyMainMenu = new DummyMainMenu();
        String userInput = "1";

        bibliotecaApp.switchOptions(dummyMainMenu, true, userInput);

        assertTrue(dummyMainMenu.displayAvailableBooksHasBeenCalled);
    }

    @Test //[#1.5]
    public void showInvalidMessageCalled() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        DummyMainMenu dummyMainMenu = new DummyMainMenu();
        String userInput = "a";

        bibliotecaApp.switchOptions(dummyMainMenu, true, userInput);

        assertTrue(dummyMainMenu.showInvalidMessageHasBeenCalled);
    }

    @Test //[#1.6]
    public void showGoodbyeMessageCalled() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        DummyMainMenu dummyMainMenu = new DummyMainMenu();
        String userInput = "3";

        bibliotecaApp.switchOptions(dummyMainMenu, true, userInput);

        assertTrue(dummyMainMenu.showGoodbyeMessageHasBeenCalled);
    }

    @Test //[#1.7]
    public void checkOutBookCalled() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        DummyMainMenu dummyMainMenu = new DummyMainMenu();
        String userInput = ("2" + System.getProperty("line.separator"));

        bibliotecaApp.switchOptions(dummyMainMenu, true, userInput);

        assertTrue(dummyMainMenu.checkOutBookHasBeenCalled);
    }

    @Test //[#1.8]
    public void showSuccessfulCheckOutMessageCalled() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        DummyMainMenu dummyMainMenu = new DummyMainMenu ();
        String userInput = ("2" + System.getProperty("line.separator") + "1" + System.getProperty("line.separator"));

        bibliotecaApp.switchOptions(dummyMainMenu, true, userInput);

        assertTrue(dummyMainMenu.showSuccessfulCheckOutMessageHasBeenCalled);
    }

    @Test //[#1.9]
    public void showUnsuccessfulCheckOutMessageCalled() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        DummyMainMenu  dummyMainMenu = new DummyMainMenu ();
        String userInput = ("2" + System.getProperty("line.separator") + "q" + System.getProperty("line.separator"));

        bibliotecaApp.switchOptions(dummyMainMenu, true, userInput);

        assertTrue(dummyMainMenu.showUnsuccessfulCheckOutMessageHasBeenCalled);
    }
}
