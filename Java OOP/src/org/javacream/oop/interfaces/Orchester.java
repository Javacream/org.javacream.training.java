package org.javacream.oop.interfaces;

import java.util.Arrays;
import java.util.List;

public class Orchester {

	private List<Instrument> instruments;
	public Orchester(Instrument... instruments) {
		this.instruments = Arrays.asList(instruments);
	}
	
	public void concert(Volume volume) {
		for (Instrument instrument: this.instruments) {
			switch (volume){
				case Volume.NORMAL:{
					System.out.println(instrument.play());
					break;
				}
				case Volume.LOUD:{
					System.out.println(instrument.playLoudly());
					break;
				}
				case Volume.QUIET:{
					System.out.println(instrument.playQuietly());
					break;
				}

			}
		}
	}
}
