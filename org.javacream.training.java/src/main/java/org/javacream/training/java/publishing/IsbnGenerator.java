package org.javacream.training.java.publishing;

import java.util.Random;

public class IsbnGenerator {
	
	private static final String PREFIX = "ISBN:";
	private static final String SUFFIX = "-de";
	private Random random;
	
	{
		random = new Random(this.hashCode() + System.currentTimeMillis());
	}
	
	public String next() {
		int nextInt = random.nextInt();
		int positivenextInt = Math.abs(nextInt);
		return PREFIX + positivenextInt + SUFFIX;
	}

}
