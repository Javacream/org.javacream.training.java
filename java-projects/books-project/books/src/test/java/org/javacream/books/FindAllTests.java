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

    @Autowired
    private BookRepository repository;

    @BeforeEach
    void resetBooks() {
        repository.deleteAll();
    }

	
	@Test
	public void controllerHasTwoBooks() {
		var isbn1 = "i1";
		var isbn2 = "i2";
		var book1 = new Book(isbn1, "Title", 19.99, 100, Boolean.FALSE);
		var book2 = new Book(isbn2, "Title", 19.99, 100, Boolean.FALSE);
		var expectedSize = 2;
		repository.save(book1);
		repository.save(book2);
		var bookList = controller.findAll();
		Assertions.assertEquals(expectedSize, bookList.size());
	}
	@Test
	public void controllerRetrievesBooks() {
		var isbn1 = "i1";
		var isbn2 = "i2";
		var book1 = new Book(isbn1, "Title", 19.99, 100, Boolean.FALSE);
		var book2 = new Book(isbn2, "Title", 19.99, 100, Boolean.FALSE);
		repository.save(book1);
		repository.save(book2);
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
