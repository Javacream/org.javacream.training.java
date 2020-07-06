package org.javacream.training.java.people.api;

import org.javacream.training.java.academies.University;
import org.javacream.training.java.util.Address;

public class Student extends Person {

	public Student(String lastname, String firstname, Double weight, Integer height, Address address, University university) {
		super(lastname, firstname, weight, height, address);
		this.university = university;
	}

	public Student(String lastname, String firstname, Double weight, Integer height, Address address) {
		super(lastname, firstname, weight, height, address);
	}

	public Student(String lastname, String firstname, Address address, Double weight, Integer height) {
		super(lastname, firstname, weight, height, address);
	}

	public Student(String lastname, String firstname, Address address) {
		super(lastname, firstname, 53.4, 150, address);
	}

	
	private University university;

	public University  getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}
	
	public void study() {
		System.out.println("i am studying at " + this.university);
	}

	@Override
	public void sayHello() {
		System.out.print("I am a student! ");
		super.sayHello();
	}
}
