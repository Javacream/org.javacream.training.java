package org.javacream.training.java.oop.orchester;

public class Orchester
{

	private Instrument[] instruments = {new Guitar(), new Violin(), new Drum(), new Guitar(), new Glockenspiel()};
	
	
	public void concert() {
		for (int i = 0; i < instruments.length; i++) {
			System.out.println(instruments[i].playSound());
		}
	}
	
}
