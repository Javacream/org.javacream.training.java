package org.javacream.training.java.people.api;

import org.javacream.training.java.util.Address;

public class Worker extends Person {

	private double salary;
	private String company;

	public Worker(String lastname, String firstname, Double weight, Integer height, Address address, String company, double salary) {
		super(lastname, firstname, weight, height, address);
		this.company= company;
		this.salary= salary;
	}
	

}
