package org.javacream.books;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = TestConfiguration.class)
@ActiveProfiles("test")
public class FindAllTests {
    @Autowired
    private BookController controller;

    @BeforeEach
    void resetBooks() {
        controller.books.clear();
        controller.counter = 0;
    }

	
	@Test
	public void controllerHasTwoBooks() {
		var isbn1 = "i1";
		var isbn2 = "i2";
		var book1 = new Book(isbn1, "Title", 19.99, 100, Boolean.FALSE);
		var book2 = new Book(isbn2, "Title", 19.99, 100, Boolean.FALSE);
		var expectedSize = 2;
		controller.books.put(isbn1, book1);
		controller.books.put(isbn2, book2);
		var bookList = controller.findAll();
		Assertions.assertEquals(expectedSize, bookList.size());
	}
	@Test
	public void controllerRetrievesBooks() {
		var isbn1 = "i1";
		var isbn2 = "i2";
		var book1 = new Book(isbn1, "Title", 19.99, 100, Boolean.FALSE);
		var book2 = new Book(isbn2, "Title", 19.99, 100, Boolean.FALSE);
		controller.books.put(isbn1, book1);
		controller.books.put(isbn2, book2);
		var bookList = controller.findAll();
		Assertions.assertTrue(bookList.contains(book1));
		Assertions.assertTrue(bookList.contains(book2));
	}

	@Test
	public void controllerHasNoBooks() {
		var expectedSize = 0;
		var bookList = controller.findAll();
		Assertions.assertEquals(expectedSize, bookList.size());
	}

}
