package org.javacream.training.java.oop.orchester;
//new Instrument() -> Compiler-Fehler
public abstract class Instrument
{

	private String description;
	
	public Instrument(String description) {
		this.description = description;
	}
	public String playSound() {
		return description + " plays: " + makeSound();
	}
	public abstract String makeSound();
}
