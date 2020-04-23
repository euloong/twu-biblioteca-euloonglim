package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MainMenuImplementationTest {
    MainMenuImplementation mainMenuImplementation = new MainMenuImplementation();

    @Test //[#1.1]
    public void shouldDisplayWelcomeMessage() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        mainMenuImplementation.showWelcomeMessage();

        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!" +
                System.getProperty("line.separator"), output.toString());
    }

    @Test //[#1.4]
    public void shouldDisplayMainMenu() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        mainMenuImplementation.showOptions();

        assertEquals("Please select an option from the following:\n" +
                "1. List books\n" +
                "2. Checkout a book\n" +
                "3. List movies\n" +
                "4. Checkout a movie\n" +
                "5. Quit\n" +
                ">" , output.toString());
    }

    @Test //[#1.7]
    public void shouldNotDisplayBookWhenCheckedOut() {
        System.setIn(new ByteArrayInputStream((
                "3" + System.getProperty("line.separator") +
                "1" + System.getProperty("line.separator")).getBytes()));

        mainMenuImplementation.checkOutBook();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        mainMenuImplementation.displayAvailableBooks();

        assertEquals("1. Clean Code | Robert C. Martin | 2008\n" +
                "2. Don't Make Me Think | Steve Krug | 2000\n", output.toString());
    }

    @Test //[#1.8]
    public void shouldDisplaySuccessfulMessageWhenBookIsCheckedOut() {
        System.setIn(new ByteArrayInputStream(("2").getBytes()));

        mainMenuImplementation.displayAvailableBooks();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        mainMenuImplementation.checkOutBook();

        assertEquals("Thank you! Enjoy the book" +
                System.getProperty("line.separator"), output.toString());
    }

    @Test //[#1.9]
    public void shouldDisplayUnsuccessfulMessageWhenBookIsNotAvailable() {
        System.setIn(new ByteArrayInputStream(("q").getBytes()));

        mainMenuImplementation.displayAvailableBooks();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        mainMenuImplementation.checkOutBook();

        assertEquals("Sorry, that book is not available" +
                System.getProperty("line.separator"), output.toString());
    }

    @Test //[#2.2]
    public void shouldNotDisplayMovieWhenCheckedOut() {
        System.setIn(new ByteArrayInputStream((
                "3" + System.getProperty("line.separator") +
                        "1" + System.getProperty("line.separator")).getBytes()));

        mainMenuImplementation.checkOutMovie();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        mainMenuImplementation.displayAvailableMovies();

        assertEquals("1. Star Wars: Episode IV - A New Hope (1977) | Director: George Lucas | Movie Rating: 9\n" +
                "2. Star Wars: Episode V - The Empire Strikes Back (1980) | Director: Irvin Kershner | Movie Rating: 10\n",
                output.toString());
    }
}
