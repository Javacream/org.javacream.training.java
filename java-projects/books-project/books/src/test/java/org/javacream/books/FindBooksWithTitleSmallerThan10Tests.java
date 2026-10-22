package org.javacream.books;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = TestConfiguration.class)
@ActiveProfiles("test")
public class FindBooksWithTitleSmallerThan10Tests {
    @Autowired
    private BookController controller;

    @Autowired
    private BookRepository repository;

    @BeforeEach
    void resetBooks() {
        repository.deleteAll();
    }

	@Test
	public void shortAndExactlyTenCharacterTitlesAreFound() {
		var shortIsbn = "TEST-ISBN-1";
		repository.save(new Book(shortIsbn, "Short", 19.99, 100, Boolean.FALSE));
		var boundaryIsbn = "TEST-ISBN-2";
		repository.save(new Book(boundaryIsbn, "1234567890", 19.99, 100, Boolean.FALSE));
		repository.save(new Book("TEST-ISBN-3", "12345678901", 19.99, 100, Boolean.FALSE));
		var result = controller.findBooksWithTitleSmallerThan10();
		Assertions.assertEquals(2, result.size());
		Assertions.assertTrue(result.stream().anyMatch(book -> book.isbn().equals(shortIsbn)));
		Assertions.assertTrue(result.stream().anyMatch(book -> book.isbn().equals(boundaryIsbn)));
	}

	@Test
	public void noMatchingTitlesReturnsEmptyList() {
		repository.save(new Book("TEST-ISBN-4", "12345678901", 19.99, 100, Boolean.FALSE));
		Assertions.assertTrue(controller.findBooksWithTitleSmallerThan10().isEmpty());
	}

}
