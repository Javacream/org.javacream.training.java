package org.javacream.training.java.books.warehouse.api;

public interface BooksService {
	String create(String title, Double price, Integer pages, Boolean available);

	Book findById(String isbn);

	void deleteById(String isbn);

	void update(Book book);

}
