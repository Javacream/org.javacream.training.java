package org.javacream.training.java.basic;

public class Greeter {
	private String greeting;
	public Greeter(String greeting) {
		super();
		this.greeting = greeting;
	}
	public String greet(String name) {
		//throw new UnsupportedOperationException("not yet implemented");
		return greeting + " " + name;
	}
	public String greet(String name, boolean friendly) {
		//throw new UnsupportedOperationException("not yet implemented");
		String greeting = greet(name);
		if (friendly) {
			greeting += ", nice to meet you";
		}
		return greeting;
	}
}
