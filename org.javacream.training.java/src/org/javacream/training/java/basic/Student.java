package org.javacream.training.java.basic;

public class Student extends Person
{

	public Student(String lastname, String firstname, Integer height, Character gender, String university)
	{
		super(lastname, firstname, height, gender);
		this.university = university;
	}

	private String university;
	

	public String getUniversity()
	{
		return university;
	}

	public void setUniversity(String university)
	{
		this.university = university;
	}

	@Override
	public String sayHello() {
		String personSayHello = super.sayHello();
		return personSayHello + ", i study at " + this.university;
	}

	
}
