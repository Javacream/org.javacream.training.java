package org.javacream.training.java;

public abstract class Instrument {

	private String description;

	public Instrument(String description) {
		super();
		this.description = description;
	}
	
	public abstract String makeSound();

	public String getDescription() {
		return description;
	}
}
