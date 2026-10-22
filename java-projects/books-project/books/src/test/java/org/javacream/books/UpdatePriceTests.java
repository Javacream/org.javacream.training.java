package org.javacream.books;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UpdatePriceTests {
	@Test
	public void existingIsbnUpdatesPrice() {
		var controller = new BookController();
		var isbn = "TEST-ISBN-1";
		controller.books.put(isbn, new Book(isbn, "Original", 19.99, 100, Boolean.FALSE));
		var original = controller.findByIsbn(isbn);
		Assertions.assertTrue(controller.updatePrice(isbn, 29.95));
		var updated = controller.findByIsbn(isbn);
		Assertions.assertEquals(29.95, updated.price());
		Assertions.assertEquals(original.isbn(), updated.isbn());
		Assertions.assertEquals(original.title(), updated.title());
		Assertions.assertEquals(original.pages(), updated.pages());
		Assertions.assertEquals(original.available(), updated.available());
	}

	@Test
	public void unknownIsbnDoesNotCreateBook() {
		var controller = new BookController();
		Assertions.assertFalse(controller.updatePrice("unknown", 29.95));
		Assertions.assertTrue(controller.findAll().isEmpty());
	}

}
