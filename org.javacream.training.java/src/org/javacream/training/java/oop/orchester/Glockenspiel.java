package org.javacream.training.java.oop.orchester;

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
