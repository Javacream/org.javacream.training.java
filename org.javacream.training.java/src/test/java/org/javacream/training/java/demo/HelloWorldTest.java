package org.javacream.training.java.demo;

import org.javacream.training.simple.HelloWorld;
import org.junit.Test;

public class HelloWorldTest {


	@Test public void testHello() {
		HelloWorld helloWorld = new HelloWorld();
		helloWorld.sayHello();
	}
}
