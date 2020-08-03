package org.javacream.training.java.books.warehouse.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.javacream.training.java.books.warehouse.api.Book;
import org.javacream.training.java.books.warehouse.api.BooksService;

public class MapBooksService implements BooksService {
	private Map<String, Book> books = new HashMap<>();
	private static final String PREFIX = "ISBN:";
	private static final String COUNTRY_CODE = "-de";
	private Random random = new Random(this.hashCode() + System.currentTimeMillis());

	@Override
	public String create(String title, Double price, Integer pages, Boolean available) {
		Integer key = Math.abs(random.nextInt());
		String isbn = PREFIX + key + COUNTRY_CODE;
		Book newBook = new Book (isbn, title, price, pages, available);
		books.put(isbn, newBook);
		return isbn;
	}

	@Override
	public Book findById(String isbn) {
		return books.get(isbn);
	}

	@Override
	public void deleteById(String isbn) {
		books.remove(isbn);
	}

	@Override
	public void update(Book book) {
		books.put(book.getIsbn(), book);
	}

	@Override
	public List<Book> findAll() {
		return new ArrayList<>(books.values());
	}

}
