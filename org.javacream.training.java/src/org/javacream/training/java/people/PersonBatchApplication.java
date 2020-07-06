package org.javacream.training.java.people;

import java.util.HashMap;
import java.util.HashSet;

import org.javacream.training.java.academies.University;
import org.javacream.training.java.people.api.Student;
import org.javacream.training.java.people.api.Worker;
import org.javacream.training.java.people.impl.MapPeopleController;
import org.javacream.training.java.util.Address;

public class PersonBatchApplication {

	public static void main(String[] args) {
		MapPeopleController peopleController = new MapPeopleController();
		HashSet<String> studentHashSet = new HashSet<>();
		studentHashSet.add("university");
		peopleController.addPersonBuilder(studentHashSet, (lastname, firstname, weight, height, address,
				studentOptions) -> new Student(lastname, firstname, weight, height, address,
						(University)studentOptions.get("university")));

		HashSet<String> workerHashSet = new HashSet<>();
		workerHashSet.add("company");
		workerHashSet.add("salary");
		peopleController.addPersonBuilder(workerHashSet, (lastname, firstname, weight, height, address,
				workerOptions) -> new Worker(lastname, firstname, weight, height, address,
						(String)workerOptions.get("company"), (double)workerOptions.get("salary")));

		
		
		Integer id = peopleController.create("Sawitzki", "Rainer", 79.5, 183, new Address("München", "Marienplatz"));
		System.out.println(peopleController.findById(id).getClass());
		HashMap<String, Object> options = new HashMap<>();
		options.put("university", new University("LMU"));
		id = peopleController.create("Sawitzki", "Rainer", 79.5, 183, new Address("München", "Marienplatz"), options);
		System.out.println(peopleController.findById(id).getClass());

		HashMap<String, Object> workerOptions = new HashMap<>();
		workerOptions.put("company", "Integrata");
		workerOptions.put("salary", 2109.87);
		id = peopleController.create("Sawitzki", "Rainer", 79.5, 183, new Address("München", "Marienplatz"), workerOptions);
		System.out.println(peopleController.findById(id).getClass());

	
	}

}
