package org.javacream.training.java.oop.orchester;

public class Harp extends Instrument
{

	public Harp()
	{
		super("harp");
	}

	@Override
	public String makeSound()
	{
		return "sphärisches geklimper";
	}

}
