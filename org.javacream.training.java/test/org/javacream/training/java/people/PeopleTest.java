package org.javacream.training.java.people;

import java.util.HashMap;

import org.javacream.training.java.academies.University;
import org.javacream.training.java.people.api.PeopleController;
import org.javacream.training.java.people.api.Person;
import org.javacream.training.java.people.api.Student;
import org.javacream.training.java.util.Address;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PeopleTest {

	private PeopleController peopleController;

	@Before
	public void before() {
		peopleController = PeopleApplicationContext.peopleController();
	}
	
	@Test
	public void createPersonSawitzkiIsOk() {
		Integer idForSawitzkiRainer = peopleController.create("Sawitzki", "Rainer", 80.5, 183, new Address("München", "Marienplatz"));
		Person searchResult = peopleController.findById(idForSawitzkiRainer); 
		Assert.assertEquals("Sawitzki", searchResult.getLastname());
		Assert.assertEquals("Rainer", searchResult.getFirstname());
		Assert.assertTrue(183 == searchResult.getHeight());
		
	}
	@Test
	public void updatePersonSawitzkiIsOk() {
		Integer idForSawitzkiRainer = peopleController.create("Sawitzki", "Rainer", 80.5, 183, new Address("München", "Marienplatz"));
		peopleController.updateWeight(idForSawitzkiRainer, 79.9);
		Person searchResult = peopleController.findById(idForSawitzkiRainer); 
		Assert.assertEquals(79.9, searchResult.getWeight(), 1e-12);
		
	}

	@Test(expected = IllegalArgumentException.class)
	public void updatePersonSawitzkiThrowsException() {
		Integer idForSawitzkiRainer = peopleController.create("Sawitzki", "Rainer", 80.5, 183, new Address("München", "Marienplatz"));
		peopleController.updateLastname(idForSawitzkiRainer, "");
		
	}

	@Test
	public void searchByLastnameIsOk() {
		peopleController.create("Sawitzki", "Klaus", 70.5, 181, new Address("München", "Stachus"));
		peopleController.create("Sawitzki", "Rainer", 80.5, 183, new Address("München", "Marienplatz"));
		Assert.assertTrue(2 == peopleController.findByLastname("Sawitzki").size());
		
	}
	//@Test
	public void deleteByIdIsOk() {
		Integer idForSawitzkiKlaus = peopleController.create("Sawitzki", "Klaus", 70.5, 181, new Address("München", "Stachus"));
		peopleController.create("Sawitzki", "Rainer", 80.5, 183, new Address("München", "Marienplatz"));
		peopleController.deleteById(idForSawitzkiKlaus);
		Assert.assertTrue(1 == peopleController.findByLastname("Sawitzki").size());
		
	}

	@Test
	public void createdStudentSawitzkiWithoutBuilderIsNull() {
		HashMap<String, Object> options = new HashMap<>();
		options.put("university", new University("LMU"));
		Integer idForSawitzkiRainer = peopleController.create("Sawitzki", "Rainer", 80.5, 183, new Address("München", "Marienplatz"), options);
		Assert.assertNull(idForSawitzkiRainer);
		
	}
	@Test
	public void createdStudentSawitzkiWithoutBuilderIsOk() {
		HashMap<String, Object> options = new HashMap<>();
		options.put("university", new University("LMU"));
		peopleController.addPersonBuilder(options.keySet(), (lastname, firstname, weight, height, address,
				studentOptions) -> new Student(lastname, firstname, weight, height, address,
						(University)studentOptions.get("university")));
		
		Integer idForSawitzkiRainer = peopleController.create("Sawitzki", "Rainer", 80.5, 183, new Address("München", "Marienplatz"), options);
		Person searchResult = peopleController.findById(idForSawitzkiRainer); 
		Assert.assertEquals("Sawitzki", searchResult.getLastname());
		Assert.assertEquals("Rainer", searchResult.getFirstname());
		Assert.assertTrue(183 == searchResult.getHeight());
		Assert.assertTrue(searchResult instanceof Student);
		
	}
	
}
