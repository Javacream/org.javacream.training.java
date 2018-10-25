package org.javacream.training.java.oop.orchester.api;

public class Violin extends Instrument
{

	public Violin()
	{
		super("violin");
	}

	@Override
	public String makeSound()
	{
		return "fidelfadel";
	}

}
