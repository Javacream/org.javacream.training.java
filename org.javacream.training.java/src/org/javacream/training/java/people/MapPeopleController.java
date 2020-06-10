package org.javacream.training.java.people;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.javacream.training.java.util.Address;

public class MapPeopleController implements PeopleController {

	private Map<Integer, Person> people;
	
	{
		people = new HashMap<>();
	}
	@Override
	public Integer create(String lastname, String firstname, Double weight, Integer height, Address address) {
		Person newPerson = new Person(lastname, firstname, weight, height, address);
		Integer id = Person.getCounter();
		people.put(id, newPerson);
		return id;
	}

	@Override
	public Person findById(Integer id) {
		return people.get(id);
	}

	@Override
	public Set<Person> findByLastname(String lastname) {
		Set<Person> result = new HashSet<>();
		for (Person p: people.values()) {
			if (p.getLastname().equals(lastname)) {
				result.add(p);
			}
		}
		return result;
	}

	@Override
	public void deleteById(Integer id) {
		people.remove(id);
	}

	@Override
	public void updateWeight(Integer id, Double newWeight) {
		Person toUpdate = findById(id);
		if (toUpdate != null) {
			toUpdate.setWeight(newWeight);
		}

	}

	@Override
	public void updateLastname(Integer id, String newLastname) {
		Person toUpdate = findById(id);
		if (toUpdate != null) {
			toUpdate.setLastname(newLastname);
		}
	}

	@Override
	public void updateHeight(Integer id, Integer newHeight) {
		Person toUpdate = findById(id);
		if (toUpdate != null) {
			toUpdate.setHeight(newHeight);
		}

	}

}
