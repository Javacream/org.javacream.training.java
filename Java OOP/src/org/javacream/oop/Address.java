package org.javacream.oop;


public record Address(String city, String street) {
	public Address (String street) {
		this("München", street);
	}
	public String info() {
		return "Address(city=" + this.city + ", street=" + this.street + ")"; 
	}
}

