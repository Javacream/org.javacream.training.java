package org.javacream.books;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookController {
	@Autowired IsbnGenerator isbnGenerator;
	@Autowired BooksRepository booksRepository;
//	Map<String, Book> books = new HashMap<>();
	Integer counter = 0;
	Double DEFAULT_PRICE = 19.99;
	Integer DEFAULT_PAGES = 0;
	Boolean DEFAULT_AVAILABILITY = Boolean.FALSE;
	public String createBook(String title) {
		var newIsbn = isbnGenerator.next();
		var book = new Book(newIsbn, title, DEFAULT_PRICE, DEFAULT_PAGES, DEFAULT_AVAILABILITY);
		//books.put(newIsbn, book);
		booksRepository.f
		return newIsbn;
	}
	
	public Book findByIsbn(String isbn) {
		entityManager.find(Book.class, isbn);
		return books.get(isbn);
	}
	
	public List<Book> findAll(){
		var bookValues = books.values();
		return List.copyOf(bookValues);
	}


	public List<Book> findByTitle(String title){
		return books.values().stream().filter(b -> b.getTitle().contains(title)).toList();
	}

	public List<String> findIsbnsForTitle(String title){
		return books.values().stream().filter(b -> b.getTitle().contains(title)).map(b -> b.getIsbn()).toList();
	}
	
	public List<Book> findBooksWithTitleSmallerThan10(){
		return books.values().stream().filter(b -> b.getTitle().length() <= 10).toList();
	}


	public Boolean updateTitle(String isbn, String newTitle) {
		var updated = books.computeIfPresent(isbn, (key, book) ->
			new Book(book.getIsbn(), newTitle, book.getPrice(), book.getPages(), book.getAvailable()));
		return updated != null;
	}

	public Boolean updatePrice(String isbn, Double newPrice) {
		var updated = books.computeIfPresent(isbn, (key, book) ->
			new Book(book.getIsbn(), book.getTitle(), newPrice, book.getPages(), book.getAvailable()));
		return updated != null;
	}

	public Boolean updatePages(String isbn, Integer newPages) {
		var updated = books.computeIfPresent(isbn, (key, book) ->
			new Book(book.getIsbn(), book.getTitle(), book.getPrice(), newPages, book.getAvailable()));
		return updated != null;
	}

	public Boolean updateAvailability(String isbn, Boolean newAvailability) {
		var updated = books.computeIfPresent(isbn, (key, book) ->
			new Book(book.getIsbn(), book.getTitle(), book.getPrice(), book.getPages(), newAvailability));
		return updated != null;
	}

	public Boolean deleteByIsbn(String isbn) {
		return books.remove(isbn) != null;
	}

}
