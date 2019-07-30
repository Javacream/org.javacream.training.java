package org.javacream.training.java.publishing.impl;

import java.util.Random;

import org.javacream.training.java.publishing.api.IsbnGenerator;

public class RandomIsbnGenerator implements IsbnGenerator {
	
	private static final String PREFIX = "ISBN:";
	private static final String SUFFIX = "-de";
	private Random random;
	
	{
		random = new Random(this.hashCode() + System.currentTimeMillis());
	}
	
	@Override
	public String next() {
		int nextInt = random.nextInt();
		int positivenextInt = Math.abs(nextInt);
		return PREFIX + positivenextInt + SUFFIX;
	}

}
