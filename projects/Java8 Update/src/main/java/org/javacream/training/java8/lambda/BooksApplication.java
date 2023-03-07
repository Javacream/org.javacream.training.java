package org.javacream.training.java8.lambda;

import java.util.List;
import java.util.function.Supplier;

public class BooksApplication {

    //books liegt komplett im Hauptspeicher der Anwdendung
    public void workWithBookList(List<Book> books){
        //...
    }

    //Diese Funktion kontrolliert, ob und wann die BookList geholt wird
    public void workWithBookListSupplier(Supplier<List<Book>> booksSupplier){
        booksSupplier.get();
    }


}
