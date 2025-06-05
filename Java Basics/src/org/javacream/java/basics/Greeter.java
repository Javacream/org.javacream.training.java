package org.javacream.java.basics;

public class Greeter {

	public static void main(String[] args) {
		var lastname = "Sawitzki";
		var firstname = "Rainer";
		var friendly = true;
		var greeting = "";
		if (friendly) {
			greeting = String.format("Hello %s %s!", firstname, lastname);
		}
		else {
			greeting = String.format("Good day %s", lastname);
		}
		System.out.println(greeting);
	}

}
