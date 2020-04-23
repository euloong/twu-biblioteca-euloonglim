package com.twu.biblioteca;

public class Movie {
    private final String title;
    private final String director;
    private final int year;
    private final String movieRating;
    //private boolean checkedOut;

    public Movie(String title, String director, int year, String movieRating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.movieRating = movieRating;
       // this.checkedOut = checkedOut;
    }

   // public boolean isCheckedOut() {
       // return checkedOut;}

    //public void setCheckedOut() {
        //this.checkedOut = true;
    //}

    public String toString() {
        return title + " (" + year + ")" + " | " + "Director: " + director + " | " + "Movie Rating: " + movieRating;
    }
}
