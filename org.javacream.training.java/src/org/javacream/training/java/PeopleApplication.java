package org.javacream.training.java;

public class PeopleApplication {

	public static void main(String[] args) {
		Person sawitzki = new Person("Sawitzki", "Rainer", 80.5, 183);
		Person mustermann = new Person("Mustermann", "Hans", 99.3, 196);
		Person fabricius = new Person("Fabricius", "Carola", 57.5, 176);
		System.out.println(mustermann.marry(fabricius));
		sawitzki.sayHello();
		fabricius.sayHello();
		mustermann.sayHello();
		System.out.println(sawitzki.marry(fabricius));
		fabricius.divorce();
		fabricius.marry(sawitzki);
		sawitzki.sayHello();
		fabricius.sayHello();
		mustermann.sayHello();
	}

}
