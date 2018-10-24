package org.javacream.training.java.oop.orchester;

public class Drum extends Instrument
{

	public Drum()
	{
		super("a drum");
	}

	@Override
	public String makeSound()
	{
		return "Wumm";
	}

}
