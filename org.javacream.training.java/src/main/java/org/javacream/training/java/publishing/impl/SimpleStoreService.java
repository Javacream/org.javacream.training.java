package org.javacream.training.java.publishing.impl;

import org.javacream.training.java.publishing.api.StoreService;

public class SimpleStoreService implements StoreService {

	@Override
	public int getStock(String category, String itemId) {
		return 42;
	}

}
