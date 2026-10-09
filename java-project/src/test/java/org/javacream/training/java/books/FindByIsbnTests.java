package org.javacream.training.java.books;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindByIsbnTests {
	
	@Test
	public void validIsbnFindsBook() {
		var searchIsbn = "TEST-ISBN";
		var expectedBook = new Book(searchIsbn, "Title", 19.99, 100, Boolean.FALSE);
		var bookController = new BookController();
		bookController.books.put(searchIsbn, expectedBook); //WICHTIG: KEIN AUFRUF VON createBook
		var searchedBook = bookController.findByIsbn(searchIsbn);
		Assertions.assertEquals(expectedBook, searchedBook);
	}

	@Test
	public void invalidIsbnFindsNoBook() {
		var searchIsbn = "INVALID-ISBN";
		var bookController = new BookController();
		var searchedBook = bookController.findByIsbn(searchIsbn);
		Assertions.assertNull(searchedBook);
	}

}
