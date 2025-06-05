package org.javacream.java.basics;

import java.nio.file.Files;
import java.nio.file.Path;

public class BmiCalculator {

	public static void main(String[] args) {
		try {
			var pathToPersonFile = Path.of("person.txt");
			var content = Files.readString(pathToPersonFile);
			System.out.println(content);
		}
		catch(Exception e) {
			System.out.println("Error, file person.txt not found or corrupt");
		}
	}

}
