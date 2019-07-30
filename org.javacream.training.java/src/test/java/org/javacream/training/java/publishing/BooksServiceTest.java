package org.javacream.training.java.publishing;

import org.javacream.training.java.publishing.api.BooksService;
import org.javacream.training.java.publishing.api.types.Book;
import org.javacream.training.java.publishing.impl.MapBooksService;
import org.javacream.training.java.publishing.impl.RandomIsbnGenerator;
import org.javacream.training.java.publishing.impl.SimpleStoreService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BooksServiceTest {
	private BooksService booksService;
	@Before public void init() {
		MapBooksService mapBooksService = new MapBooksService();
		RandomIsbnGenerator randomIsbnGenerator = new RandomIsbnGenerator();
		SimpleStoreService simpleStoreService = new SimpleStoreService();
		
		mapBooksService.setIsbnGenerator(randomIsbnGenerator);
		mapBooksService.setStoreService(simpleStoreService);
		randomIsbnGenerator.setPrefix("ISBN:");
		randomIsbnGenerator.setSuffix("-de");
		simpleStoreService.setDefaultStock(42);
		this.booksService = mapBooksService;
	}
	
	@Test
	public void testBooksSequence() {
		// final String ISBN = "ISBN";
		final String TITLE = "TITLE";
		final double PRICE = 19.99;
		final int PAGES = 200;

		String isbn = booksService.newBook(TITLE);
		Book book = booksService.findBookByIsbn(isbn);
		Assert.assertEquals(isbn, book.getIsbn());
		Assert.assertEquals(TITLE, book.getTitle());
		book.setPages(PAGES);
		book.setPrice(PRICE);
		booksService.updateBook(book);
		book = booksService.findBookByIsbn(isbn);
		Assert.assertEquals(isbn, book.getIsbn());
		Assert.assertEquals(TITLE, book.getTitle());
		Assert.assertEquals(PAGES, book.getPages());
		Assert.assertEquals(PRICE, book.getPrice(), 1e-9);
		booksService.deleteBookByIsbn(isbn);
		book = booksService.findBookByIsbn(isbn);
		Assert.assertNull(book);

	}

}
