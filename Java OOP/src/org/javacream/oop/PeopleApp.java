package org.javacream.oop;

public class PeopleApp {

	public static void main(String[] args) {
		var person1 = new Person("Sawitzki", "Rainer", 183);
		person1.weight = 76.6;
		var person2 = new Person("Musterperson", "Hannah", 198);
		person2.weight = 79.6;
		
		var address1 = new Address("München", "Marienplatz");
		var address2 = new Address("Berlin", "Alexanderplatz");
		
		System.out.println("done");

	}

}
