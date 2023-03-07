package org.javacream.training.java8.lambda;

import java.util.List;
import java.util.function.Supplier;

public class BooksApplicationTest {

    public void test(){
        BooksApplication booksApplication = new BooksApplication();
        BooksServiceWithFinderFunctions booksServiceWithFinderFunctions = new BooksServiceWithFinderFunctions(() -> "ISBN");
        booksApplication.workWithBookListSupplier(booksServiceWithFinderFunctions.findAllSupplier);
        booksApplication.workWithBookListSupplier(booksServiceWithFinderFunctions::findAll);
        Supplier<List<Book>> supplier =booksServiceWithFinderFunctions::findAll;
        SomethingNew sn = booksServiceWithFinderFunctions::findAll;
        //sn = supplier;
    }
}
