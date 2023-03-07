package org.javacream.training.java8.default_methods;

import org.javacream.training.java8.lambda.Book;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface BooksServiceIF {
    List<Book> findAll();

    default public List<String> findAllIsbns(){
        return findAll().stream().map((b) -> b.getIsbn()).collect(Collectors.toList());
    }
    default public List<Book> findByTitle(String title){
        return findAll().stream().filter((b) -> b.getTitle().contains(title)).collect(Collectors.toList());
    }
    default public List<Book> findByPriceRange(double min, double max){
        return findAll().stream().filter((b) -> b.getPrice() > min && b.getPrice() < max).collect(Collectors.toList());
    }
    default public Map<Integer, List<Book>> findAllGroupByPages(){
        return findAll().stream().collect((Collectors.groupingBy(Book::getPages)));
    }

    default String info(){
        //DB-Zugriff, Web Service, andere Methoden anderer Klassen aufrufen
        return "INFO";

    }
}
