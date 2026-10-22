package org.javacream.books;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = TestConfiguration.class)
@ActiveProfiles("test")
public class CreateBookTest {
    @Autowired
    private BookController controller;

    @BeforeEach
    void resetBooks() {
        controller.books.clear();
        controller.counter = 0;
    }

	@Test
	public void createBookOK() {
		var title = "TEST_TITLE";
		var expectedIsbnPrefix = "ISBN:";
		var createdIsbn = controller.createBook(title);
		Assertions.assertTrue(createdIsbn.startsWith(expectedIsbnPrefix), "generated isbn does not start with '%s', was '%s'".formatted(expectedIsbnPrefix, createdIsbn));
	}

	@Test
	public void createdBookHasExpectedProperties() {
		var isbn = controller.createBook("Test");
		var book = controller.findByIsbn(isbn);
		Assertions.assertEquals("Test", book.title());
		Assertions.assertEquals(19.99, book.price());
		Assertions.assertEquals(0, book.pages());
		Assertions.assertFalse(book.available());
	}

	@Test
	public void createdBooksHaveDifferentIsbns() {
		var first = controller.createBook("First");
		var second = controller.createBook("Second");
		Assertions.assertNotEquals(first, second);
		Assertions.assertEquals(2, controller.findAll().size());
	}
}
