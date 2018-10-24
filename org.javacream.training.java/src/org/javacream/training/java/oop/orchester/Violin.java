package org.javacream.training.java.oop.orchester;

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
