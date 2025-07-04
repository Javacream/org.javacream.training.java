package org.javacream.oop.shopping;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShoppingTests {

	@Test
	public void testShopping() {
		var item1 = new Item(1l, "Java", "a book about Java", 9.99);
		var item2 = new Item(2l, "The Java Programming Language", "a book about Java", 1.99);
		var item3 = new Item(3l, "Eg", "foo", 39.99);
		var item4 = new Item(4l, "Al", "goo", 29.99);
		var item5 = new Item(5l, "Python for Beginners", "a book about Python", 99.99);
		var shop = new Shop("a simple shop", item1, item2, item3, item4, item5);
		var basket = new Basket();
		var customer = new Customer("Sawitzki", "Rainer", basket);
		var javaBooks = shop.search("Java");
		customer.basket().itemList().add(javaBooks.get(0));
		var pythonBook = shop.search(5l);
		customer.basket().itemList().add(pythonBook);
		
		Assertions.assertEquals(5, shop.getItems().size());
		Assertions.assertEquals(2, customer.basket().itemList().size());
		
	}
}
