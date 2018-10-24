package org.javacream.training.java.basic;

import org.junit.Assert;
import org.junit.Test;

public class GreeterTest {

	
	@Test public void testGreeterGreetsName() {
		final String greeting = "Hello";
		final String name = "Sawitzki";
		final Greeter greeter = new Greeter(greeting);
		final String expectedGreeting = "Hello Sawitzki";
		
		String result = greeter.greet(name);
		Assert.assertEquals(expectedGreeting, result);
	}
	@Test public void testGreeterGreetsNameFriendly() {
		final String greeting = "Hello";
		final String name = "Sawitzki";
		final Greeter greeter = new Greeter(greeting);
		final String expectedGreeting = "Hello Sawitzki, nice to meet you";
		String result = greeter.greet(name, true);
		Assert.assertEquals(expectedGreeting, result);
		
	}
	@Test public void testGreeterGreetsNameNotFriendly() {
		final String greeting = "Hello";
		final String name = "Sawitzki";
		final Greeter greeter = new Greeter(greeting);
		final String expectedGreeting = "Hello Sawitzki";
		String result = greeter.greet(name, false);
		Assert.assertEquals(expectedGreeting, result);
	}
}
