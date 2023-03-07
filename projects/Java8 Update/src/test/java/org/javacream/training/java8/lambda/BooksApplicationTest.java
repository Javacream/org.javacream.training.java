package org.javacream.training.java8.lambda;

public class BooksApplicationTest {

    public void test(){
        BooksApplication booksApplication = new BooksApplication();
        BooksServiceWithFinderFunctions booksServiceWithFinderFunctions = new BooksServiceWithFinderFunctions(() -> "ISBN");
        booksApplication.workWithBookListSupplier(booksServiceWithFinderFunctions.findAllSupplier);
        booksApplication.workWithBookListSupplier(booksServiceWithFinderFunctions::findAll);
        SomethingNew sn = booksServiceWithFinderFunctions::findAll;
    }
}
