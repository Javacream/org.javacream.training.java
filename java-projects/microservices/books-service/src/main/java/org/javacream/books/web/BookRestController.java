package org.javacream.books.web;
import java.util.List;
import org.javacream.books.Book;
import org.javacream.books.BookController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/books")
public class BookRestController {
 @Autowired private BookController controller;
 @PostMapping public Book save(@RequestBody Book book){return controller.save(book);}
 @GetMapping public List<Book> findAll(){return controller.findAll();}
 @GetMapping("/{isbn}") public Book findByIsbn(@PathVariable String isbn){return controller.findByIsbn(isbn);}
 @PutMapping("/{isbn}/availability/{available}") public Boolean updateAvailability(@PathVariable String isbn,@PathVariable Boolean available){return controller.updateAvailability(isbn,available);}
 @DeleteMapping("/{isbn}") public Boolean deleteByIsbn(@PathVariable String isbn){return controller.deleteByIsbn(isbn);}
}
