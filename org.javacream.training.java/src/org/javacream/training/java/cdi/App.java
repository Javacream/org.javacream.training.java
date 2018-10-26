package org.javacream.training.java.cdi;

public class App
{

	public static void main(String[] args)
	{
		Roboter r = new Roboter(); //FALSCH -> ToolConntainer null, nicht injected!!!
		//Roboter roboter = javax.enterprise.inject.spi.CDI.current().select(Roboter.class).get();
	}
}
