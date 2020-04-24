package com.twu.biblioteca;

public class Movie implements Item {
    private final String title;
    private final String director;
    private final int year;
    private final String movieRating;
    private boolean checkedOut;

    public Movie(String title, String director, int year, String movieRating, boolean checkedOut) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.movieRating = movieRating;
        this.checkedOut = checkedOut;
    }

    public String toString() {
        return title + " (" + year + ")" + " | " + "Director: " + director + " | " + "Movie Rating: " + movieRating;
    }

    @Override
    public boolean isCheckedOut() {
        return checkedOut;
    }

    @Override
    public void setCheckedOut() {
        this.checkedOut = true;
    }
}
