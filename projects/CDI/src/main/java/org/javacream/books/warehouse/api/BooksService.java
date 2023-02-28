package org.javacream.books.warehouse.api;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public interface BooksService{
	String newBook(String title) throws BookException;

	Book findBookByIsbn(String isbn) throws BookException;
	
	Book updateBook(Book book) throws BookException;
	
	void deleteBookByIsbn(String isbn) throws BookException;
	
	Collection<Book> findAllBooks();

	default List<Book> findBooksByTitle(String title){
		return findAllBooks().stream().filter(b -> b.getTitle().equals(title)).collect(Collectors.toList());
	}
	default List<Book> findBooksByPriceRange(double min, double max){
		return findAllBooks().stream().filter(b -> b.getPrice()>= min && b.getPrice()<= max).collect(Collectors.toList());
	}
	default Map<String, List<Book>> findAllGroupByTitle(){
		return findAllBooks().stream().collect(Collectors.groupingBy(Book::getTitle));
	}
}

