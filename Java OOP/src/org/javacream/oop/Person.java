package org.javacream.oop;

import java.util.HashSet;

public class Person extends Object{
	private static Integer peopleCounter = 0;
	private String lastname;
	private String firstname;
	private Integer height;
	private Double weight;
	private HashSet<Address> addresses;
	public String greet(){
		return "Hello, my name is " + this.firstname + " " + this.lastname;
	}
	public String info(){
		return "Person(lastname=" + this.lastname + ", firstname=" + this.firstname + ", height=" + this.height + ")";
	}
	public Person(String lastname, String firstname, Integer height) {
		this.lastname = lastname;
		this.firstname = firstname;
		this.height = height;
		this.addresses = new HashSet<Address>();
		Person.peopleCounter++;
	}
	
	
	public static Integer getPeopleCounter() {
		return peopleCounter;
	}
	public HashSet<Address> getAddresses() {
		return addresses;
	}
	
	public void addAddress(Address address) {
		this.addresses.add(address);
	}
	public void removeAddress(Address address) {
		this.addresses.remove(address);
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public String getFirstname() {
		return firstname;
	}

}
