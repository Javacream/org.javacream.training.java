package org.javacream.java.basics;

import java.nio.file.Files;
import java.nio.file.Path;

public class BmiCalculator {

	public static void main(String[] args) {
		try {
			var pathToPersonFile = Path.of("person.txt");
			var content = Files.readString(pathToPersonFile);
			var name = content.substring(0, 20).trim();
			var weightString = content.substring(20, 25);
			var heightString = content.substring(25, 28);
			try {
				var weight = Double.parseDouble(weightString);
				var height = Double.parseDouble(heightString)/100;
				var bmi = weight/(height * height);
				var result = String.format("%s has a bmi of %.2f", name, bmi);
				System.out.println(result);
				try {
					var pathToPersonBmiFile = Path.of("person.bmi.txt");
					Files.writeString(pathToPersonBmiFile, result);
	
				}
				catch(Exception e) {
					System.out.println("Error, cannot write to file person.bmi.txt");
				}
			}
			catch(Exception e) {
				System.out.println(String.format("error converting numbers, height=%s, weight=%s", heightString, weightString));
			}
		}
		catch(Exception e) {
			System.out.println("Error, file person.txt not found or corrupt");
		}
	}
}
