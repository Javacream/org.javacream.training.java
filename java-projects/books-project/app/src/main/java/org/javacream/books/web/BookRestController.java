
package org.javacream.books.web;

import java.util.List;

import org.javacream.books.Book;
import org.javacream.books.BookController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookRestController {

    @Autowired
    private BookController controller;

    @PostMapping("/{title}")
    public String createBook(@PathVariable String title) {
        return controller.createBook(title);
    }

    @GetMapping("/isbn/{isbn}")
    public Book findByIsbn(@PathVariable String isbn) {
        return controller.findByIsbn(isbn);
    }

    @GetMapping
    public List<Book> findAll() {
        return controller.findAll();
    }

    @GetMapping("/title/{title}")
    public List<Book> findByTitle(@PathVariable String title) {
        return controller.findByTitle(title);
    }

    @GetMapping("/title/{title}/isbns")
    public List<String> findIsbnsForTitle(
            @PathVariable String title) {
        return controller.findIsbnsForTitle(title);
    }

    @GetMapping("/short-titles")
    public List<Book> findBooksWithTitleSmallerThan10() {
        return controller.findBooksWithTitleSmallerThan10();
    }

    @PutMapping("/{isbn}/title/{newTitle}")
    public Boolean updateTitle(
            @PathVariable String isbn,
            @PathVariable String newTitle) {
        return controller.updateTitle(isbn, newTitle);
    }

    @PutMapping("/{isbn}/price/{newPrice}")
    public Boolean updatePrice(
            @PathVariable String isbn,
            @PathVariable Double newPrice) {
        return controller.updatePrice(isbn, newPrice);
    }

    @PutMapping("/{isbn}/pages/{newPages}")
    public Boolean updatePages(
            @PathVariable String isbn,
            @PathVariable Integer newPages) {
        return controller.updatePages(isbn, newPages);
    }

    @PutMapping("/{isbn}/availability/{newAvailability}")
    public Boolean updateAvailability(
            @PathVariable String isbn,
            @PathVariable Boolean newAvailability) {
        return controller.updateAvailability(isbn, newAvailability);
    }

    @DeleteMapping("/{isbn}")
    public Boolean deleteByIsbn(@PathVariable String isbn) {
        return controller.deleteByIsbn(isbn);
    }
}
