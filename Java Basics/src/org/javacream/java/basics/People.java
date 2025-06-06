package org.javacream.java.basics;

import java.nio.file.Files;
import java.nio.file.Path;

public class People {

	public static void main(String[] args) {
		try {
			var pathToPeopleFile = Path.of("people.csv");
			var rowsOfPeople = Files.readAllLines(pathToPeopleFile);
			for (var rowOfPerson: rowsOfPeople) {
				var person_info = rowOfPerson.split(",");
				var name = person_info[0];
				var weight = Double.parseDouble(person_info[1]);
				var height = Integer.parseInt(person_info[2]);
				System.out.println(String.format("Gelesene Person: %s mit einem Gewicht von %.2f und einer Größe von %d", name, weight, height));
			}
			
		}
		catch(Exception e) {
			System.out.println("error reading input file");
		}
	}

}
