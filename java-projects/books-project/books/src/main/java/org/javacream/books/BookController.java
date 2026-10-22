package org.javacream.books;

import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookController {
    private final BookRepository repository;
    private static final Double DEFAULT_PRICE = 19.99;
    private static final Integer DEFAULT_PAGES = 0;
    private static final Boolean DEFAULT_AVAILABILITY = Boolean.FALSE;

    public BookController(BookRepository repository) { this.repository = repository; }

    public String createBook(String title) {
        String isbn = "ISBN:" + UUID.randomUUID();
        repository.save(new Book(isbn, title, DEFAULT_PRICE, DEFAULT_PAGES, DEFAULT_AVAILABILITY));
        return isbn;
    }

    public Book findByIsbn(String isbn) { return repository.findById(isbn).orElse(null); }

    public List<Book> findAll() { return repository.findAll(); }

    public List<Book> findByTitle(String title) { return repository.findByTitleContaining(title); }

    public List<String> findIsbnsForTitle(String title) {
        return repository.findByTitleContaining(title).stream().map(Book::isbn).toList();
    }

    public List<Book> findBooksWithTitleSmallerThan10() {
        return repository.findAll().stream().filter(b -> b.title().length() <= 10).toList();
    }

    @Transactional
    protected Boolean update(String isbn, Consumer<Book> change) {
        var book = repository.findById(isbn);
        if (book.isEmpty()) return Boolean.FALSE;
        change.accept(book.get());
        repository.save(book.get());
        return Boolean.TRUE;
    }

    public Boolean updateTitle(String isbn, String newTitle) {
        return update(isbn, b -> b.setTitle(newTitle));
    }

    public Boolean updatePrice(String isbn, Double newPrice) {
        return update(isbn, b -> b.setPrice(newPrice));
    }

    public Boolean updatePages(String isbn, Integer newPages) {
        return update(isbn, b -> b.setPages(newPages));
    }

    public Boolean updateAvailability(String isbn, Boolean newAvailability) {
        return update(isbn, b -> b.setAvailable(newAvailability));
    }

    public Boolean deleteByIsbn(String isbn) {
        if (!repository.existsById(isbn)) return Boolean.FALSE;
        repository.deleteById(isbn);
        return Boolean.TRUE;
    }
}
