package org.javacream.training.java.people;

import org.javacream.training.java.people.api.PeopleController;
import org.javacream.training.java.people.impl.MapPeopleController;

public class PeopleLoadApplication {

	public static void main(String[] args) {
		new PeopleLoadApplication();
	}
	
	public PeopleLoadApplication() {
		PeopleController peopleController = new MapPeopleController();
		peopleController.load();
		System.out.println(peopleController.findById(1));
	}
	
	

}
