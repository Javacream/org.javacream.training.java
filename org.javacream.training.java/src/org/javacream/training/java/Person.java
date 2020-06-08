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
	Person partner;
	
	
	//Methodennamen: Kleinbuchstaben am Anfang
	public void sayHello() {
		String prefix = "Hello, my name is ";
		System.out.println(prefix + this.lastname);
	}
	
	public Boolean marry(Person newPartner) {
		//TODO: Partner konsistent setzen
		return true;
	}

	public Boolean divorce() {
		//TODO: Partner konsistent auflösen
		return true;
	}

}
