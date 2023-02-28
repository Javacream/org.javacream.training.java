package org.javacream.books.warehouse.test;

import org.javacream.ApplicationContext;
import org.javacream.books.isbngenerator.impl.RandomIsbnGenerator;
import org.javacream.books.warehouse.impl.MapBooksService;
import org.javacream.store.impl.SimpleStoreService;
import org.junit.jupiter.api.Test;


public class BooksServiceTest {

	@Test
	public void testBusinessObjects() {
		TestActor.doTest(ApplicationContext.getBooksService());
		
	
	}

	

}