package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MainMenuTest {

    @Test
    public void shouldDisplayWelcomeMessage() {
        MainMenu mainMenu = new MainMenu();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        mainMenu.welcome();

        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!" + System.getProperty("line.separator"), output.toString());
    }

    @Test
    public void shouldDisplayMainMenu() {
        MainMenu mainMenu = new MainMenu();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        mainMenu.showOptions();

        assertEquals("Please select an option from the following:\n" +
                "1. List of books\n" + ">" , output.toString());
    }

   @Test
    public void shouldDisplayBookListAfterSelectingOption() {
        MainMenu mainMenu = new MainMenu();
        System.setIn(new ByteArrayInputStream("1".getBytes()));

        mainMenu.manageOptions();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        mainMenu.showList();

        assertEquals("1. Clean Code | Robert C. Martin | 2008\n" +
                "2. Don't Make Me Think | Steve Krug | 2000\n" +
                "3. Test Driven Development | Kent Beck | 2000\n" +
                System.getProperty("line.separator"), output.toString());
    }

    @Test
    public void shouldDisplayInvalidMessageWhenInvalidOptionSelected() {
        MainMenu mainMenu = new MainMenu();

        System.setIn(new ByteArrayInputStream(("a" + System.getProperty("line.separator") + "1").getBytes()));

        mainMenu.showOptions();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        mainMenu.manageOptions();

        assertEquals("Please select a valid option!" +
                System.getProperty("line.separator") +
                        "1. Clean Code | Robert C. Martin | 2008\n" +
                        "2. Don't Make Me Think | Steve Krug | 2000\n" +
                        "3. Test Driven Development | Kent Beck | 2000\n" +
                        System.getProperty("line.separator"),
                output.toString());
    }
}
