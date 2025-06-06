package org.javacream.java.basics;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class People {

	public static void main(String[] args) {
		try {
			var pathToPeopleFile = Path.of("people.csv");
			var rowsOfPeople = Files.readAllLines(pathToPeopleFile);
			var people = new ArrayList<HashMap<String, Object>>();
			for (var rowOfPerson : rowsOfPeople) {
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
			for (var person : people) {
				var height = (Integer) person.get("height");
				if (height > 170) {
					var name = (String) person.get("name");
					namesOfPeopleTallerThan_170.add(name);
				}
			}
			var heightsOfPeopleHeavierThan_90 = new ArrayList<Integer>();
			for (var person : people) {
				var weight = (Double) person.get("weight");
				if (weight > 90) {
					var height = (Integer) person.get("height");
					heightsOfPeopleHeavierThan_90.add(height);
				}
			}
			var peopleStream = people.stream();
			var filteredPeople = peopleStream.filter(person -> (Integer) person.get("height") <= 170);
			var transformedPeopleNames = filteredPeople.map(person -> (String) person.get("name"));
			var namesOfPeopleSmallerEquals_170 = transformedPeopleNames.collect(Collectors.toList());

			var heightsOfPeopleLighterEquals_90 = people.stream().filter(person -> (Double) person.get("weight") <= 90)
					.map(person -> (Integer) person.get("height")).collect(Collectors.toList());

			System.out.println("done");
		} catch (Exception e) {
			System.out.println("error reading input file");
		}
	}

}
