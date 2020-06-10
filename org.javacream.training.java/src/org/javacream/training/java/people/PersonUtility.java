package org.javacream.training.java.people;

import java.util.StringTokenizer;

import org.javacream.training.java.util.Address;

public abstract class PersonUtility {

	public static String encode(Person person) {
		// lastname,firstname,height,weight,gender,city,street
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(person.getLastname()).append(",");
		stringBuilder.append(person.getFirstname()).append(",");
		stringBuilder.append(person.getHeight()).append(",");
		stringBuilder.append(person.getWeight()).append(",");
		GeneticGender gender = person.getGender();
		switch (gender) {
		case MALE: {
			stringBuilder.append("m").append(",");
			break;
		}
		case FEMALE: {
			stringBuilder.append("f").append(",");
			break;
		}
		case TRANS: {
			stringBuilder.append("t").append(",");
			break;
		}
		case UNKNOWN: {
			stringBuilder.append("u").append(",");
			break;
		}
		}
		Address address = person.getAddress();
		if (address != null) {
			stringBuilder.append(person.getAddress().getCity()).append(",");
			stringBuilder.append(person.getAddress().getStreet());
		} else {
			stringBuilder.append(",");
		}

		return stringBuilder.toString();
	}

	public static Person decode(String csv) {
		StringTokenizer stringTokenizer = new StringTokenizer(csv, ",");
		String lastname = stringTokenizer.nextToken();
		String firstname = stringTokenizer.nextToken();
		String heightAsString = stringTokenizer.nextToken();
		Integer height = Integer.parseInt(heightAsString);
		String weightAsString = stringTokenizer.nextToken();
		Double weight = Double.parseDouble(weightAsString);
		String genderAsString = stringTokenizer.nextToken();
		GeneticGender gender = GeneticGender.UNKNOWN;
		if ("u".equals(genderAsString)) {
			gender = GeneticGender.UNKNOWN;
		} else if ("t".equals(genderAsString)) {
			gender = GeneticGender.TRANS;
		} else if ("f".equals(genderAsString)) {
			gender = GeneticGender.FEMALE;
		} else if ("m".equals(genderAsString)) {
			gender = GeneticGender.MALE;
		}
		String city = stringTokenizer.nextToken();
		String street = stringTokenizer.nextToken();
		return new Person(lastname, firstname, weight, height, gender, new Address(city, street));
	}

}
