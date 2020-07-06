package org.javacream.training.java.people.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.javacream.training.java.people.api.PeopleController;
import org.javacream.training.java.people.api.Person;
import org.javacream.training.java.util.Address;

public class MapPeopleController implements PeopleController {
	private Path path = Paths.get("/home/rainer/javatraining/people.csv");

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
		return people.values().stream().filter(person -> person.getLastname().equals(lastname)).collect(Collectors.toSet());
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

	@Override
	public void save() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Person p: people.values()) {
			stringBuilder.append(PersonUtility.encode(p)).append("\n");
		}
		try {
			Files.write(path, stringBuilder.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void load() {
		people.clear();
		try {
			List<String> peopleStringList = Files.readAllLines(path);
			Integer counter= 0;
			for (String s: peopleStringList) {
				Person person = PersonUtility.decode(s);
				people.put(counter, person);
				counter++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
