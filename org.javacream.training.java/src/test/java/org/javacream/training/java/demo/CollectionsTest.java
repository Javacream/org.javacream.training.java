package org.javacream.training.java.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.javacream.training.java.publishing.Book;
import org.junit.Assert;
import org.junit.Test;

public class CollectionsTest {

	private Book b1 = new Book("ISBN1", "TITLE1");
	private Book b2 = new Book("ISBN2", "TITLE2");
	private Book b3 = new Book("ISBN3", "TITLE3");
	private Book b4 = new Book("ISBN1", "TITLE1");

	@Test
	public void testListWithStrings() {
		ArrayList<String> list = new ArrayList<>();
		list.add("Hugo");
		list.add("Emil");
		list.add("Fritz");
		list.add("Hugo");
		
//		for (String s: list) {
//			System.out.println(s);
//		}
		Assert.assertEquals("Emil", list.get(1));
		Assert.assertEquals(4, list.size());
		
	}
	@Test
	public void testSetWithStrings() {
		HashSet<String> set = new HashSet<>();
		set.add("Hugo");
		set.add("Emil");
		set.add("Fritz");
		set.add("Hugo");
		
//		for (String s: set) {
//			System.out.println(s);
//		}
		//Assert.assertEquals("Emil", set.get(1)); Ein Set hat keine innere Ordnung
		Assert.assertEquals(3, set.size()); //set detects duplicates!
		
	}

	@Test
	public void testMapWithStringsAndInteger() {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("Hugo", 81373);
		map.put("Emil", 30010);
		map.put("Fritz", 40010);
		map.put("Hugo", 70111);
		
//		for (String  key: map.keySet()) {
//			System.out.println(key + "=" + map.get(key));
//		}
		//Assert.assertEquals("Emil", set.get(1)); Ein Set hat keine innere Ordnung
		Assert.assertEquals(3, map.size()); //set detects duplicates!
		
	}

	
	
	@Test
	public void testListWithBooks() {
		ArrayList<Book> list = new ArrayList<>();
		list.add(b1);
		list.add(b2);
		list.add(b3);
		list.add(b4);
		
//		for (String s: list) {
//			System.out.println(s);
//		}
		Assert.assertEquals("ISBN2", list.get(1).getIsbn());
		Assert.assertEquals(4, list.size());
		
	}
	@Test
	public void testSetWithBooks() {
		HashSet<Book> set = new HashSet<>();
		set.add(b1);
		set.add(b2);
		set.add(b3);
		set.add(b4);
		
//		for (String s: set) {
//			System.out.println(s);
//		}
		//Assert.assertEquals("Emil", set.get(1)); Ein Set hat keine innere Ordnung
		Assert.assertEquals(3, set.size()); //set detects duplicates!
		
	}

	@Test
	public void testMapWithBooksAndInteger() {
		HashMap<Book, Integer> map = new HashMap<>();
		map.put(b1, 100);
		map.put(b2, 2);
		map.put(b3, 1000);
		map.put(b4, 102);
		
//		for (String  key: map.keySet()) {
//			System.out.println(key + "=" + map.get(key));
//		}
		//Assert.assertEquals("Emil", set.get(1)); Ein Set hat keine innere Ordnung
		Assert.assertEquals(3, map.size()); //set detects duplicates!
		
	}

	
}
