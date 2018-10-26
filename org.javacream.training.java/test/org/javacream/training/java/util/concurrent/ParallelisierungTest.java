package org.javacream.training.java.util.concurrent;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ParallelisierungTest
{
	private boolean stateInParallelTest;

	public static void main(String[] args) throws InterruptedException
	{
		new ParallelisierungTest();
	}

	public ParallelisierungTest(){
		final Integer methodVar = 42;
		class SimpleActionMethodClass implements Runnable
		{

			@Override
			public void run()
			{
				System.out.println("Time: " + new Date() + ", state=" + stateInParallelTest + ", methodVar" + methodVar);
			}
		}

		System.out.println("Starting main...");
		SimpleActionMethodClass action = new SimpleActionMethodClass();
		action.run();
		
		Runnable r = new Runnable() {
			@Override
			public void run()
			{
				System.out.println("Time: " + new Date() + ", state=" + stateInParallelTest + ", methodVar" + methodVar);
			}
		};
		ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

		scheduledExecutorService.scheduleAtFixedRate(new Runnable()
		{

			@Override
			public void run()
			{
				System.out
						.println("Time: " + new Date() + ", state=" + stateInParallelTest + ", methodVar" + methodVar);
			}

		}, 0, 1, TimeUnit.SECONDS);
//		scheduledExecutorService.scheduleAtFixedRate(r, 0, 2000, TimeUnit.MILLISECONDS);
//		Boolean shouldRun = true;
//		while(shouldRun)//Oh Gott...);
//		{
//			action.run();
//			Thread.sleep(1000);
//		}
//		
//		Timer timer = new Timer();
//		timer.scheduleAtFixedRate(new TimerTaskAction(), new Date(), 1000);
//		System.out.println("finished main");
		// scheduledExecutorService.shutdown();
	}

	class SimpleActionInnerClass implements Runnable
	{

		@Override
		public void run()
		{
			System.out.println("Time: " + new Date() + ", state=" + stateInParallelTest);
		}
	}

}

class SimpleActionWithinApplication implements Runnable
{

	@Override
	public void run()
	{

		System.out.println("Time: " + new Date());
	}
}
