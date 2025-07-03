package org.javacream.oop;

public class Person {
	String lastname;
	String firstname;
	Integer height;
	Double weight;
	String greet(){
		return "Hello!";
	}
	String info(){
		return "I am a person";
	}
	
	Person(String lastname, String firstname, Integer height){
		this.lastname = lastname;
		this.firstname = firstname;
		this.height = height;
		
	}

}
