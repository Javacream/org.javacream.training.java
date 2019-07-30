package org.javacream.training.java.publishing.api;

public interface IsbnGenerator {

	String next();

	public abstract class Strategies{
		public static final String SEQUENCE = "sequence";
		public static final String RANDOM = "random";
	}
}