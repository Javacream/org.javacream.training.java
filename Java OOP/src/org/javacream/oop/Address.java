package org.javacream.oop;

import java.util.Objects;

public class Address {
	private String city;
	private String street;
	
	public Address(String city, String street){
		this.city = city;
		this.street = street;
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, street);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(city, other.city) && Objects.equals(street, other.street);
	}

	public String getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}
}
