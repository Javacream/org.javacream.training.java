package org.javacream.training.java.publishing;

import java.util.HashMap;

public class BooksService {

	private HashMap<String, Book> books = new HashMap<>();
	
	public void newBook(String isbn, String title) {
		Book newBook = new Book(isbn, title);
		books.put(isbn, newBook);
	}
	
	public Book findBookByIsbn(String isbn) {
		return books.get(isbn);
	}
	
	public Book deleteBookByIsbn(String isbn) {
		return books.remove(isbn);
	}
	
	public void updateBook(Book book) {
		books.put(book.getIsbn(), book);
	}
	

}
