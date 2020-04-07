package com.twu.biblioteca;


import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class WelcomeTest {

    @Test
    public void shouldWriteWelcomeMessage() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(output);
        System.setOut(ps);

        String result = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        WelcomeMessage.welcome();

        assertEquals(result + System.getProperty("line.separator"), output.toString());
    }
}

