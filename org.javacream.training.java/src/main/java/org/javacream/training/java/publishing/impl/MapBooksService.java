package org.javacream.training.java.publishing.impl;

import java.util.HashMap;
import java.util.Map;

import org.javacream.training.java.publishing.api.BooksService;
import org.javacream.training.java.publishing.api.IsbnGenerator;
import org.javacream.training.java.publishing.api.StoreService;
import org.javacream.training.java.publishing.api.types.Book;

public class MapBooksService implements BooksService {

	private Map<String, Book> books = new HashMap<>();
	private IsbnGenerator isbnGenerator;
	private StoreService storeService;
	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}

	public void setIsbnGenerator(IsbnGenerator randomIsbnGenerator) {
		this.isbnGenerator = randomIsbnGenerator;
	}

	// {
//		randomIsbnGenerator = new RandomIsbnGenerator();//Prinzipiell OK, aber nicht wirklich "modern"
//	}
	@Override
	public String newBook(String title) {
		String isbn = isbnGenerator.next();
		Book newBook = new Book(isbn, title);
		books.put(isbn, newBook);
		return isbn;
	}

	@Override
	public Book findBookByIsbn(String isbn) {
		return books.get(isbn);
	}

	@Override
	public Book deleteBookByIsbn(String isbn) {
		//TODO: Über den StoreService den Stock abfragen: getStock("books", isbn)
		Book book = books.remove(isbn);
		if (book != null) {
			int stock = storeService.getStock("books", isbn);
			book.setAvailable(stock > 0);
		}
		return book;
	}

	@Override
	public void updateBook(Book book) {
		books.put(book.getIsbn(), book);
	}

}
