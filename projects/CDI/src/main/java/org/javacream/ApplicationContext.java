package org.javacream;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.impl.RandomIsbnGenerator;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.impl.MapBooksService;
import org.javacream.store.api.StoreService;
import org.javacream.store.impl.SimpleStoreService;

public abstract class ApplicationContext {
    private static IsbnGenerator isbnGenerator;
    private static StoreService storeService;

    public static IsbnGenerator getIsbnGenerator() {
        return isbnGenerator;
    }

    public static StoreService getStoreService() {
        return storeService;
    }

    public static BooksService getBooksService() {
        return booksService;
    }

    private static BooksService booksService;

    static {
        RandomIsbnGenerator rig = new RandomIsbnGenerator();
        rig.setCountryCode("-de");
        rig.setPrefix("ISBN:");
        SimpleStoreService sss = new SimpleStoreService();
        sss.setStock(42);
        MapBooksService mapBooksService = new MapBooksService();
        mapBooksService.setIsbnGenerator(rig);
        mapBooksService.setStoreService(sss);
        isbnGenerator = rig;
        storeService = sss;
        booksService = mapBooksService;
    }
}
