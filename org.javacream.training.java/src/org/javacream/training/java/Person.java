package org.javacream.training.java;
public class Person {

	public Person(String lastname, String firstname, Double weight, Integer height) {
		super();
		this.lastname = lastname;
		this.firstname = firstname;
		this.weight = weight;
		this.height = height;
	}


	String lastname;
	String firstname;
	Double weight;
	Integer height;
	Person partner;
	
	
	public void sayHello() {
		String message = "Hello, my name is "  + this.lastname;
		if (this.partner != null) {
			message = message + ", i am married with " + this.partner.lastname;
		}
		System.out.println(message);
	}
	
	public void marry(Person newPartner) {
		if (newPartner != this && newPartner.partner == null && this.partner == null) {
			this.partner = newPartner;
			newPartner.partner = this;
		}else {
			throw new IllegalArgumentException("marriage not possible!");
		}
	}

	public void divorce() {
		if (this.partner != null) {
			this.partner.partner = null;
			this.partner = null;
		}else {
			throw new IllegalArgumentException("divorce not possible!");
		}
	}

}
