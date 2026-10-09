package org.javacream.training.java.books;

import java.util.ArrayList;
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

	public List<Book> findByTitle_OldStyleJava(String title){
		var bookValues = books.values();
		List<Book> matchingBooks = new ArrayList<Book>();
		for (Book b: bookValues) {
			if (b.title().contains(title)) {
				matchingBooks.add(b);
			}
		}
		return matchingBooks;
	}
//	public List<Book> findByTitle_UtopiaJava(String title){
//		return (b.title().equals(title);
//	}

	public List<Book> findByTitle_NewStyleJava(String title){
		return books.values().stream().filter(b -> b.title().contains(title)).toList();
	}

	public List<String> findIsbnsForTitle(String title){
		//SELECT b -> b.isbn() FROM books.values() WHERE b -> b.title().contains(title)
		return books.values().stream().filter(b -> b.title().contains(title)).map(b -> b.isbn()).toList();
	}
	
	public boolean complexCriterion(Book b) {
		return b.title().length() == 3 && Math.random() < 0.4;
	}
	public List<String> findByFoo(){
		return books.values().stream().filter(b -> complexCriterion(b)).map(b -> b.isbn()).toList();
	}
	
	// b -> b.title().length() //Ein Mapping, Book -> Integer, public List<Integer>
	// b.price() > 42 //
	// Buchtitel maximal 10 Zeichen, Filterausdruck b.title().length() <= 10
	public List<Book> findBooksWithTitleSmallerThan10(){
		return books.values().stream().filter(b -> b.title().length() <= 10).toList();
	}

}
