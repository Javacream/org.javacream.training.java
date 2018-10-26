package org.javacream.training.java.util.concurrent;

public class Blocker
{

	public static void block(){
		try
		{
			Thread.sleep(3000);
			throw new NullPointerException();
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
}
