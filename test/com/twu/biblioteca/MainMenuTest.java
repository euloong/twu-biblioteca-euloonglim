package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MainMenuTest {

    @Test //[#1.1]
    public void shouldDisplayWelcomeMessage() {
        MainMenu mainMenu = new MainMenu();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        mainMenu.showWelcomeMessage();

        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!" +
                System.getProperty("line.separator"), output.toString());
    }

    @Test //[#1.4]
    public void shouldDisplayMainMenu() {
        MainMenu mainMenu = new MainMenu();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        mainMenu.showOptions();

        assertEquals("Please select an option from the following:\n" +
                "1. List of books\n" +
                "2. Checkout a book\n" +
                "3. Quit\n" +
                ">" , output.toString());
    }

    @Test //[#1.6]
    public void shouldCloseApplicationWhenQuitOptionSelected() {
        MainMenu mainMenu = new MainMenu();

        System.setIn(new ByteArrayInputStream(("3").getBytes()));

        mainMenu.showOptions();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        mainMenu.showGoodbyeMessage();

        assertEquals("Goodbye!\n", output.toString());
    }

    @Test //[#1.7]
    public void shouldNotDisplayBookWhenCheckedOut() {
        MainMenu mainMenu = new MainMenu();

        System.setIn(new ByteArrayInputStream(("3" + System.getProperty("line.separator") +
                "1" + System.getProperty("line.separator")).getBytes()));

        mainMenu.checkOutBook();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        mainMenu.displayAvailableBooks();

        assertEquals("1. Clean Code | Robert C. Martin | 2008\n" +
                "2. Don't Make Me Think | Steve Krug | 2000\n", output.toString());
    }

    @Test //[#1.8]
    public void shouldDisplaySuccessfulMessageWhenBookIsCheckedOut() {
        MainMenu mainMenu = new MainMenu();

        System.setIn(new ByteArrayInputStream(("2").getBytes()));

        mainMenu.displayAvailableBooks();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        mainMenu.checkOutBook();

        assertEquals("Thank you! Enjoy the book" +
                System.getProperty("line.separator"), output.toString());
    }

    @Test //[#1.9]
    public void shouldDisplayUnsuccessfulMessageWhenBookIsNotAvailable() {
        MainMenu mainMenu = new MainMenu();

        System.setIn(new ByteArrayInputStream(("q").getBytes()));

        mainMenu.displayAvailableBooks();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        mainMenu.checkOutBook();

        assertEquals("Sorry, that book is not available" +
                System.getProperty("line.separator"), output.toString());
    }
}
