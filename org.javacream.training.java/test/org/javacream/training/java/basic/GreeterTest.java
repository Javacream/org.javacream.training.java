package org.javacream.training.java.basic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GreeterTest
{

	private static String greeting;
	private static String name;
	private Greeter greeter;

	@BeforeClass
	public static void staticInit()
	{
		System.out.println("Before Class init...");
		greeting = "Hello";
		name = "Sawitzki";
	}

	
	@Before
	public void init()
	{
		System.out.println("Before init...");
		greeter = new Greeter(greeting);
	}
	
	@Test
	public void testGreeterGreetsName()
	{
		final String expectedGreeting = "Hello Sawitzki";
		String result = greeter.greet(name);
		Assert.assertEquals(expectedGreeting, result);
	}

	@Test
	public void testGreeterGreetsNameFriendly()
	{
		final String expectedGreeting = "Hello Sawitzki, nice to meet you";
		String result = greeter.greet(name, true);
		Assert.assertEquals(expectedGreeting, result);

	}

	@Test
	public void testGreeterGreetsNameNotFriendly()
	{
		final String expectedGreeting = "Hello Sawitzki";
		String result = greeter.greet(name, false);
		Assert.assertEquals(expectedGreeting, result);
	}
}
