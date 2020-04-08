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
        Book book = new Book();
        book.showList();

        assertEquals("1. Clean Code | Robert C. Martin | 2008\n" + "2. Don't Make Me Think | Steve Krug | 2000\n" + "3. Test Driven Development | Kent Beck | 2000\n" + System.getProperty("line.separator"), output.toString());
    }
}
