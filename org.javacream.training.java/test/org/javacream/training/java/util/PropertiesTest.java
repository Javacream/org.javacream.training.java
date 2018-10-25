package org.javacream.training.java.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.javacream.training.java.oop.orchester.Instrument;
import org.junit.Test;

public class PropertiesTest
{

	@Test
	public void testProperties()
	{
		Properties properties = new Properties();
		try
		{
			//properties.load(getClass().getResourceAsStream("/resources/demo.properties"));
			properties.load(new FileInputStream("demo.properties"));
			String message = properties.getProperty("message", "unknown");
			String numberAsString = properties.getProperty("number", "1");
			Integer number = Integer.parseInt(numberAsString);
			for (int i = 0; i < number; i++)
			{
				System.out.println((i + 1) + ". " + message);
			}
			
			properties.setProperty("dies", "das");
			properties.store(new FileOutputStream("demo_changed.properties"), "no comment");
		} catch (IOException e)
		{
			e.printStackTrace();
		} catch (NullPointerException e)
		{
			e.printStackTrace();
		}
	}
	
	@Test public void testInstruments() throws Exception{
		Properties properties = new Properties();
		properties.load(getClass().getResourceAsStream("instruments.properties"));
		for (Object key: properties.keySet()) {
			System.out.println(properties.getProperty(key.toString()));
		}
		Integer counter = 1;
		String value;
		while((value = properties.getProperty("instrument" + counter)) != null) {
			//System.out.println("Instrument " + counter + "." + value);
			String classToInstantiate = "org.javacream.training.java.oop.orchester." + value;
			Object object = Class.forName(classToInstantiate).getConstructor().newInstance();
			Instrument i = (Instrument)object;
			System.out.println(i.playSound());
			counter++;
		}
		
		
		
		
	}
}

class ExceptionsDemo
{
	public void doSomethingCheckedException() throws IOException
	{
		throw new IOException();
	}

	public void doSomethingRuntimeException()
	{
		throw new NullPointerException();
	}
}
