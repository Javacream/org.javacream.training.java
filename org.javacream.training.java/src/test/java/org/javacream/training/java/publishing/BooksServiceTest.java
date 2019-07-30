package org.javacream.training.java.publishing;

import org.javacream.training.java.publishing.api.BooksService;
import org.javacream.training.java.publishing.api.types.Book;
import org.javacream.training.java.publishing.impl.MapBooksService;
import org.junit.Assert;
import org.junit.Test;

public class BooksServiceTest {

@Test public void testBooksSequence() {
	BooksService booksService = new MapBooksService();
	final String ISBN = "ISBN";
	final String TITLE = "TITLE";
	final double PRICE = 19.99;
	final int PAGES = 200;
	
	booksService.newBook(ISBN, TITLE);
	Book book = booksService.findBookByIsbn(ISBN);
	Assert.assertEquals(ISBN, book.getIsbn());
	Assert.assertEquals(TITLE, book.getTitle());
	book.setPages(PAGES);
	book.setPrice(PRICE);
	booksService.updateBook(book);
	book = booksService.findBookByIsbn(ISBN);
	Assert.assertEquals(ISBN, book.getIsbn());
	Assert.assertEquals(TITLE, book.getTitle());
	Assert.assertEquals(PAGES, book.getPages());
	Assert.assertEquals(PRICE, book.getPrice(), 1e-9);
	booksService.deleteBookByIsbn(ISBN);
	book = booksService.findBookByIsbn(ISBN);
	Assert.assertNull(book);
	
	
}
	
}
