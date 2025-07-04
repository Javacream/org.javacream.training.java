package org.javacream.oop.interfaces;

public class MusicApp {

	public static void main(String[] args) {
		var drum = new Drum();
		var guitar1= new Guitar();
		var guitar2 = new Guitar();
		var piano = new Piano();
		var instrument = new Instrument();
		var orchester = new Orchester(drum, guitar1, piano, guitar2, instrument);
		orchester.concert();
	}

}
