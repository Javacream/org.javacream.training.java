package org.javacream.training.java.util.concurrent.actions;

import java.util.Date;
import java.util.TimerTask;

public class TimerTaskAction extends TimerTask
{

	@Override
	public void run()
	{
		System.out.println("Time from TimerTask: " + new Date());

	}

}
