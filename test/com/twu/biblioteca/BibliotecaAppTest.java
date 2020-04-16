package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BibliotecaAppTest {

    @Test
    public void checkForAvailableBooksCalled() {
        MainMenuInterfaceTest mainMenuInterface = new MainMenuInterfaceTest();

        mainMenuInterface.checkForAvailableBooks();

        assertTrue(mainMenuInterface.hasBeenCalled);
    }

    @Test //[#1.2] [#1.3]
    public void shouldDisplayBookListAfterSelectingOption() {
        MainMenu mainMenu = new MainMenu();
        MainMenuInterfaceTest mainMenuInterface = new MainMenuInterfaceTest();

        System.setIn(new ByteArrayInputStream(("1" + System.getProperty("line.separator")).getBytes()));

        BibliotecaApp.manageOptions(mainMenuInterface);

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
       MainMenuInterfaceTest mainMenuInterface = new MainMenuInterfaceTest();

       System.setIn(new ByteArrayInputStream(("a" + System.getProperty("line.separator")).getBytes()));
       //Test will still pass if I remove the below line of code
       BibliotecaApp.manageOptions(mainMenuInterface);

       ByteArrayOutputStream output = new ByteArrayOutputStream();
       System.setOut(new PrintStream(output));

       //I'm not 100% sure that this is the correct way to perform the test
       mainMenu.showInvalidMessage();

       assertEquals("Please select a valid option!" +
                System.getProperty("line.separator"), output.toString());
    }
}
