package org.javacream.training.java.books;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindAllTests {
	
	@Test
	public void controllerHasTwoBooks() {
		var isbn1 = "i1";
		var isbn2 = "i2";
		var book1 = new Book(isbn1, "Title", 19.99, 100, Boolean.FALSE);
		var book2 = new Book(isbn2, "Title", 19.99, 100, Boolean.FALSE);
		var expectedSize = 2;
		var bookController = new BookController();
		bookController.books.put(isbn1, book1); //WICHTIG: KEIN AUFRUF VON createBook
		bookController.books.put(isbn2, book2); //WICHTIG: KEIN AUFRUF VON createBook
		var bookList = bookController.findAll();
		Assertions.assertEquals(expectedSize, bookList.size());
	}
	@Test
	public void controllerRetrievesBooks() {
		var isbn1 = "i1";
		var isbn2 = "i2";
		var book1 = new Book(isbn1, "Title", 19.99, 100, Boolean.FALSE);
		var book2 = new Book(isbn2, "Title", 19.99, 100, Boolean.FALSE);
		var bookController = new BookController();
		bookController.books.put(isbn1, book1); //WICHTIG: KEIN AUFRUF VON createBook
		bookController.books.put(isbn2, book2); //WICHTIG: KEIN AUFRUF VON createBook
		var bookList = bookController.findAll();
		Assertions.assertTrue(bookList.contains(book1));
		Assertions.assertTrue(bookList.contains(book2));
	}

	@Test
	public void controllerHasNoBooks() {
		var expectedSize = 0;
		var bookController = new BookController();
		var bookList = bookController.findAll();
		Assertions.assertEquals(expectedSize, bookList.size());
	}

}
