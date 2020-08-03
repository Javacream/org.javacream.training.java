package org.javacream.training.java.books.warehouse.api;

import java.util.List;

public interface BooksService {
	String create(String title, Double price, Integer pages, Boolean available);

	Book findById(String isbn);

	void deleteById(String isbn);

	void update(Book book);

	List<Book> findAll();
	
	List<Book> findAllAvailableBooks();
	List<Book> findByPriceRange(double min, double max);
	List<String> allBookTitles();
	
}
