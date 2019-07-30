package org.javacream.training.java.publishing.impl;

import org.javacream.training.java.publishing.api.StoreService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
//@Scope("singleton"), default, other possible scope: prototype
public class SimpleStoreService implements StoreService {

	@Value("${defaultStock}")
	private int defaultStock;
	
	
	public void setDefaultStock(int defaultStock) {
		this.defaultStock = defaultStock;
	}


	@Override
	public int getStock(String category, String itemId) {
		return defaultStock;
	}

}
