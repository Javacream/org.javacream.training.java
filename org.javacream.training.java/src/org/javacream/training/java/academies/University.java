package org.javacream.training.java.academies;

import org.javacream.training.java.util.Address;
import org.javacream.training.java.util.AddressProvider;

public class University  implements AddressProvider{
	private String name;
	private Address address;
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setName(String name) {
		this.name = name;
	}

	public University(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "University [name=" + name + "]";
	}

}
