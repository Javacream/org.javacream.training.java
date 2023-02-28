package org.javacream.books.warehouse.test;

import org.javacream.ApplicationContext;
import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IsbnGeneratorNextTest {

    @Test public void isbnGeneratorCreatesAnIsbn(){
        IsbnGenerator isbnGenerator = ApplicationContext.getIsbnGenerator();
        String isbn = isbnGenerator.next();
        Assertions.assertNotNull(isbn);
    }
    @Test public void isbnGeneratorCreatesUniqueIsbns(){
        IsbnGenerator isbnGenerator = ApplicationContext.getIsbnGenerator();
        String isbn1 = isbnGenerator.next();
        String isbn2 = isbnGenerator.next();
        Assertions.assertNotEquals(isbn1, isbn2);
    }
}
