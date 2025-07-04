package org.javacream.oop.interfaces;

import java.util.Arrays;
import java.util.List;

public class Orchester {

	private List<Object> instruments;
	public Orchester(Object... instruments) {
		this.instruments = Arrays.asList(instruments);
	}
	
	public void concert() {
		for (Object instrument: this.instruments) {
			System.out.println(instrument);
		}
	}
}
