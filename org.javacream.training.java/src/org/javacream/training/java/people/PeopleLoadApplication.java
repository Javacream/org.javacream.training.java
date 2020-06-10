package org.javacream.training.java.people;

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
