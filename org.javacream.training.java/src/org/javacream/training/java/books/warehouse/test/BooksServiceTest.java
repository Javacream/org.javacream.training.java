package org.javacream.training.java.books.warehouse.test;

import org.javacream.training.java.books.warehouse.api.Book;
import org.javacream.training.java.books.warehouse.api.BooksService;
import org.javacream.training.java.books.warehouse.impl.MapBooksService;
import org.junit.Assert;
import org.junit.Test;

public class BooksServiceTest {

	@Test public void testBooksService() {
		BooksService booksService = new MapBooksService();
		final String TITLE = "Java";
		final Double INITIAL_PRICE = 19.99;
		final Double PRICE = 29.99;
		final Integer PAGES = 200;
		final Boolean AVAILABLE = true;
		
		String isbn = booksService.create(TITLE, INITIAL_PRICE, PAGES, AVAILABLE);
		Assert.assertNotNull(isbn);
		Book searched = booksService.findById(isbn);
		Assert.assertNotNull(searched);
		Assert.assertEquals(TITLE, searched.getTitle());
		Assert.assertEquals(INITIAL_PRICE, searched.getPrice(), 1e-12);
		searched.setPrice(PRICE);
		booksService.update(searched);
		Book searched2 = booksService.findById(isbn);
		Assert.assertNotNull(searched2);
		Assert.assertEquals(TITLE, searched2.getTitle());
		Assert.assertEquals(PRICE, searched2.getPrice(), 1e-12);
		booksService.deleteById(isbn);
		Book searched3 = booksService.findById(isbn);
		Assert.assertNull(searched3);
		
		
		
	}
}
