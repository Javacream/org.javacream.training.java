package org.javacream.training.java.advanced;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JpaBooksServiceTest {

	@Autowired
	private JpaBooksService booksService;
	@Test
	void testBooksService() {
		booksService.doDemo();
	}

}
