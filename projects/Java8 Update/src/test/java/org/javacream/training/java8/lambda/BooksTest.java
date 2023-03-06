package org.javacream.training.java8.lambda;

import org.junit.jupiter.api.Test;

public class BooksTest {

    @Test public void testBooksService(){
        BooksService booksService = new BooksService();
        System.out.println(booksService.findAll());
        System.out.println(booksService.findAllIsbns());
        System.out.println(booksService.findByTitle("final"));
        System.out.println(booksService.findByPriceRange(10, 30));
        System.out.println(booksService.findAllGroupByPages());

    }
}
