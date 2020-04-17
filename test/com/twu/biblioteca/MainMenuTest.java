package com.twu.biblioteca;

import org.junit.Test;

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
                "1. List books\n" +
                "2. Checkout a book\n" +
                "3. Quit\n" +
                ">" , output.toString());
    }
}
