package org.javacream.training.java8.optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.stream.Stream;

public class BookTest {

    @Test public void nullStillPossible(){
        Book b = new Book(null, null);
    }
    @Test public void nullAsOptionalIsWrong(){
        Book b = new Book("ISBN", null);
    }

    @Test public void newBookWithKnownTitle(){
        Book b = new Book("ISBN", Optional.of("Title"));
    }
    @Test public void newBookWithoutTitle(){
        Book b = new Book("ISBN", Optional.empty());
    }
    
    @Test public void useOptional(){
        Book b = new Book("ISBN", Optional.of("Title"));
        Optional<String> optionalTitle = b.getTitle();
        if (optionalTitle.isPresent()){
            String title = optionalTitle.get();
            //...
        }else{
            //title ist nicht gesetzt...
        }
        optionalTitle.ifPresent(s -> s.length());
        //Stream<String> stream = optionalTitle.stream();

    }
    
    
    
    
    
}
