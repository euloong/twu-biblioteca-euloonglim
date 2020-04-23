package com.twu.biblioteca;

public interface MainMenu {
    //[#1.2 & #1.3]
    void displayAvailableBooks();
    //[#1.5]
    void showInvalidMessage();
    //[#1.6]
    void showGoodbyeMessage();

    void showOptions();
    void displayAvailableBooksToCheckOut();

    //[#2.1]
    void displayAvailableMovies();

}
