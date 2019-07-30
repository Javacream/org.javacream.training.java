package org.javacream.training.java.publishing.app;

import javax.annotation.PostConstruct;

import org.javacream.training.java.publishing.api.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PublishingApplication {

	@Autowired
	private BooksService booksService;
	
	@PostConstruct
	public void start() {
		String title = "Spring in Action";
		String isbn = booksService.newBook(title);
		String title2 = "Java";
		String isbn2 = booksService.newBook(title2);
		
		System.out.println(booksService.findBookByIsbn(isbn));
		System.out.println(booksService.findBookByIsbn(isbn2));
		
	}
}
