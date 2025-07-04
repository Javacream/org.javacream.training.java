package org.javacream.oop.interfaces;

public interface Instrument {

	public String play();
	
	default public String playLoudly() {
		return play().toUpperCase();
	}
	
	default public String playQuietly() {
		return play().toLowerCase();
	}
	
}
