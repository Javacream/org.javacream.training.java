package org.javacream.training.java.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.javacream.training.java.people.Person;
import org.javacream.training.java.util.Address;

public class CollectionsDemo {

	public static void main(String[] args) {
		new CollectionsDemo();

	}

	public CollectionsDemo() {
		listDemo();
		setDemo();
		mapDemo();
	}

	private void listDemo() {
		List<Person> people = new ArrayList<>();
		List<Address> addresses = new ArrayList<>();

		Address munich = new Address("München", "Marienplatz");
		Address berlin = new Address("Berlin", "Alexanderplatz");
		Address munich2 = new Address("München", "Marienplatz");

		Person sawitzki = new Person("Sawitzki", "Rainer", 80.5, 183, munich);
		Person sawitzki2 = new Person("Sawitzki", "Rainer", 80.5, 183, munich);
		Person mustermann = new Person("Mustermann", "Hans", 80.5, 183, berlin);

		people.add(sawitzki);
		people.add(sawitzki2);
		people.add(mustermann);
		people.add(sawitzki);

		addresses.add(munich);
		addresses.add(munich2);
		addresses.add(berlin);
		addresses.add(munich);

		// for Person p in people
		for (Person p : people) {
			System.out.println(p);
		}
		for (Address a : addresses) {
			System.out.println(a);
		}

		System.out.println(people.get(1));
		System.out.println(people.size());
		System.out.println(addresses.size());

	}

	private void setDemo() {
		Set<Person> people = new HashSet<>();
		Set<Address> addresses = new HashSet<>();

		Address munich = new Address("München", "Marienplatz");
		Address berlin = new Address("Berlin", "Alexanderplatz");
		Address munich2 = new Address("München", "Marienplatz");

		Person sawitzki = new Person("Sawitzki", "Rainer", 80.5, 183, munich);
		Person sawitzki2 = new Person("Sawitzki", "Rainer", 80.5, 183, munich);
		Person mustermann = new Person("Mustermann", "Hans", 80.5, 183, berlin);

		people.add(sawitzki);
		people.add(sawitzki2);
		people.add(mustermann);
		people.add(sawitzki);

		addresses.add(munich);
		addresses.add(munich2);
		addresses.add(berlin);
		addresses.add(munich);

		// for Person p in people
		for (Person p : people) {
			System.out.println(p);
		}
		for (Address a : addresses) {
			System.out.println(a);
		}

		// System.out.println(people.get(1));
		System.out.println(people.size());
		System.out.println(addresses.size());

	}

	private void mapDemo() {
		Map<Integer, Person> people = new HashMap<>();
		Address munich = new Address("München", "Marienplatz");
		Address berlin = new Address("Berlin", "Alexanderplatz");

		Person sawitzki = new Person("Sawitzki", "Rainer", 80.5, 183, munich);
		people.put(Person.getCounter(), sawitzki);

		Person sawitzki2 = new Person("Sawitzki", "Rainer", 80.5, 183, munich);
		people.put(Person.getCounter(), sawitzki2);

		Person mustermann = new Person("Mustermann", "Hans", 80.5, 183, berlin);
		people.put(Person.getCounter(), mustermann);

		// for Person p in people
		for (Integer i : people.keySet()) {
			System.out.println(i + "=" + people.get(i));
		}
		System.out.println(people.size());

	}
}
