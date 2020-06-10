package org.javacream.training.java.people;

import java.util.HashSet;
import java.util.Set;

import org.javacream.training.java.util.Address;

public class PeopleApplication {

	public static void main(String[] args) {
		new PeopleApplication();
	}
	
	public PeopleApplication() {
		Set<String> firstnames = new HashSet<>();
		firstnames.add("Rainer");
		firstnames.add("Ulrich");
		
		Person sawitzki = new Person("Sawitzki", "Rainer", 80.5, 183, new Address("München", "Marienplatz"), firstnames);
		Student einstein = new Student("Einstein", "Albert", 70.5, 166, new Address("München", "Uni"));
		
		System.out.println(sawitzki);
		System.out.println(einstein);
	}
	
	

}
