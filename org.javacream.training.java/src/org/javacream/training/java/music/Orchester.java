package org.javacream.training.java.music;

import java.util.ArrayList;
import java.util.List;

import org.javacream.training.java.util.Address;
import org.javacream.training.java.util.AddressProvider;

public class Orchester implements AddressProvider {
	private List<Instrument> instruments = new ArrayList<>();

	public static void main(String[] args) {
		new Orchester().play();
	}

	private void play() {
		instruments.add(new Guitar());
		instruments.add(new Violin());
		instruments.add(new Trumpet());
		playConcert();
	}

	private void playConcert() {
		for (Instrument i : instruments) {
			System.out.println(i.getDescription() + ": " + i.makeSound());
		}
	}

	@Override
	public Address getAddress() {
		return new Address("Eg", "Al");
	}

}
