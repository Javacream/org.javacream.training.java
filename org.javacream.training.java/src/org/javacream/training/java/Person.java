package org.javacream.training.java;
//Classname: Beginnt mit Großbuchstaben, Camel-case
public class Person {

	public Person(String lastname, String firstname, Double weight, Integer height) {
		super();
		this.lastname = lastname;
		this.firstname = firstname;
		this.weight = weight;
		this.height = height;
	}


	//Attributnamen: Kleinbuchstaben am Anfang
	String lastname;
	String firstname;
	Double weight;
	Integer height;
	
	
	//Methodennamen: Kleinbuchstaben am Anfang
	public void sayHello() {
		System.out.println("Hello");
	}


}
