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

	@Override
	public String toString() {
		return "Student [university=" + university + ", toString()=" + super.toString() + "]";
	}
	


}
