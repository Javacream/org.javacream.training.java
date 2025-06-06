package org.javacream.java.basics;

import java.util.Scanner;

public class PersonExample {

	public static void main(String[] args) {
		while (true) {
			var scanner = new Scanner(System.in);
			System.out.print("enter your name: ");
			var name = scanner.nextLine();
			System.out.print("enter your weight: ");
			var weightString = scanner.nextLine();
			try {
				var weight = Double.parseDouble(weightString);
				System.out.print("enter your height: ");
				var heightString = scanner.nextLine();
				try {
					var height = Integer.parseInt(heightString);
					System.out
							.println(String.format("%s has a weight of %.2f and a height of %d", name, weight, height));
					weight += 1;
					height -= 1;
					System.out
							.println(String.format("%s has a weight of %.2f and a height of %d", name, weight, height));

				} catch (Exception e) {
					System.out.println("the height input is invalid, not a number: " + heightString);
					e.printStackTrace();
				}
			} catch (Exception e) {
				System.out.println("the weight input is invalid, not a number: " + weightString);
				e.printStackTrace();
			}
			System.out.println("again? for exit type 'x'");
			var again = scanner.nextLine();
			if (again.equals("x")) {
				scanner.close();
				break;
			}
		}
	}
}
