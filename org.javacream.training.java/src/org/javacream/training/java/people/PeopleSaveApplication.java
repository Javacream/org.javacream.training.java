package org.javacream.training.java.people;

import org.javacream.training.java.people.api.PeopleController;
import org.javacream.training.java.people.impl.MapPeopleController;
import org.javacream.training.java.util.Address;

public class PeopleSaveApplication {

	public static void main(String[] args) {
		new PeopleSaveApplication();
	}
	
	public PeopleSaveApplication() {
		PeopleController peopleController = new MapPeopleController();
		Integer idForSawitzkiRainer = peopleController.create("Sawitzki", "Rainer", 80.5, 183, new Address("München", "Marienplatz"));
		peopleController.create("Einstein", "Albert", 70.5, 166, new Address("München", "Uni"));
		Integer idForSawitzkiKlaus = peopleController.create("Sawitzki", "Klaus", 70.5, 181, new Address("München", "Stachus"));
		peopleController.updateWeight(idForSawitzkiRainer, 79.9);
		peopleController.updateWeight(idForSawitzkiRainer, 79.9);
		peopleController.deleteById(idForSawitzkiKlaus);
		peopleController.save();
	}
	
	

}
