package org.javacream.training.java.util.concurrent;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SimpleThreadingApplication
{

	private ScheduledExecutorService scheduledExecutorService;
	private ExecutorService executorService;
	private String stateOfBlocker;

	public void defineShutdown()
	{
		scheduledExecutorService.schedule(new Runnable()
		{

			@Override
			public void run()
			{
				shutdown();
			}

		}, 5, TimeUnit.SECONDS);
	}

	public void init()
	{
		scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		executorService = Executors.newFixedThreadPool(10);
	}

	public void startClock()
	{
		scheduledExecutorService.scheduleAtFixedRate(new Runnable()
		{
			@Override
			public void run()
			{
				System.out.println(new Date() + ", stateOfBlocker=" + stateOfBlocker);
			}

		}, 0, 1, TimeUnit.SECONDS);
	}

	public void triggerLoad()
	{
		Future result = executorService.submit(new Runnable()
		{

			@Override
			public void run()
			{
				stateOfBlocker = "Running";
				try
				{
					Blocker.block();
					stateOfBlocker = "Done";
				} catch (Exception e)
				{
					stateOfBlocker = "Exception";

				}
			}

		});

	}

	public void shutdown()
	{
		scheduledExecutorService.shutdown();
	}

	public static void main(String[] args)
	{
		SimpleThreadingApplication app = new SimpleThreadingApplication();
		app.init();
		app.triggerLoad();
		app.startClock();
		app.defineShutdown();
	}

}
