package org.javacream.training.java8.lambda;

import java.util.*;
import java.util.stream.Collectors;

public class BooksService {
    private int counter = 0;
    private Map<String, Book> books;

    {
        books = new HashMap<>();
        books.put("ISBN1", new Book ("ISBN1", "The final frontier", 19.99, 200));
        books.put("ISBN2", new Book ("ISBN2", "The final countdown", 29.99, 300));
        books.put("ISBN3", new Book ("ISBN3", "Java in action", 9.99, 200));
        books.put("ISBN4", new Book ("ISBN4", "Java: final classes", 0.99, 400));
    }
    public String add(String title, Double price, Integer pages){
        counter++;
        Book book = new Book("ISBN" + counter, title, price, pages);
        String isbn =book.getIsbn();
        books.put(isbn, book);
        return isbn;
    }

    public List<Book> findAll(){
        return new ArrayList<>(books.values());
    }

    public List<String> findAllIsbns(){
        return findAll().stream().map((b) -> b.getIsbn()).collect(Collectors.toList());
    }
    public List<Book> findByTitle(String title){
        return findAll().stream().filter((b) -> b.getTitle().contains(title)).collect(Collectors.toList());
    }
    public List<Book> findByPriceRange(double min, double max){
        return findAll().stream().filter((b) -> b.getPrice() > min && b.getPrice() < max).collect(Collectors.toList());
    }

}
