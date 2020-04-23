package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BibliotecaAppTest {

    BibliotecaApp bibliotecaApp = new BibliotecaApp();
    DummyMainMenu dummyMainMenu = new DummyMainMenu();

    @Test //[#1.2 & #1.3]
    public void displayAvailableBooksCalled() {

        bibliotecaApp.switchOptions(dummyMainMenu, "1");

        assertTrue(dummyMainMenu.displayAvailableBooksHasBeenCalled);
    }

    @Test //[#1.5]
    public void showInvalidMessageCalled() {
        String userInput = "a";

        bibliotecaApp.switchOptions(dummyMainMenu, userInput);

        assertTrue(dummyMainMenu.showInvalidMessageHasBeenCalled);
    }

    @Test //[#1.6]
    public void showGoodbyeMessageCalled() {
        String userInput = "4";

        bibliotecaApp.switchOptions(dummyMainMenu, userInput);

        assertTrue(dummyMainMenu.showGoodbyeMessageHasBeenCalled);
    }

    @Test //Additional test
    public void displayAvailableBooksToCheckOutCalled() {
        String userInput = "2";

        bibliotecaApp.switchOptions(dummyMainMenu, userInput);

        assertTrue(dummyMainMenu.displayAvailableBooksToCheckOutHasBeenCalled);
    }

    @Test //Additional test
    public void showOptionsCalled() {
        String userInput = "1";

        bibliotecaApp.switchOptions(dummyMainMenu, userInput);

        assertTrue(dummyMainMenu.showOptionsHasBeenCalled);
    }

    @Test //[#2.1]
    public void displayAvailableMoviesCalled() {
        String userInput = "3";

        bibliotecaApp.switchOptions(dummyMainMenu, userInput);

        assertTrue(dummyMainMenu.displayAvailableMoviesHasBeenCalled);
    }
}
