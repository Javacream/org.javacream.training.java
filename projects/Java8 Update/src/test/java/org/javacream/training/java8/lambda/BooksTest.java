package org.javacream.training.java8.lambda;

import org.junit.jupiter.api.Test;

public class BooksTest {

    //@Test
    public void testBooksService(){
        BooksService booksService = new BooksService(new SimpleCounterIsbnGenerator());
        booksService.add("spring", 19.99, 250);
        booksService.add("TypeScript", 49.99, 250);
        booksService.add("Angular", 19.99, 250);
        System.out.println(booksService.findAll());
        System.out.println(booksService.findAllIsbns());
        System.out.println(booksService.findByTitle("final"));
        System.out.println(booksService.findByPriceRange(10, 30));
        System.out.println(booksService.findAllGroupByPages());

    }
    //@Test
    public void testBooksServiceWithSupplier(){
        BooksServiceWithFinderFunctions booksService = new BooksServiceWithFinderFunctions(new SimpleCounterIsbnGenerator());
        booksService.addBookFunction.addBook("spring", 19.99, 250);
        booksService.addBookFunction.addBook("TypeScript", 49.99, 250);
        booksService.addBookFunction.addBook("Angular", 19.99, 250);
        System.out.println(booksService.findAllSupplier.get());
    }


    @Test public void testBooksServiceWithFunctionalIsbnGenerator() {
        class Counter{
            private int counter = 0;
            public int inc(){
                return ++counter;
            }
        }
        Counter counter = new Counter();
        BooksService booksService = new BooksService(() -> "FunctionalIsbn:" + counter.inc());
        booksService.add("spring", 19.99, 250);
        booksService.add("TypeScript", 49.99, 250);
        booksService.add("Angular", 19.99, 250);
        System.out.println(booksService.findAllGroupByPages());
    }
}
class SimpleCounterIsbnGenerator implements IsbnGenerator{
    private int counter = 0;

    @Override
    public String next() {
        return "ISBN:" + ++counter;
    }
}
