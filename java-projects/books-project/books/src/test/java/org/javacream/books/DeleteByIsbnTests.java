package org.javacream.books;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = TestConfiguration.class)
@ActiveProfiles("test")
public class DeleteByIsbnTests {
    @Autowired
    private BookController controller;

    @BeforeEach
    void resetBooks() {
        controller.books.clear();
        controller.counter = 0;
    }

	@Test
	public void existingIsbnDeletesBook() {
		var deletedIsbn = "TEST-ISBN-1";
		controller.books.put(deletedIsbn, new Book(deletedIsbn, "Delete me", 19.99, 100, Boolean.FALSE));
		var retainedIsbn = "TEST-ISBN-2";
		controller.books.put(retainedIsbn, new Book(retainedIsbn, "Keep me", 19.99, 100, Boolean.FALSE));
		Assertions.assertTrue(controller.deleteByIsbn(deletedIsbn));
		Assertions.assertNull(controller.findByIsbn(deletedIsbn));
		Assertions.assertNotNull(controller.findByIsbn(retainedIsbn));
		Assertions.assertEquals(1, controller.findAll().size());
	}

	@Test
	public void unknownIsbnDoesNotChangeBooks() {
		var isbn = "TEST-ISBN-3";
		controller.books.put(isbn, new Book(isbn, "Keep me", 19.99, 100, Boolean.FALSE));
		Assertions.assertFalse(controller.deleteByIsbn("unknown"));
		Assertions.assertNotNull(controller.findByIsbn(isbn));
		Assertions.assertEquals(1, controller.findAll().size());
	}

}
