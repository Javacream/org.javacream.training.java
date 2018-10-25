package org.javacream.training.java.oop.orchester.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.javacream.training.java.oop.orchester.api.Instrument;
import org.javacream.training.java.oop.orchester.api.Orchester;

public class InstrumentsFromPropertiesReader
{
	public List<Instrument> readInstrumentsFromProperties()
	{
		ArrayList<Instrument> instruments = new ArrayList<Instrument>();
		try
		{
			Properties properties = new Properties();
			properties.load(Orchester.class.getResourceAsStream("instruments.properties"));
			Integer counter = 1;
			String value;
			String packageName = Orchester.class.getPackage().getName();
			while ((value = properties.getProperty("instrument" + counter)) != null)
			{
				
				String classToInstantiate =  packageName + "." + value;
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
