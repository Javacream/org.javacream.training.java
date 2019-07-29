package org.javacream.training.java.demo;

import org.javacream.training.java.demo.Echo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EchoTest {

	@Before
	public void init() {
		System.out.println("init " + this);
	}
	
	@Test
	public void testEcho() {
		Echo echo = new Echo();
		final String message = "Hello";
		final String expected = "Hello";
		String result = echo.echo(message);
		Assert.assertEquals(expected,  result);
		
	}
}
