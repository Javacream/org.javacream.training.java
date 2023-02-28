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
        book.setTitle("Title1");
        books.put(book.getIsbn(), book);
        for (int i = 5; i < 10; i++){
            Book b = new Book();
            b.setIsbn("Isbn" + i);
            b.setTitle("Title_Cat1");
            books.put(b.getIsbn(), b);
            b = new Book();
            b.setIsbn("Isbn" + i*10);
            b.setTitle("Title_Cat2");
            books.put(b.getIsbn(), b);
        }
        return books;
    }
}
