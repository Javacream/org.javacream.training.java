package org.javacream.training.java8.lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class BooksServiceWithFinderFunctions {
    private IsbnGenerator isbngenerator = null;
    private int counter = 0;
    private Map<String, Book> books;

    public BooksServiceWithFinderFunctions(IsbnGenerator isbngenerator){
        books = new HashMap<>();
        books.put("ISBN1", new Book ("ISBN1", "The final frontier", 19.99, 200));
        books.put("ISBN2", new Book ("ISBN2", "The final countdown", 29.99, 300));
        books.put("ISBN3", new Book ("ISBN3", "Java in action", 9.99, 200));
        books.put("ISBN4", new Book ("ISBN4", "Java: final classes", 0.99, 400));
        this.isbngenerator = isbngenerator;
    }
    public String add(String title, Double price, Integer pages){
        String isbn = isbngenerator.next();
        Book book = new Book(isbn, title, price, pages);
        books.put(isbn, book);
        return isbn;
    }
    public AddBookFunction addBookFunction = (title, price, pages) ->{
        String isbn = isbngenerator.next();
        Book book = new Book(isbn, title, price, pages);
        books.put(isbn, book);
        return isbn;
    };
    public AddBookFunction addBookFunctionFunction = this::add;
    public List<Book> findAll(){
        return new ArrayList<>(books.values());
    }
    //public Supplier<List<Book>> findAllSupplier = () ->  new ArrayList<>(books.values());
    public Supplier<List<Book>> findAllSupplier = () ->  this.findAll();
    public Supplier<List<Book>> findAllSupplierMethodReference = this::findAll;

    public List<String> findAllIsbns(){
        return findAll().stream().map((b) -> b.getIsbn()).collect(Collectors.toList());
    }
    public List<Book> findByTitle(String title){
        return findAll().stream().filter((b) -> b.getTitle().contains(title)).collect(Collectors.toList());
    }
    public List<Book> findByPriceRange(double min, double max){
        return findAll().stream().filter((b) -> b.getPrice() > min && b.getPrice() < max).collect(Collectors.toList());
    }
    public Map<Integer, List<Book>> findAllGroupByPages(){
        return findAll().stream().collect((Collectors.groupingBy(Book::getPages)));
    }

    @FunctionalInterface
    public interface AddBookFunction{
        String addBook(String title, Double price, Integer pages);
    }
}
