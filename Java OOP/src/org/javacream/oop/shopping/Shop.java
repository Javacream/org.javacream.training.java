package org.javacream.oop.shopping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shop {
	private Map<Long, Item> items;
	private String name;
	public Map<Long, Item> getItems() {
		return items;
	}

	public String getName() {
		return name;
	}

	public Shop(String name, Item...items ) {
		this.name = name;
		this.items = new HashMap<>();
		for (var item: items) {
			this.items.put(item.id(), item);
		}
	}
	
	public Item search(Long id) {
		return this.items.get(id);
	}
	
	public List<Item> search(String name){
		return items.values().stream().filter(i -> i.name().contains(name)).toList();
	}
	
	public List<Item> allItems() {
		return new ArrayList<>(this.items.values());
	}
	
	
}
