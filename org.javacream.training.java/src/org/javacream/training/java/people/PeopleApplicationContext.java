package org.javacream.training.java.people;

import org.javacream.training.java.people.api.PeopleController;
import org.javacream.training.java.people.impl.MapPeopleController;
import org.javacream.training.java.people.impl.ValidatingPeopleController;

public class PeopleApplicationContext {
	
	private static PeopleController peopleController;
	
	static {
		MapPeopleController mapPeopleController = new MapPeopleController();
		ValidatingPeopleController validatingPeopleController = new ValidatingPeopleController();
		validatingPeopleController.setPeopleController(mapPeopleController);
		peopleController = validatingPeopleController;
	}
	public static PeopleController peopleController() {
		return peopleController;
	}

}
