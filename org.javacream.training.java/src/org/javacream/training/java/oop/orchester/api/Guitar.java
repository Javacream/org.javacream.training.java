package org.javacream.training.java.oop.orchester.api;

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
