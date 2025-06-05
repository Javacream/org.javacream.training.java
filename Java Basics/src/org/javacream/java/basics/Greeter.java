package org.javacream.java.basics;

public class Greeter {

	public static void main(String[] args) {
		var lastname = "Sawitzki";
		var firstname = "Rainer";
		var friendly = false;
		var greeting = "";
		if (friendly) {
			greeting = "Hello " + firstname + " " + lastname;
		}
		else {
			greeting = "Good day " + lastname;
		}
		System.out.println(greeting);
	}

}
