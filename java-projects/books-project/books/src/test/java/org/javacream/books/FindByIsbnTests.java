package org.javacream.books;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class FindByIsbnTests {
	@Autowired private BookController bookController;
	@Test
	public void validIsbnFindsBook() {
		var searchIsbn = "TEST-ISBN";
		var expectedBook = new Book(searchIsbn, "Title", 19.99, 100, Boolean.FALSE);
		//var bookController = new BookController();
		bookController.books.put(searchIsbn, expectedBook);
		var searchedBook = bookController.findByIsbn(searchIsbn);
		Assertions.assertEquals(expectedBook, searchedBook);
	}

	@Test
	public void invalidIsbnFindsNoBook() {
		var searchIsbn = "INVALID-ISBN";
		//var bookController = new BookController();
		var searchedBook = bookController.findByIsbn(searchIsbn);
		Assertions.assertNull(searchedBook);
	}

}
