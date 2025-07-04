package org.javacream.oop.shopping;

import java.util.ArrayList;
import java.util.List;

public class Basket {
	private List<Item> items;
	public Basket() {
		items = new ArrayList<>();
	}
	
	public List<Item> itemList(){
		return items;
	}

	@Override
	public String toString() {
		return "Basket [items=" + items + "]";
	}
}
