package org.javacream;

import org.javacream.books.warehouse.api.Book;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;

@SpringBootApplication //das heißt: es wird ein Spring Application Context genutzt
public class BooksApplication {

    @Bean public HashMap<String, Book> booksData(){
        HashMap<String, Book> books = new HashMap<String, Book>();
        Book book = new Book();
        book.setIsbn("Isbn1");
        books.put(book.getIsbn(), book);
        return books;
    }
}
