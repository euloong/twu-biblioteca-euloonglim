package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void shouldDisplayListOfBooks() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Book.showList();

        assertEquals("1. Clean Code\n" + "2. Don't Make Me Think\n" + "3. Test Driven Development\n" + System.getProperty("line.separator"), output.toString());
    }
}
