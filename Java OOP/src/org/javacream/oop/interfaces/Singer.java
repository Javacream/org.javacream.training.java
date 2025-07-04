package org.javacream.oop.interfaces;

import org.javacream.oop.Person;

public class Singer extends Person {

	public Singer(String lastname, String firstname, Integer height) {
		super(lastname, firstname, height);
	}
	
	public String play() {
		return "Trallalero Trallala";
	}

}
