package org.javacream.training.java.people.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.javacream.training.java.util.Address;

public interface PeopleController {
	void addPersonBuilder(Set<String> key, PersonBuilder builder);
	default Integer create(String lastname, String firstname, Double weight, Integer height, Address address) {
		return create(lastname, firstname, weight, height, address, new HashMap<String, Object>());
	}

	Integer create(String lastname, String firstname, Double weight, Integer height, Address address,
			Map<String, Object> options);

	Person findById(Integer id);

	Stream<Person> findAll();

	default Set<Person> findByLastname(String lastname) {
		return findAll().filter(person -> person.getLastname().equals(lastname)).collect(Collectors.toSet());
	}

	default Set<Person> findHeigherThan(int minHeight) {
		return findAll().filter(person -> person.getHeight() >= minHeight).collect(Collectors.toSet());
	}

	default Set<Person> findByHeigherInterval(int minHeight, int maxHeight) {
		return findAll().filter(person -> person.getHeight() >= minHeight).collect(Collectors.toSet());
	}

	void deleteById(Integer id);

	void updateWeight(Integer id, Double newWeight);

	void updateLastname(Integer id, String newLastname);

	void updateHeight(Integer id, Integer newHeight);

	void save();

	void load();
	
	@FunctionalInterface
	interface PersonBuilder {
		Person create(String lastname, String firstname, Double weight, Integer height, Address address,
				Map<String, Object> options);
	}

	class PlainPersonBuilder implements PersonBuilder {

		@Override
		public Person create(String lastname, String firstname, Double weight, Integer height, Address address,
				Map<String, Object> options) {
			Person newPerson = new Person(lastname, firstname, weight, height, address);
			return newPerson;
		}

	}
}
