package org.javacream.training.java.books;

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
}
