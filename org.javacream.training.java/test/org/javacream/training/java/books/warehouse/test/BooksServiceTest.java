package org.javacream.training.java.books.warehouse.test;

import java.util.List;

import org.javacream.training.java.books.warehouse.api.Book;
import org.javacream.training.java.books.warehouse.api.BooksService;
import org.javacream.training.java.books.warehouse.impl.JpaBooksService;
import org.javacream.training.java.books.warehouse.impl.JdbcBooksService;
import org.javacream.training.java.books.warehouse.impl.MapBooksService;
import org.junit.Assert;
import org.junit.Test;

public class BooksServiceTest {

	//@Test
	public void testMapBooksService() {
		BooksService booksService = new MapBooksService();
		testBooksService(booksService);
	}

	//@Test
	public void testJdbcBooksService() {
		BooksService booksService = new JdbcBooksService();
		testBooksService(booksService);
	}
	@Test
	public void testJpaBooksService() {
		BooksService booksService = new JpaBooksService();
		testBooksService(booksService);
	}

	private void testBooksService(BooksService booksService) {
		List<Book> booksList = booksService.findAll();
		int size = booksList.size();

		final String TITLE = "Java";
		final Double INITIAL_PRICE = 19.99;
		final Double PRICE = 29.99;
		final Integer PAGES = 200;
		final Boolean AVAILABLE = true;

		String isbn = booksService.create(TITLE, INITIAL_PRICE, PAGES, AVAILABLE);
		Assert.assertNotNull(isbn);
		Assert.assertEquals(size + 1, booksService.findAll().size());
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

		System.out.println(booksService.findAllAvailableBooks());
		System.out.println(booksService.findByPriceRange(10.0, 30.0));
		System.out.println(booksService.allBookTitles());

		booksService.deleteById(isbn);
		Book searched3 = booksService.findById(isbn);
		Assert.assertNull(searched3);
		
	}
}
