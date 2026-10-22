package org.javacream.books;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
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


	public List<Book> findByTitle(String title){
		return books.values().stream().filter(b -> b.title().contains(title)).toList();
	}

	public List<String> findIsbnsForTitle(String title){
		return books.values().stream().filter(b -> b.title().contains(title)).map(b -> b.isbn()).toList();
	}
	
	public List<Book> findBooksWithTitleSmallerThan10(){
		return books.values().stream().filter(b -> b.title().length() <= 10).toList();
	}


	public Boolean updateTitle(String isbn, String newTitle) {
		var updated = books.computeIfPresent(isbn, (key, book) ->
			new Book(book.isbn(), newTitle, book.price(), book.pages(), book.available()));
		return updated != null;
	}

	public Boolean updatePrice(String isbn, Double newPrice) {
		var updated = books.computeIfPresent(isbn, (key, book) ->
			new Book(book.isbn(), book.title(), newPrice, book.pages(), book.available()));
		return updated != null;
	}

	public Boolean updatePages(String isbn, Integer newPages) {
		var updated = books.computeIfPresent(isbn, (key, book) ->
			new Book(book.isbn(), book.title(), book.price(), newPages, book.available()));
		return updated != null;
	}

	public Boolean updateAvailability(String isbn, Boolean newAvailability) {
		var updated = books.computeIfPresent(isbn, (key, book) ->
			new Book(book.isbn(), book.title(), book.price(), book.pages(), newAvailability));
		return updated != null;
	}

	public Boolean deleteByIsbn(String isbn) {
		return books.remove(isbn) != null;
	}

}
