package org.javacream.books;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UpdateAvailabilityTests {
	@Test
	public void existingIsbnUpdatesAvailability() {
		var controller = new BookController();
		var isbn = "TEST-ISBN-1";
		controller.books.put(isbn, new Book(isbn, "Original", 19.99, 100, Boolean.FALSE));
		var original = controller.findByIsbn(isbn);
		Assertions.assertTrue(controller.updateAvailability(isbn, Boolean.TRUE));
		var updated = controller.findByIsbn(isbn);
		Assertions.assertEquals(Boolean.TRUE, updated.available());
		Assertions.assertEquals(original.isbn(), updated.isbn());
		Assertions.assertEquals(original.title(), updated.title());
		Assertions.assertEquals(original.price(), updated.price());
		Assertions.assertEquals(original.pages(), updated.pages());
	}

	@Test
	public void unknownIsbnDoesNotCreateBook() {
		var controller = new BookController();
		Assertions.assertFalse(controller.updateAvailability("unknown", Boolean.TRUE));
		Assertions.assertTrue(controller.findAll().isEmpty());
	}

}
