package org.javacream.oop;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Publisher {

	private String name;
	private HashMap<String, Book> books;
	public Publisher(String name) {
		this.name = name;
		this.books = new HashMap<String, Book>();
	}
	public String getName() {
		return name;
	}
	
	public void publish(Book book) {
		this.books.put(book.getIsbn(), book);
	}
	public Book search(String isbn) {
		return this.books.get(isbn);
	}
	
	public List<String> allBookTitles(){
		return this.books.values().stream().map(book -> book.getTitle()).collect(Collectors.toList());
	}
}
