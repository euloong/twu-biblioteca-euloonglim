package com.twu.biblioteca;

public class Book {
    private final String title;
    private final String author;
    private final int yearPublished;
    private boolean checkedOut;

    public Book(String title, String author, int yearPublished, boolean checkedOut) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.checkedOut = checkedOut;
    }

   public boolean isCheckedOut() {
        return checkedOut;
   }

   public void setCheckedOut() {
        this.checkedOut = true;
   }

   public String toString() {
        return title + " | " + author + " | " + yearPublished;
   }
}
