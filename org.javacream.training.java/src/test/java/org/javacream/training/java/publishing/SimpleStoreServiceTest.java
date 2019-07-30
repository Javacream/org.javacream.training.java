package org.javacream.training.java.publishing;

import org.javacream.training.java.publishing.api.StoreService;
import org.javacream.training.java.publishing.impl.SimpleStoreService;
import org.junit.Before;
import org.junit.Test;

public class SimpleStoreServiceTest {
	
	private StoreService storeService;
	
	@Before public void init() {
		SimpleStoreService simpleStoreService = new SimpleStoreService();
		simpleStoreService.setDefaultStock(42);
		//SecondSimpleStoreService simpleStoreService = new SecondSimpleStoreService();
		this.storeService = simpleStoreService;
	}
	
	
	@Test public void testStoreService() {
		System.out.println(storeService.getStock("books", "ISBN1"));
	}

}
