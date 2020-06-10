package org.javacream.training.java.people;

import java.util.StringTokenizer;

public abstract class PersonUtility {

	public static String encode(Person person) {
		// lastname,firstname,height,weight,city,street
		StringBuilder stringBuilder = new StringBuilder();
		// TODO stringBuilder.append();
		return stringBuilder.toString();
	}

	public static Person decode(String csv) {
		StringTokenizer stringTokenizer = new StringTokenizer(csv, ",");
		String lastname = stringTokenizer.nextToken();
		// TODO
		String heightAsString = stringTokenizer.nextToken();
		Integer height = Integer.parseInt(heightAsString);
		return null;
	}

}
