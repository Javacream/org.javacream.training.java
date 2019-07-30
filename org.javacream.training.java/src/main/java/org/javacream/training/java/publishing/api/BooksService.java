package org.javacream.training.java.publishing.api;

import org.javacream.training.java.publishing.api.types.Book;

public interface BooksService {

	void newBook(String isbn, String title);

	Book findBookByIsbn(String isbn);

	Book deleteBookByIsbn(String isbn);

	void updateBook(Book book);

}