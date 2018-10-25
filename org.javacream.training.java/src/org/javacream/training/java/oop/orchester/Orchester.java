package org.javacream.training.java.oop.orchester;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Orchester
{

	private List<Instrument> instruments = readInstrumentsFromProperties();

	public void concert()
	{
		for (Instrument instrument : instruments)
		{
			System.out.println(instrument.playSound());
		}
	}

	private List<Instrument> readInstrumentsFromProperties()
	{
		ArrayList<Instrument> instruments = new ArrayList<Instrument>();
		try
		{
			Properties properties = new Properties();
			properties.load(getClass().getResourceAsStream("instruments.properties"));
			Integer counter = 1;
			String value;
			while ((value = properties.getProperty("instrument" + counter)) != null)
			{
				String classToInstantiate = "org.javacream.training.java.oop.orchester." + value;
				Object object = Class.forName(classToInstantiate).getConstructor().newInstance();
				Instrument i = (Instrument) object;
				instruments.add(i);
				counter++;
			}
		} catch (Exception e)
		{
			System.out.println("exception reading orchester.properties");
		}
		return instruments;

	}
}
