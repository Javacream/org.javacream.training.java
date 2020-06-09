package org.javacream.training.java;

/**
 * This class is a simple abstraction of a person
 * 
 * @author Rainer Sawitzki
 *
 */
public class Person {

	public Person(String lastname, String firstname, Double weight, Integer height, Address address) {
		super();
		this.lastname = lastname;
		this.firstname = firstname;
		this.weight = weight;
		this.height = height;
		this.address = address;
		//counter = counter + 1; //or
		counter +=1; //or
		//counter++;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Address getAddress() {
		return address;
	}

	public String getFirstname() {
		return firstname;
	}

	public Person getPartner() {
		return partner;
	}

	public static Integer getNumberOfEyes() {
		return NUMBER_OF_EYES;
	}

	public static Integer getCounter() {
		return counter;
	}

	private Address address;
	private String lastname;
	private String firstname;
	private Double weight;
	private Integer height;
	private Person partner;
	private final static Integer NUMBER_OF_EYES = 2;
	private static Integer counter = 0;
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
