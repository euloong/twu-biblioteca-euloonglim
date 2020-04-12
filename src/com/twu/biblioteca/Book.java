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
        this.checkedOut = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
     return author;
   }

   public int getYearPublished() {
      return yearPublished;
   }

   public boolean getCheckedOut() {
        return checkedOut;
   }

   public void setCheckedOut() {
        this.checkedOut = true;
   }
}
