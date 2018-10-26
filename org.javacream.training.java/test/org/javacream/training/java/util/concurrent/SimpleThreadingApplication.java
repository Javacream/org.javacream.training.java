package org.javacream.training.java.util.concurrent;

public class SimpleThreadingApplication
{

	public static void main(String[] args)
	{
		SimpleThreading app = new SimpleThreading();
		//HINWEIS: Das kann das Framework eventuell auch fast automatisch!
		app.setExecutorService(Context.getExecutorService());
		app.setScheduledExecutorService(Context.getScheduledExecutorService());
		app.init();
		app.triggerLoad();
		app.startClock();
		app.defineShutdown();
	}

}
