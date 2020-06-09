package org.javacream.training.java;

public class Orchester {

	public static void main(String[] args) {
		new Orchester().play();
	}

	private void play() {
		//Instrument i1 = new Instrument("an instrument");
		Guitar g = new Guitar();
		Violin v = new Violin();
		Trumpet t = new Trumpet();
		//playInstrument(i1);
		playInstrument(g);
		playInstrument(v);
		playInstrument(t);
		
		
	}
	
	private void playInstrument(Instrument i) {
		System.out.println(i.getDescription() + ": " + i.makeSound());
		
	}

}
