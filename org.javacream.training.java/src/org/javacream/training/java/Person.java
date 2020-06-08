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
	
	public Boolean marry(Person newPartner) {
		if (newPartner != this && newPartner != null && newPartner.partner == null && this.partner == null) {
			this.partner = newPartner;
			newPartner.partner = this;
			return true;
		}else {
			System.out.println("marriage not possible!");
			return false;
		}
	}

	public Boolean divorce() {
		if (this.partner != null) {
			this.partner.partner = null;
			this.partner = null;
			return true;
		}else {
			return false;
		}
	}

}
