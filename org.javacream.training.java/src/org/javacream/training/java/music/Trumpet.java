package org.javacream.training.java.music;

public class Trumpet extends Instrument {

	public Trumpet() {
		super("trumpet");
	}

	public String playTrumpet() {
		return "trara";
	}

	@Override
	public String makeSound() {
		return playTrumpet();
	}
	
	

}
