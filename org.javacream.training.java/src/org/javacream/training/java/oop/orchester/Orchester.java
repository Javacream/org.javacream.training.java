package org.javacream.training.java.oop.orchester;

import java.util.List;

import org.javacream.training.java.oop.orchester.helper.InstrumentsFromPropertiesReader;

public class Orchester
{

	private List<Instrument> instruments;
	
	{
		InstrumentsFromPropertiesReader reader = new InstrumentsFromPropertiesReader();
		instruments = reader.readInstrumentsFromProperties();
	}

	public void concert()
	{
		for (Instrument instrument : instruments)
		{
			System.out.println(instrument.playSound());
		}
	}

}
