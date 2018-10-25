package org.javacream.training.java.oop.orchester.api;

public class Glockenspiel extends Instrument
{

	public Glockenspiel()
	{
		super("glockenspiel");
	}

	@Override
	public String makeSound()
	{
		return "ding dang";
	}

}
