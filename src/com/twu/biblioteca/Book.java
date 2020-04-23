package com.twu.biblioteca;

public class Book implements Item {
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

   @Override
   public boolean isCheckedOut() {
        return checkedOut;
   }

   @Override
   public void setCheckedOut() {
        this.checkedOut = true;
   }

   public String toString() {
        return title + " | " + author + " | " + yearPublished;
   }
}
