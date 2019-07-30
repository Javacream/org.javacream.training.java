package org.javacream.training.java.publishing.impl;

import java.util.Random;

import org.javacream.training.java.publishing.api.IsbnGenerator;

public class RandomIsbnGenerator implements IsbnGenerator {
	
	private String prefix;
	private String suffix;
	private Random random;

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	
	{
		random = new Random(this.hashCode() + System.currentTimeMillis());
	}
	
	@Override
	public String next() {
		int nextInt = random.nextInt();
		int positivenextInt = Math.abs(nextInt);
		return prefix + positivenextInt + suffix;
	}

}
