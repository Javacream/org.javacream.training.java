package org.javacream.books;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateBookTest {
	@Test
	public void createBookOK() {
		var title = "TEST_TITLE";
		var expectedIsbnPrefix = "ISBN:";
		var bookController = new BookController();
		var createdIsbn = bookController.createBook(title);
		Assertions.assertTrue(createdIsbn.startsWith(expectedIsbnPrefix), "generated isbn does not start with '%s', was '%s'".formatted(expectedIsbnPrefix, createdIsbn));
	}

	@Test
	public void createdBookHasExpectedProperties() {
		var controller = new BookController();
		var isbn = controller.createBook("Test");
		var book = controller.findByIsbn(isbn);
		Assertions.assertEquals("Test", book.title());
		Assertions.assertEquals(19.99, book.price());
		Assertions.assertEquals(0, book.pages());
		Assertions.assertFalse(book.available());
	}

	@Test
	public void createdBooksHaveDifferentIsbns() {
		var controller = new BookController();
		var first = controller.createBook("First");
		var second = controller.createBook("Second");
		Assertions.assertNotEquals(first, second);
		Assertions.assertEquals(2, controller.findAll().size());
	}
}
