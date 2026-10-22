package org.javacream.books;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindIsbnsForTitleTests {
	@Test
	public void matchingTitleFindsIsbns() {
		var controller = new BookController();
		var first = "TEST-ISBN-1";
		controller.books.put(first, new Book(first, "Java Basics", 19.99, 100, Boolean.FALSE));
		var second = "TEST-ISBN-2";
		controller.books.put(second, new Book(second, "Java Advanced", 19.99, 100, Boolean.FALSE));
		controller.books.put("TEST-ISBN-3", new Book("TEST-ISBN-3", "Python", 19.99, 100, Boolean.FALSE));
		var isbns = controller.findIsbnsForTitle("Java");
		Assertions.assertEquals(2, isbns.size());
		Assertions.assertTrue(isbns.contains(first));
		Assertions.assertTrue(isbns.contains(second));
	}

	@Test
	public void unknownTitleFindsNoIsbns() {
		var controller = new BookController();
		controller.books.put("TEST-ISBN-4", new Book("TEST-ISBN-4", "Java", 19.99, 100, Boolean.FALSE));
		Assertions.assertTrue(controller.findIsbnsForTitle("Python").isEmpty());
	}

}
