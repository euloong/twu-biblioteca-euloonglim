package com.twu.biblioteca;

public interface MainMenu {
    //[#1.2 & #1.3]
    void displayAvailableBooks();
    //[#1.5]
    void showInvalidMessage();
    //[#1.6]
    void showGoodbyeMessage();
    //[#1.7]
    void checkOutBook();
    //[#1.8]
    void showSuccessfulCheckOutMessage();
    //[#1.9]
    void showUnsuccessfulCheckOutMessage();

    void showOptions();
    void displayAvailableBooksToCheckOut();

}
