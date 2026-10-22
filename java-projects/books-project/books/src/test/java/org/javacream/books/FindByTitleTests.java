package org.javacream.books;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = TestConfiguration.class)
@ActiveProfiles("test")
public class FindByTitleTests {
    @Autowired
    private BookController controller;

    @BeforeEach
    void resetBooks() {
        controller.books.clear();
        controller.counter = 0;
    }

	@Test
	public void matchingTitleFindsBooks() {
		var first = "TEST-ISBN-1";
		controller.books.put(first, new Book(first, "Java Basics", 19.99, 100, Boolean.FALSE));
		controller.books.put("TEST-ISBN-2", new Book("TEST-ISBN-2", "Python Basics", 19.99, 100, Boolean.FALSE));
		Assertions.assertEquals(1, controller.findByTitle("Java").size());
		Assertions.assertEquals(first, controller.findByTitle("Java").get(0).isbn());
	}

	@Test
	public void titleSubstringFindsSeveralBooks() {
		controller.books.put("TEST-ISBN-3", new Book("TEST-ISBN-3", "Java Basics", 19.99, 100, Boolean.FALSE));
		controller.books.put("TEST-ISBN-4", new Book("TEST-ISBN-4", "Advanced Java", 19.99, 100, Boolean.FALSE));
		Assertions.assertEquals(2, controller.findByTitle("Java").size());
	}

	@Test
	public void unknownTitleFindsNoBooks() {
		controller.books.put("TEST-ISBN-5", new Book("TEST-ISBN-5", "Java Basics", 19.99, 100, Boolean.FALSE));
		Assertions.assertTrue(controller.findByTitle("Kotlin").isEmpty());
	}

}
