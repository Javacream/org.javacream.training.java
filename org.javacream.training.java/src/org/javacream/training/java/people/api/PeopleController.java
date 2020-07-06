package org.javacream.training.java.people.api;

import java.util.Set;

import org.javacream.training.java.util.Address;

public interface PeopleController {

	Integer create(String lastname, String firstname, Double weight, Integer height, Address address);
	Person findById(Integer id);
	Set<Person> findByLastname(String lastname);
	void deleteById(Integer id);
	void updateWeight(Integer id, Double newWeight);
	void updateLastname(Integer id, String newLastname);
	void updateHeight(Integer id, Integer newHeight);
	void save();
	void load();
}
