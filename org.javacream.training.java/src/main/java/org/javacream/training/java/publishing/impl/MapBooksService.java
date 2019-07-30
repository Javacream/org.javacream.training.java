package org.javacream.training.java.publishing.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.javacream.training.java.publishing.api.BooksService;
import org.javacream.training.java.publishing.api.IsbnGenerator;
import org.javacream.training.java.publishing.api.StoreService;
import org.javacream.training.java.publishing.api.types.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MapBooksService implements BooksService {

	private Map<String, Book> books = new HashMap<>();
	
	//@Resource(name = "rig")
	@Autowired @Qualifier(IsbnGenerator.Strategies.SEQUENCE)
	private IsbnGenerator isbnGenerator;
	@Autowired
	private StoreService storeService;
	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}

	public void setIsbnGenerator(IsbnGenerator randomIsbnGenerator) {
		this.isbnGenerator = randomIsbnGenerator;
	}

	@PostConstruct public void init() {
		for (int i = 0; i < 5; i++) {
			Book book = new Book("ISBN" + i, "TITLE" + i);
			book.setPages(10*i);
			book.setPrice(i * 5 + .99);
			books.put(book.getIsbn(), book);
		}
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
		//TODO: Über den StoreService den Stock abfragen: getStock("books", isbn)
		Book book = books.get(isbn);
		if (book != null) {
			int stock = storeService.getStock("books", isbn);
			book.setAvailable(stock > 0);
		}
		return book;
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
