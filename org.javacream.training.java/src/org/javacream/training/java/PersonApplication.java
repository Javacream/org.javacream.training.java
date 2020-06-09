package org.javacream.training.java;

public class PersonApplication {

	public static void main(String[] args) {
		try {
			Person sawitzki = new Person("Sawitzki", "Rainer", 80.5, 183);
			Person mustermann = new Person("Mustermann", "Hans", 99.3, 196);
			Person fabricius = new Person("Fabricius", "Carola", 57.5, 176);
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
			System.out.println("Number of eyes: " + Person.NUMBER_OF_EYES);
			System.out.println("Number of created people: " + Person.counter);

		} catch (NullPointerException npe) {
			npe.printStackTrace();
			System.out.println("Detected NullPointerException, possibly a programmer's error");
		}
		
	}

}
