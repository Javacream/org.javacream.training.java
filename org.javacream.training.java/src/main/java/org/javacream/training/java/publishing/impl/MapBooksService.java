package org.javacream.training.java.publishing.impl;

import java.util.HashMap;
import java.util.Map;

import org.javacream.training.java.publishing.api.BooksService;
import org.javacream.training.java.publishing.api.types.Book;

public class MapBooksService implements BooksService {

	private Map<String, Book> books = new HashMap<>();
	
	@Override
	public void newBook(String isbn, String title) {
		Book newBook = new Book(isbn, title);
		books.put(isbn, newBook);
	}
	
	@Override
	public Book findBookByIsbn(String isbn) {
		return books.get(isbn);
	}
	
	@Override
	public Book deleteBookByIsbn(String isbn) {
		return books.remove(isbn);
	}
	
	@Override
	public void updateBook(Book book) {
		books.put(book.getIsbn(), book);
	}
	

}
