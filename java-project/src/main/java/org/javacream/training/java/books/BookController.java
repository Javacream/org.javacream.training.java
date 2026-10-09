package org.javacream.training.java.books;

import java.util.ArrayList;
import java.util.List;

public class BookController {
	List<Book> books = new ArrayList<>();
	Integer counter = 0;
	Double DEFAULT_PRICE = 19.99;
	Integer DEFAULT_PAGES = 0;
	Boolean DEFAULT_AVAILABILITY = Boolean.FALSE;
	public String createBook(String title) {
		counter++;
		var newIsbn = "ISBN:" + counter;
		var book = new Book(newIsbn, title, DEFAULT_PRICE, DEFAULT_PAGES, DEFAULT_AVAILABILITY);
		books.add(book);
		return newIsbn;
	}

}
