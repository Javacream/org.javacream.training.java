package org.javacream.books;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = TestConfiguration.class)
@ActiveProfiles("test")
public class FindByIsbnTests {
    @Autowired
    private BookController controller;

    @BeforeEach
    void resetBooks() {
        controller.books.clear();
        controller.counter = 0;
    }

	
	@Test
	public void validIsbnFindsBook() {
		var searchIsbn = "TEST-ISBN";
		var expectedBook = new Book(searchIsbn, "Title", 19.99, 100, Boolean.FALSE);
		controller.books.put(searchIsbn, expectedBook);
		var searchedBook = controller.findByIsbn(searchIsbn);
		Assertions.assertEquals(expectedBook, searchedBook);
	}

	@Test
	public void invalidIsbnFindsNoBook() {
		var searchIsbn = "INVALID-ISBN";
		var searchedBook = controller.findByIsbn(searchIsbn);
		Assertions.assertNull(searchedBook);
	}

}
