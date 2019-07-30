package org.javacream.training.java.publishing;

import org.javacream.training.java.publishing.api.BooksService;
import org.javacream.training.java.publishing.api.types.Book;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class BooksServiceSpringTest {
	@Autowired private BooksService booksService;
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
