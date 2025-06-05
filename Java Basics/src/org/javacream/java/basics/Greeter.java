package org.javacream.java.basics;

import java.util.Scanner;

public class Greeter {

	public static void main(String[] args) {
		var consoleInput = new Scanner(System.in);
		System.out.print("Enter your lastname: ");
		var lastname = consoleInput.nextLine();
		System.out.print("Enter your firstname: ");
		var firstname = consoleInput.nextLine();
		System.out.print("Friendly greeting (y|n): ");
		var friendly = consoleInput.nextLine();
		consoleInput.close();
		var greeting = "";
		var compareString = "y";
		if (friendly.equals(compareString)) { // Warum funktioniert hier == nicht?
			greeting = String.format("Hello %s %s!", firstname, lastname);
		}
		else {
			greeting = String.format("Good day %s", lastname);
		}
		java.lang.System.out.println(greeting);
	}

}
