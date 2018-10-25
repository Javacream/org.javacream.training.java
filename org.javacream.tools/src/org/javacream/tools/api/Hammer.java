package org.javacream.tools.api;

public class Hammer extends Tool
{

	public Hammer() {
		super("a hammer");
	}

	public Hammer(Long inventory, String description)
	{
		super(inventory, description);
	}

	public Hammer(String description)
	{
		super(description);
	}

	@Override
	public void doWork()
	{
		System.out.println(this + " hammering at " + getCoordinate());
		
	}
	
}
