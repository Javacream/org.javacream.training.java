package org.javacream.books;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class BookController {
 @Autowired private BookRepository repository;
 public Book save(Book book){return repository.save(book);}
 public Book findByIsbn(String isbn){return repository.findById(isbn).orElse(null);}
 public List<Book> findAll(){return repository.findAll();}
 public Boolean deleteByIsbn(String isbn){if(!repository.existsById(isbn))return false;repository.deleteById(isbn);return true;}
 @Transactional public Boolean updateAvailability(String isbn,Boolean available){return repository.findById(isbn).map(book->{book.setAvailable(available);repository.save(book);return true;}).orElse(false);}
}
