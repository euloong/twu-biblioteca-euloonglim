package com.twu.biblioteca;

public class DummyMainMenu implements MainMenu {

    protected boolean displayAvailableBooksHasBeenCalled = false;
    protected boolean showInvalidMessageHasBeenCalled = false;
    protected boolean showGoodbyeMessageHasBeenCalled = false;
    protected boolean showOptionsHasBeenCalled  = false;
    protected boolean displayAvailableBooksToCheckOutHasBeenCalled   = false;

    //[#1.2 & #1.3]
    @Override
    public void displayAvailableBooks() {
        displayAvailableBooksHasBeenCalled = true;
    }

    //[#1.5]
    @Override
    public void showInvalidMessage() {
        showInvalidMessageHasBeenCalled = true;
    }

    //[#1.6]
    @Override
    public void showGoodbyeMessage() {
        showGoodbyeMessageHasBeenCalled = true;
    }

    @Override
    public void showOptions() {
        showOptionsHasBeenCalled = true;
    }

    @Override
    public void displayAvailableBooksToCheckOut() {
        displayAvailableBooksToCheckOutHasBeenCalled = true;
    }
}