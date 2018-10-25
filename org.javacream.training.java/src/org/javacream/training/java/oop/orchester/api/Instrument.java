package org.javacream.training.java.oop.orchester.api;
//new Instrument() -> Compiler-Fehler

/**
 * An instrument makes a sound
 * @author rainer
 *
 */
public abstract class Instrument
{
	private String description;
	
	public Instrument(String description) {
		this.description = description;
	}
	
	/**
	 * 
	 * @return the instruments sound
	 */
	public String playSound() {
		return description + " plays: " + makeSound();
	}
	
	/**
	 * 
	 * @return the bare sound
	 */
	public abstract String makeSound();
}
