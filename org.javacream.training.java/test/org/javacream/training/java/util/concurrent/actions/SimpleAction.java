package org.javacream.training.java.util.concurrent.actions;

import java.util.Date;

public class SimpleAction implements Runnable
{

	@Override
	public void run()
	{
		System.out.println("Time: " + new Date());
	}

}
