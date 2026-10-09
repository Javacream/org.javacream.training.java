package org.javacream.training.java.books;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookController {
	Map<String, Book> books = new HashMap<>();
	Integer counter = 0;
	Double DEFAULT_PRICE = 19.99;
	Integer DEFAULT_PAGES = 0;
	Boolean DEFAULT_AVAILABILITY = Boolean.FALSE;
	public String createBook(String title) {
		counter++;
		var newIsbn = "ISBN:" + counter;
		var book = new Book(newIsbn, title, DEFAULT_PRICE, DEFAULT_PAGES, DEFAULT_AVAILABILITY);
		books.put(newIsbn, book);
		return newIsbn;
	}
	
	public Book findByIsbn(String isbn) {
		return books.get(isbn);
	}
	
	public List<Book> findAll(){
		var bookValues = books.values();
		return List.copyOf(bookValues);
	}

}
