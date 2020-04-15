package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MainMenuTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

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

   @Test //[#1.2] [#1.3]
    public void shouldDisplayBookListAfterSelectingOption() {
        MainMenu mainMenu = new MainMenu();
       BibliotecaApp bibliotecaApp = new BibliotecaApp();
        System.setIn(new ByteArrayInputStream(("1" + System.getProperty("line.separator")).getBytes()));

       bibliotecaApp.manageOptions();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        mainMenu.displayAvailableBooks();

        assertEquals("1. Clean Code | Robert C. Martin | 2008\n" +
                "2. Don't Make Me Think | Steve Krug | 2000\n" +
                "3. Test Driven Development | Kent Beck | 2000\n",
                output.toString());
    }

    @Test //[#1.5]
    public void shouldDisplayInvalidMessageWhenInvalidOptionSelected() {
        MainMenu mainMenu = new MainMenu();
        BibliotecaApp bibliotecaApp = new BibliotecaApp();

        System.setIn(new ByteArrayInputStream(("a" + System.getProperty("line.separator")).getBytes()));

        mainMenu.showOptions();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        bibliotecaApp.manageOptions();

        assertEquals("Please select a valid option!" +
                System.getProperty("line.separator"), output.toString());
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
                "1" + System.getProperty("line.separator") ).getBytes()));

        mainMenu.checkOutBook();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        mainMenu.displayAvailableBooks();

        assertEquals("1. Clean Code | Robert C. Martin | 2008\n" +
                "2. Don't Make Me Think | Steve Krug | 2000\n", output.toString());
    }
}
