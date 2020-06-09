package org.javacream.training.java;

public class PeopleApplication {

	public static void main(String[] args) {
		new PeopleApplication();
	}
	
	public PeopleApplication() {
		Person sawitzki = new Person("Sawitzki", "Rainer", 80.5, 183, new Address("München", "Marienplatz"));
		Student einstein = new Student("Einstein", "Albert", 70.5, 166, new Address("München", "Uni"));
		
//		sawitzki.sayHello();
//		einstein.sayHello();
		personSayHello(sawitzki);
		personSayHello(einstein);
	}
	
	
	private void personSayHello(Person p) {
		p.sayHello();
	}

}
