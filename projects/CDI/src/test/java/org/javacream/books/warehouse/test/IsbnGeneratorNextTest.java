package org.javacream.books.warehouse.test;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IsbnGeneratorNextTest {
    @Autowired IsbnGenerator isbnGenerator;
    @Test public void isbnGeneratorCreatesAnIsbn(){
        String isbn = isbnGenerator.next();
        Assertions.assertNotNull(isbn);
    }
    @Test public void isbnGeneratorCreatesUniqueIsbns(){
        String isbn1 = isbnGenerator.next();
        String isbn2 = isbnGenerator.next();
        Assertions.assertNotEquals(isbn1, isbn2);
    }
}
