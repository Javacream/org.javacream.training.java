package org.javacream.training.java8.optional;

import java.util.Optional;

public class Book {
    private String isbn;
    private Optional<String> title;

    public Book(String isbn, Optional<String> title) {
        this.isbn = isbn;
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Optional<String> getTitle() {
        return title;
    }

    public void setTitle(Optional<String> title) {
        this.title = title;
    }
}
