package org.javacream.training.java.util;

import org.javacream.training.java.people.Person;
import org.javacream.training.java.people.Student;

public class AddressBook {

	public static void main(String[] args) {
		new AddressBook();
	}
	

	public AddressBook() {
		University uni = new University("LMU");
		uni.setAddress(new Address("München", "Uni"));
		Person sawitzki = new Person("Sawitzki", "Rainer", 80.5, 183, new Address("München", "Marienplatz"));
		Student einstein = new Student("Einstein", "Albert", 70.5, 166, new Address("München", "Stachus"), uni);
		printAddress(sawitzki);
		printAddress(einstein);
		printAddress(uni);
	}
	
	
	private void printAddress(AddressProvider address) {
		System.out.println(address.getAddress());
	}

}
