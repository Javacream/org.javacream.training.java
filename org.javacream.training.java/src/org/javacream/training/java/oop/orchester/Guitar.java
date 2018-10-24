package org.javacream.training.java.oop.orchester;

public class Guitar extends Instrument
{

	public Guitar()
	{
		super("guitar");
	}

	@Override
	public String makeSound()
	{
		return "Klimper klamper";
	}

}
