package org.javacream;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.impl.RandomIsbnGenerator;
import org.javacream.books.order.api.OrderService;
import org.javacream.books.order.impl.OrderServiceImpl;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.books.warehouse.impl.MapBooksService;
import org.javacream.store.api.StoreService;
import org.javacream.store.impl.SimpleStoreService;
import org.javacream.util.IdGenerator;

import java.util.HashMap;

public abstract class ApplicationContext {
    private static IsbnGenerator isbnGenerator;
    private static StoreService storeService;
    private static IdGenerator idGenerator;

    public static IdGenerator getIdGenerator() {
        return idGenerator;
    }

    public static OrderService getOrderService() {
        return orderService;
    }

    private static OrderService orderService;
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
        SimpleStoreService sss = new SimpleStoreService();
        MapBooksService mapBooksService = new MapBooksService();
        IdGenerator ig = new IdGenerator();
        OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
        HashMap<String, Book> books = new HashMap<String, Book>();
        isbnGenerator = rig;
        storeService = sss;
        booksService = mapBooksService;
        idGenerator = ig;
        orderService = orderServiceImpl;
        rig.setCountryCode("-de");
        rig.setPrefix("ISBN:");
        rig.setIdGenerator(ig);
        sss.setStock(42);
        Book book = new Book();
        book.setIsbn("Isbn1");
        books.put(book.getIsbn(), book);
        mapBooksService.setIsbnGenerator(rig);
        mapBooksService.setStoreService(sss);
        mapBooksService.setBooks(books);
        orderServiceImpl.setBooksService(mapBooksService);
        orderServiceImpl.setStoreService(sss);
        orderServiceImpl.setIdGenerator(idGenerator);

    }
}
