package org.javacream.oop;

public class PeopleApp {

	public static void main(String[] args) {
		var address1 = new Address("München", "Marienplatz");
		var address2 = new Address("Berlin", "Alexanderplatz");
		var address3 = new Address("Berlin", "Alexanderplatz");
		var person1 = new Person("Sawitzki", "Rainer", 183);
		person1.setWeight(76.6);
		var person2 = new Student("Musterperson", "Hannah", 198, "LMU");
		person2.setWeight(79.6);
		person1.addAddress(address1);
		person1.addAddress(address2);
		person1.addAddress(address1);
		person1.addAddress(address3);
		
		System.out.println(person1.greet());
		System.out.println(person2.info());
		System.out.println(person2.study());
		System.out.println(Person.getPeopleCounter());
		System.out.println("done");

	}

}
