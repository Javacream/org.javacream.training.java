package org.javacream.oop.interfaces;

import java.util.Arrays;
import java.util.List;

public class Orchester {

	private List<Instrument> instruments;
	public Orchester(Instrument... instruments) {
		this.instruments = Arrays.asList(instruments);
	}
	
	public void concert() {
		for (Object instrument: this.instruments) {
			System.out.println(instrument);
		}
	}
}
