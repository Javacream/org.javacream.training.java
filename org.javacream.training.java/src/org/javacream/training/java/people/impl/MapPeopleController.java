package org.javacream.training.java.people.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

import org.javacream.training.java.people.api.PeopleController;
import org.javacream.training.java.people.api.Person;
import org.javacream.training.java.util.Address;

public class MapPeopleController implements PeopleController {
	private Path path = Paths.get("/home/rainer/javatraining/people.csv");

	private Map<Set<String>, PersonBuilder> builders;

	public void addPersonBuilder(Set<String> key, PersonBuilder builder) {
		builders.put(key, builder);
	}

	private Map<Integer, Person> people;

	{
		people = new HashMap<>();
		builders = new HashMap<>();
		builders.put(new HashSet<String>(), new PlainPersonBuilder());
	}

	@Override
	public Integer create(String lastname, String firstname, Double weight, Integer height, Address address,
			Map<String, Object> options) {
		PersonBuilder builder = builders.get(options.keySet());
		if (builder == null) {
			return null;
		}
		Person p = builder.create(lastname, firstname, weight, height, address, options);
		int id = p.getId();
		people.put(id, p);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public Person findById(Integer id) {
		return people.get(id);
	}

	public Stream<Person> findAll() {
		return people.values().stream();
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
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.execute( this::longRunningSave);
		//longRunningSave();
		
		
	}

	private void longRunningSave() {
		System.out.println("Starting longRunningSave at " + new Date());

		StringBuilder stringBuilder = new StringBuilder();
		for (Person p : people.values()) {
			stringBuilder.append(PersonUtility.encode(p)).append("\n");
		}
		try {
			Files.write(path, stringBuilder.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finished longRunningSave at " + new Date());

	}
	
	@Override
	public void load() {
		people.clear();
		try {
			List<String> peopleStringList = Files.readAllLines(path);
			Integer counter = 0;
			for (String s : peopleStringList) {
				Person person = PersonUtility.decode(s);
				people.put(counter, person);
				counter++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
