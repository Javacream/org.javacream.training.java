package org.javacream.training.java.people;

import org.javacream.training.java.people.api.PeopleController;
import org.javacream.training.java.people.impl.MapPeopleController;
import org.javacream.training.java.people.impl.ValidatingPeopleController;
import org.javacream.training.java.util.TracingAspect;

public class PeopleApplicationContext {
	
	private static PeopleController peopleController;
	
	static {
		MapPeopleController mapPeopleController = new MapPeopleController();
		ValidatingPeopleController validatingPeopleController = new ValidatingPeopleController();
		validatingPeopleController.setPeopleController(mapPeopleController);
		
		peopleController = TracingAspect.trace(validatingPeopleController);
	}
	public static PeopleController peopleController() {
		return peopleController;
	}

}
