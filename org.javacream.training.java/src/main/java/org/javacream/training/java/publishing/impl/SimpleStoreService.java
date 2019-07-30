package org.javacream.training.java.publishing.impl;

import org.javacream.training.java.publishing.api.StoreService;

public class SimpleStoreService implements StoreService {

	private int defaultStock;
	
	
	public void setDefaultStock(int defaultStock) {
		this.defaultStock = defaultStock;
	}


	@Override
	public int getStock(String category, String itemId) {
		return 42;
	}

}
