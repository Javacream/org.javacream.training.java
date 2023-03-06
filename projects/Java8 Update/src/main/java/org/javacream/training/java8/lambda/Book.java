package org.javacream.training.java8.lambda;

import java.util.Objects;

public class Book {
    private String isbn;
    private String title;
    private Double price;
    private Integer pages;

    public Book(String isbn, String title, Double price, Integer pages) {
        this.isbn = isbn;
        this.title = title;
        this.price = price;
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", pages=" + pages +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn) && Objects.equals(title, book.title) && Objects.equals(price, book.price) && Objects.equals(pages, book.pages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, title, price, pages);
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }
}
