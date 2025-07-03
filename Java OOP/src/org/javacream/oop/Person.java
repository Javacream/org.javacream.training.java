package org.javacream.oop;

public class Person {
	private String lastname;
	private String firstname;
	private Integer height;
	private Double weight;
	private Address address;
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
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Address getAddress() {
		return address;
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
