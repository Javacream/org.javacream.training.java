package org.javacream.java.basics;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class BmiCalculator {

	public static void main(String[] args) {
		try {
			var pathToPersonFile = Path.of("people.txt");
			var rowsOfPeople = Files.readAllLines(pathToPersonFile);
			var resultList = new ArrayList<String>();
			for (String rowOfPerson:  rowsOfPeople){
				var name = rowOfPerson.substring(0, 20).trim();
				var weightString = rowOfPerson.substring(20, 25);
				var heightString = rowOfPerson.substring(25, 28);
				try {
					var weight = Double.parseDouble(weightString);
					var height = Double.parseDouble(heightString)/100;
					var bmi = weight/(height * height);
					var result = String.format("%s has a bmi of %.2f", name, bmi);
					System.out.println(result);
					resultList.add(result);
				}
				catch(Exception e) {
					System.out.println(String.format("error converting numbers, height=%s, weight=%s", heightString, weightString));
				}
			}
			try {
				var pathToPersonBmiFile = Path.of("people.bmi.txt");
				Files.write(pathToPersonBmiFile, resultList);

			}
			catch(Exception e) {
				System.out.println("Error, cannot write to file person.bmi.txt");
			}

		}
		catch(Exception e) {
			System.out.println("Error, file person.txt not found or corrupt");
		}
	}
}
