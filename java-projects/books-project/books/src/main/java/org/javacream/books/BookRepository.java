package org.javacream.books;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
    List<Book> findByTitleContaining(String title);
    // The length filter is handled by BookController for portability.
}
