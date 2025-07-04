package org.javacream.oop;

public class Student extends Person {
	private String university;
	public Student(String lastname, String firstname, Integer height, String university) {
		super(lastname, firstname, height);
		this.university = university;
	}
	
	public String study() {
		return this.greet() + ", i study at " + this.university;
	}
	
	public String toString() {
		return "i am a student";
	}

}
