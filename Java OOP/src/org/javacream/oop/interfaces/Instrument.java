package org.javacream.oop.interfaces;

public abstract class Instrument {

	public abstract String play();
	
	public String playLoudly() {
		return play().toUpperCase();
	}
	
	public String playQuietly() {
		return play().toLowerCase();
	}
	
}
