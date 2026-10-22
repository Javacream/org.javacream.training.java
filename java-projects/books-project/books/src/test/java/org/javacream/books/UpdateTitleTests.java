package org.javacream.books;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UpdateTitleTests {
	@Test
	public void existingIsbnUpdatesTitle() {
		var controller = new BookController();
		var isbn = "TEST-ISBN-1";
		controller.books.put(isbn, new Book(isbn, "Original", 19.99, 100, Boolean.FALSE));
		var original = controller.findByIsbn(isbn);
		Assertions.assertTrue(controller.updateTitle(isbn, "New Title"));
		var updated = controller.findByIsbn(isbn);
		Assertions.assertEquals("New Title", updated.title());
		Assertions.assertEquals(original.isbn(), updated.isbn());
		Assertions.assertEquals(original.price(), updated.price());
		Assertions.assertEquals(original.pages(), updated.pages());
		Assertions.assertEquals(original.available(), updated.available());
	}

	@Test
	public void unknownIsbnDoesNotCreateBook() {
		var controller = new BookController();
		Assertions.assertFalse(controller.updateTitle("unknown", "New Title"));
		Assertions.assertTrue(controller.findAll().isEmpty());
	}

}
