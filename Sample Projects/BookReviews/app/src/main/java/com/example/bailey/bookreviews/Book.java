package com.example.bailey.bookreviews;
/**
 * Created by baile on 11/15/2017.
 */

public class Book {
    private int id;
    private String title;
    private String author;
    private int rating;



    public Book(){}

    public Book(String title, String author, int rating) { super();
        this.title = title;
        this.author = author;
        this.rating = rating;
    }
    //getters & setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;

    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {

        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override

    public String toString() {

        return "Book [id=" + id + ", title=" + title + ", author="
                + author + " , rating=" + rating +"]";
    }
}
