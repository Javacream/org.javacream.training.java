package org.javacream.books;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = TestConfiguration.class)
@ActiveProfiles("test")
public class FindIsbnsForTitleTests {
    @Autowired
    private BookController controller;

    @Autowired
    private BookRepository repository;

    @BeforeEach
    void resetBooks() {
        repository.deleteAll();
    }

	@Test
	public void matchingTitleFindsIsbns() {
		var first = "TEST-ISBN-1";
		repository.save(new Book(first, "Java Basics", 19.99, 100, Boolean.FALSE));
		var second = "TEST-ISBN-2";
		repository.save(new Book(second, "Java Advanced", 19.99, 100, Boolean.FALSE));
		repository.save(new Book("TEST-ISBN-3", "Python", 19.99, 100, Boolean.FALSE));
		var isbns = controller.findIsbnsForTitle("Java");
		Assertions.assertEquals(2, isbns.size());
		Assertions.assertTrue(isbns.contains(first));
		Assertions.assertTrue(isbns.contains(second));
	}

	@Test
	public void unknownTitleFindsNoIsbns() {
		repository.save(new Book("TEST-ISBN-4", "Java", 19.99, 100, Boolean.FALSE));
		Assertions.assertTrue(controller.findIsbnsForTitle("Python").isEmpty());
	}

}
