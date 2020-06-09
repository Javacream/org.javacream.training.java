package org.javacream.training.java;

public class AddressApplication {

	public static void main(String[] args) {
		Address address1 = new Address("München", "Marienplatz");
		System.out.println(address1.getCity());
		System.out.println(address1.getStreet());
		address1.setStreet("Statchus");
		System.out.println("done");
		
	}

}
