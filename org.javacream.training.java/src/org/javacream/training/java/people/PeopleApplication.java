package org.javacream.training.java.people;

import org.javacream.training.java.util.Address;

public class PeopleApplication {

	public static void main(String[] args) {
		new PeopleApplication();
	}
	
	public PeopleApplication() {
		PeopleController peopleController = new MapPeopleController();
		Integer idForSawitzkiRainer = peopleController.create("Sawitzki", "Rainer", 80.5, 183, new Address("München", "Marienplatz"));
		peopleController.create("Einstein", "Albert", 70.5, 166, new Address("München", "Uni"));
		Integer idForSawitzkiKlaus = peopleController.create("Sawitzki", "Klaus", 70.5, 181, new Address("München", "Stachus"));
		
		System.out.println(peopleController.findById(idForSawitzkiRainer));
		System.out.println(peopleController.findByLastname("Sawitzki"));
		peopleController.updateWeight(idForSawitzkiRainer, 79.9);
		System.out.println(peopleController.findById(idForSawitzkiRainer));
		peopleController.updateWeight(idForSawitzkiRainer, 79.9);
		peopleController.deleteById(idForSawitzkiKlaus);
		System.out.println(peopleController.findByLastname("Sawitzki"));
		
		peopleController.save();
		peopleController.load();
	}
	
	

}
