package org.javacream.oop;

public class PublisherApp {

	public static void main(String[] args) {
		var publisher = new Publisher("Addison-Wesley");
		for (int i = 0; i < 10; i++) {
			var book = new Book("ISBN-" + i, "Title " + i, i, 9.99*i);
			publisher.publish(book);
		}
		System.out.println(publisher.getName());
		System.out.println(publisher.search("ISBN-1"));
		System.out.println(publisher.allBookTitles());
		
	}

}
