package org.javacream.books;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindBooksWithTitleSmallerThan10Tests {
	@Test
	public void shortAndExactlyTenCharacterTitlesAreFound() {
		var controller = new BookController();
		var shortIsbn = "TEST-ISBN-1";
		controller.books.put(shortIsbn, new Book(shortIsbn, "Short", 19.99, 100, Boolean.FALSE));
		var boundaryIsbn = "TEST-ISBN-2";
		controller.books.put(boundaryIsbn, new Book(boundaryIsbn, "1234567890", 19.99, 100, Boolean.FALSE));
		controller.books.put("TEST-ISBN-3", new Book("TEST-ISBN-3", "12345678901", 19.99, 100, Boolean.FALSE));
		var result = controller.findBooksWithTitleSmallerThan10();
		Assertions.assertEquals(2, result.size());
		Assertions.assertTrue(result.stream().anyMatch(book -> book.isbn().equals(shortIsbn)));
		Assertions.assertTrue(result.stream().anyMatch(book -> book.isbn().equals(boundaryIsbn)));
	}

	@Test
	public void noMatchingTitlesReturnsEmptyList() {
		var controller = new BookController();
		controller.books.put("TEST-ISBN-4", new Book("TEST-ISBN-4", "12345678901", 19.99, 100, Boolean.FALSE));
		Assertions.assertTrue(controller.findBooksWithTitleSmallerThan10().isEmpty());
	}

}
