package com.github.xenteros.model;

public class Book {

    private Long id;
    private String author;
    private String title;

    public Book() {
    }

    public Book(Long id, String author, String title) {
        this.id = id;
        this.author = author;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }
}
