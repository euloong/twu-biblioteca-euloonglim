package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MainMenuTest {

    @Test
    public void shouldDisplayMainMenu() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        MainMenu.showOptions();

        assertEquals("Please select an option from the following:\n" +
                "1. List of books\n" + ">" , output.toString());
    }

   @Test
    public void shouldDisplayBookListAfterSelectingOption() {
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        MainMenu.manageOptions();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Book.showList();

        assertEquals("1. Clean Code | Robert C. Martin | 2008\n" +
                "2. Don't Make Me Think | Steve Krug | 2000\n" +
                "3. Test Driven Development | Kent Beck | 2000\n" +
                System.getProperty("line.separator"), output.toString());
    }
}
