package org.javacream.books;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UpdatePagesTests {
	@Test
	public void existingIsbnUpdatesPages() {
		var controller = new BookController();
		var isbn = "TEST-ISBN-1";
		controller.books.put(isbn, new Book(isbn, "Original", 19.99, 100, Boolean.FALSE));
		var original = controller.findByIsbn(isbn);
		Assertions.assertTrue(controller.updatePages(isbn, 250));
		var updated = controller.findByIsbn(isbn);
		Assertions.assertEquals(250, updated.pages());
		Assertions.assertEquals(original.isbn(), updated.isbn());
		Assertions.assertEquals(original.title(), updated.title());
		Assertions.assertEquals(original.price(), updated.price());
		Assertions.assertEquals(original.available(), updated.available());
	}

	@Test
	public void unknownIsbnDoesNotCreateBook() {
		var controller = new BookController();
		Assertions.assertFalse(controller.updatePages("unknown", 250));
		Assertions.assertTrue(controller.findAll().isEmpty());
	}

}
