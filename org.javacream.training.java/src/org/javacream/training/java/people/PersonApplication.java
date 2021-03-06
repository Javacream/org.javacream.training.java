package org.javacream.training.java.people;

import org.javacream.training.java.people.api.Person;
import org.javacream.training.java.people.api.Student;
import org.javacream.training.java.util.Address;

public class PersonApplication {

	public static void main(String[] args) {
		try {
			Student sawitzki = new Student("Sawitzki", "Rainer", 80.5, 183, new Address("München", "Marienplatz"));
			Person mustermann = new Person("Mustermann", "Hans", 99.3, 196, new Address("Irgend", "Wo"));
			Person fabricius = new Person("Fabricius", "Carola", 57.5, 176, new Address("München", "Stachus"));
			try {
				mustermann.marry(fabricius);
				sawitzki.sayHello();
				fabricius.sayHello();
				mustermann.sayHello();
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			try {
				sawitzki.marry(fabricius);
				sawitzki.sayHello();
				fabricius.sayHello();
				mustermann.sayHello();
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			fabricius.divorce();
			try {
				fabricius.marry(sawitzki);
				sawitzki.sayHello();
				fabricius.sayHello();
				mustermann.sayHello();
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			try {
				mustermann.marry(mustermann);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}

			try {
				mustermann.marry(null);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("Number of eyes: " + Person.getNumberOfEyes());
			System.out.println("Number of created people: " + Person.getCounter());

		} catch (NullPointerException npe) {
			npe.printStackTrace();
			System.out.println("Detected NullPointerException, possibly a programmer's error");
		}
		
	}

}
