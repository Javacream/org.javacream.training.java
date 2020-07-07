package org.javacream.training.java.people.impl;

import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import org.javacream.training.java.people.api.PeopleController;
import org.javacream.training.java.people.api.Person;
import org.javacream.training.java.util.Address;

public class ValidatingPeopleController implements PeopleController{
	private PeopleController peopleController;

	public void addPersonBuilder(Set<String> key, PersonBuilder builder) {
		peopleController.addPersonBuilder(key, builder);
	}

	public Integer create(String lastname, String firstname, Double weight, Integer height, Address address,
			Map<String, Object> options) {
		return peopleController.create(lastname, firstname, weight, height, address, options);
	}

	public Person findById(Integer id) {
		return peopleController.findById(id);
	}

	public Stream<Person> findAll() {
		return peopleController.findAll();
	}

	public void deleteById(Integer id) {
		peopleController.deleteById(id);
	}

	public void updateWeight(Integer id, Double newWeight) {
		peopleController.updateWeight(id, newWeight);
	}

	public void updateLastname(Integer id, String newLastname) {
		if (newLastname == null || newLastname.trim().length() == 0) {
			throw new IllegalArgumentException("invalid newLastname");
		}
		peopleController.updateLastname(id, newLastname);
	}

	public void updateHeight(Integer id, Integer newHeight) {
		peopleController.updateHeight(id, newHeight);
	}

	public void save() {
		peopleController.save();
	}

	public void load() {
		peopleController.load();
	}

	public void setPeopleController(PeopleController peopleController) {
		this.peopleController = peopleController;
	}
	

}
