package org.javacream.training.java.util.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
//HINWEIS: Dieser Kontext ist normalerweise Bestandteil eines Frameworks!
//Muss deshalb  nicht selbst geschrieben werden!
public abstract class Context
{
	private static ExecutorService executorService;
	private static ScheduledExecutorService scheduledExecutorService;
	
	public static ExecutorService getExecutorService()
	{
		return executorService;
	}

	public static ScheduledExecutorService getScheduledExecutorService()
	{
		return scheduledExecutorService;
	}

	static {
		scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		executorService = Executors.newFixedThreadPool(10);
		
	}
	
	
}
