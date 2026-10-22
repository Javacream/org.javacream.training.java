package org.javacream.books;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = TestConfiguration.class)
@ActiveProfiles("test")
public class UpdateTitleTests {
    @Autowired
    private BookController controller;

    @Autowired
    private BookRepository repository;

    @BeforeEach
    void resetBooks() {
        repository.deleteAll();
    }

	@Test
	public void existingIsbnUpdatesTitle() {
		var isbn = "TEST-ISBN-1";
		repository.save(new Book(isbn, "Original", 19.99, 100, Boolean.FALSE));
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
		Assertions.assertFalse(controller.updateTitle("unknown", "New Title"));
		Assertions.assertTrue(controller.findAll().isEmpty());
	}

}
