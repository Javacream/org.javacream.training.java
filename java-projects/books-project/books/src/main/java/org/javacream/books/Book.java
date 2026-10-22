package org.javacream.books;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class Book {
    @Id
    private String isbn;
    private String title;
    private Double price;
    private Integer pages;
    private Boolean available;

    protected Book() { } // JPA

    public Book(String isbn, String title, Double price, Integer pages, Boolean available) {
        this.isbn = isbn;
        this.title = title;
        this.price = price;
        this.pages = pages;
        this.available = available;
    }

    public String isbn() { return isbn; }
    public String title() { return title; }
    public Double price() { return price; }
    public Integer pages() { return pages; }
    public Boolean available() { return available; }

    public void setTitle(String title) { this.title = title; }
    public void setPrice(Double price) { this.price = price; }
    public void setPages(Integer pages) { this.pages = pages; }
    public void setAvailable(Boolean available) { this.available = available; }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Book book)) return false;
        return Objects.equals(isbn, book.isbn) && Objects.equals(title, book.title)
            && Objects.equals(price, book.price) && Objects.equals(pages, book.pages)
            && Objects.equals(available, book.available);
    }

    @Override
    public int hashCode() { return Objects.hash(isbn, title, price, pages, available); }
}
