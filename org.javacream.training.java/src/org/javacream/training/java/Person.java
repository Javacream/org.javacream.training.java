package org.javacream.training.java;

/**
 * This class is a simple abstraction of a person
 * 
 * @author Rainer Sawitzki
 *
 */
public class Person {

	public Person(String lastname, String firstname, Double weight, Integer height) {
		super();
		this.lastname = lastname;
		this.firstname = firstname;
		this.weight = weight;
		this.height = height;
		//counter = counter + 1; //or
		//counter +=counter; //or
		counter++;
	}

	String lastname;
	final String firstname;
	Double weight;
	Integer height;
	Person partner;
	final static Integer NUMBER_OF_EYES = 2;
	static Integer counter = 0;
	/**
	 * sayHello prints a simple message on the system console
	 */
	public void sayHello() {
		String message = "Hello, my name is " + this.lastname;
		if (this.partner != null) {
			message = message + ", i am married with " + this.partner.lastname;
		}
		System.out.println(message);
	}

	public void marry(Person newPartner) throws IllegalArgumentException {
		if (newPartner != null && newPartner != this && newPartner.partner == null && this.partner == null) {
			this.partner = newPartner;
			newPartner.partner = this;
		} else {
			throw new IllegalArgumentException("marriage not possible!");
		}
	}

	public void divorce() throws IllegalArgumentException {
		if (this.partner != null) {
			this.partner.partner = null;
			this.partner = null;
		} else {
			throw new IllegalArgumentException("divorce not possible!");
		}
	}

}
