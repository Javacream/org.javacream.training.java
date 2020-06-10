package org.javacream.training.java.people;

import org.javacream.training.java.util.Address;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PeopleTest {

	private PeopleController peopleController;

	@Before
	public void before() {
		peopleController = new MapPeopleController();
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

	@Test
	public void searchByLastnameIsOk() {
		peopleController.create("Sawitzki", "Klaus", 70.5, 181, new Address("München", "Stachus"));
		peopleController.create("Sawitzki", "Rainer", 80.5, 183, new Address("München", "Marienplatz"));
		Assert.assertTrue(2 == peopleController.findByLastname("Sawitzki").size());
		
	}
	@Test
	public void deleteByIdIsOk() {
		Integer idForSawitzkiKlaus = peopleController.create("Sawitzki", "Klaus", 70.5, 181, new Address("München", "Stachus"));
		peopleController.create("Sawitzki", "Rainer", 80.5, 183, new Address("München", "Marienplatz"));
		peopleController.deleteById(idForSawitzkiKlaus);
		Assert.assertTrue(1 == peopleController.findByLastname("Sawitzki").size());
		
	}
}
