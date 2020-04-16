package com.twu.biblioteca;

public class MainMenuInterfaceTest implements MainMenuInterface {
    protected boolean hasBeenCalled = false;

    @Override
    public void checkForAvailableBooks() {
        hasBeenCalled = true;
    }

    @Override
    public void displayAvailableBooks() {
        hasBeenCalled = true;
    }

    @Override
    public void showOptions() {
        hasBeenCalled = true;
    }

    @Override
    public void checkOutAvailableBook() {
        hasBeenCalled = true;
    }

    @Override
    public void checkOutBook() {
        hasBeenCalled = true;
    }

    @Override
    public void showGoodbyeMessage() {
        hasBeenCalled = true;
    }

    @Override
    public void showInvalidMessage() {
        hasBeenCalled = true;
    }
}
