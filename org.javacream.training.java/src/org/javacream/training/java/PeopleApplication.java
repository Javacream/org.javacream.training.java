package org.javacream.training.java;

public class PeopleApplication {

	public static void main(String[] args) {
		Person sawitzki = new Person("Sawitzki", "Rainer", 80.5, 183);
		Person mustermann = new Person("Mustermann", "Hans", 99.3, 176);
		String lastname = sawitzki.lastname;
		System.out.println(lastname);
		lastname = mustermann.lastname;
		System.out.println(lastname);
	}

}
