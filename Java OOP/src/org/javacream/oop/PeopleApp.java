package org.javacream.oop;

public class PeopleApp {

	public static void main(String[] args) {
		var person1 = new Person("Sawitzki", "Rainer", 183);
		person1.setWeight(76.6);
		var person2 = new Person("Musterperson", "Hannah", 198);
		person2.setWeight(79.6);
		
		var address1 = new Address("München", "Marienplatz");
		var address2 = new Address("Berlin", "Alexanderplatz");
		
		System.out.println(person1.greet());
		System.out.println(person2.info());
		System.out.println("done");

	}

}
