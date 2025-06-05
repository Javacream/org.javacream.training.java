package org.javacream.java.basics;

import java.util.Scanner;

public class PersonExample {

	public static void main(String[] args) {
		var scanner = new Scanner(System.in);
		System.out.print("enter your name: ");
		var name = scanner.nextLine();
		System.out.print("enter your weight: ");
		var weight = scanner.nextLine();
		System.out.print("enter your height: ");
		var height = scanner.nextLine();
		System.out.println(String.format("%s has a weight of %s and a height of %s", name, weight, height));
		scanner.close();
	}

}
