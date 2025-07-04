package org.javacream.oop;

import java.util.ArrayList;
import java.util.Comparator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BookTests {
	@Test public void testBooksSort() {
		var b1 = new Book("ISBN-1", "Java", 200, 19.99);
		var b2 = new Book("ISBN-2", "Python", 100, 9.99);
		var b3 = new Book("ISBN-3", "Fortran", 260, 29.99);
		var b4 = new Book("ISBN-4", "C", 600, 39.99);
		var books = new ArrayList<Book>();
		books.add(b1);
		books.add(b2);
		books.add(b3);
		books.add(b4);
		Assertions.assertEquals(4,  books.size());
		
		books.sort(new BooksComparator());
		System.out.println(books);
	}

	class BooksComparator implements Comparator<Book>{

		@Override
		public int compare(Book b1, Book b2) {
			return b1.getPrice().compareTo(b2.getPrice());
		}
		
	}
}
