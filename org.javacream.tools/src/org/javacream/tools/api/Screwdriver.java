package org.javacream.tools.api;

public class Screwdriver extends Tool
{

	public Screwdriver() {
		super("a screwdriver");
	}

	public Screwdriver(Long inventory, String description)
	{
		super(inventory, description);
	}

	public Screwdriver(String description)
	{
		super(description);
	}

	@Override
	public void doWork()
	{
		System.out.println(this + " screwing at " + getCoordinate());
		
	}
	
}
