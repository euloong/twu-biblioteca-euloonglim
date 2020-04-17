package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BibliotecaAppTest {

    @Test //[#1.2 & #1.3]
    public void displayAvailableBooksCalled() {
        DummyMainMenuInterface mainMenuInterface = new DummyMainMenuInterface();

        mainMenuInterface.displayAvailableBooks();

        assertTrue(mainMenuInterface.displayAvailableBooksHasBeenCalled);
    }

    @Test //[#1.5]
    public void showInvalidMessageCalled() {
        DummyMainMenuInterface mainMenuInterface = new DummyMainMenuInterface();

        mainMenuInterface.showInvalidMessage();

        assertTrue(mainMenuInterface.showInvalidMessageHasBeenCalled);
    }

    @Test //[#1.6]
    public void showGoodbyeMessageCalled() {
        DummyMainMenuInterface mainMenuInterface = new DummyMainMenuInterface();

        mainMenuInterface.showGoodbyeMessage();

        assertTrue(mainMenuInterface.showGoodbyeMessageHasBeenCalled);
    }

    @Test //[#1.7]
    public void checkOutBookCalled() {
        DummyMainMenuInterface mainMenuInterface = new DummyMainMenuInterface();

        mainMenuInterface.checkOutBook();

        assertTrue(mainMenuInterface.checkOutBookHasBeenCalled);
    }

    @Test //[#1.8]
    public void showSuccessfulCheckOutMessageCalled() {
        DummyMainMenuInterface mainMenuInterface = new DummyMainMenuInterface();

        mainMenuInterface.showSuccessfulCheckOutMessage();

        assertTrue(mainMenuInterface.showSuccessfulCheckOutMessageHasBeenCalled);
    }

    @Test //[#1.9]
    public void showUnsuccessfulCheckOutMessageCalled() {
        DummyMainMenuInterface mainMenuInterface = new DummyMainMenuInterface();

        mainMenuInterface.showUnsuccessfulCheckOutMessage();

        assertTrue(mainMenuInterface.showUnsuccessfulCheckOutMessageHasBeenCalled);
    }
}
