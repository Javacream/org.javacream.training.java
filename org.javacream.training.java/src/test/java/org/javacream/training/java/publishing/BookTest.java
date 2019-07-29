package org.javacream.training.java.publishing;

import org.junit.Test;

public class BookTest {

	@Test public void testBook() {
		Book book = new Book("ISBN", "TITLE");
		System.out.println(book);
		book.setPages(100);
		book.setPrice(19.99);
		System.out.println(book);
	}
	@Test public void testSchoolBook() {
		SchoolBook book = new SchoolBook("ISBN", "TITLE", 1984, "TOPIC");
		System.out.println(book);
		book.setPages(100);
		book.setPrice(19.99);
		System.out.println(book);
	}
	@Test public void testSpecialistBook() {
		SpecialistBook book = new SpecialistBook("ISBN", "TITLE", "SUBJECT");
		System.out.println(book);
		book.setPages(100);
		book.setPrice(19.99);
		System.out.println(book);
	}
	
}
