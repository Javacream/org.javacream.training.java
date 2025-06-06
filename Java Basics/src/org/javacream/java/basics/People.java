package org.javacream.java.basics;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class People {

	public static void main(String[] args) {
		try {
			var pathToPeopleFile = Path.of("people.csv");
			var rowsOfPeople = Files.readAllLines(pathToPeopleFile);
			var people = new ArrayList<HashMap<String, Object>>();
			for (var rowOfPerson: rowsOfPeople) {
				var person_info = rowOfPerson.split(",");
				var name = person_info[0];
				var weight = Double.parseDouble(person_info[1]);
				var height = Integer.parseInt(person_info[2]);
				var person = new HashMap<String, Object>();
				person.put("name", name);
				person.put("weight", weight);
				person.put("height", height);
				people.add(person);
			}
			// Namen der Personen für Gewicht größer 170cm
			var namesOfPeopleTallerThan_170 = new ArrayList<String>();
			for (var person: people) {
				var height = (Integer)person.get("height");
				if (height > 170) {
					var name = (String)person.get("name");
					namesOfPeopleTallerThan_170.add(name);				
				}
			}
			
			System.out.println("done");
		}
		catch(Exception e) {
			System.out.println("error reading input file");
		}
	}

}
