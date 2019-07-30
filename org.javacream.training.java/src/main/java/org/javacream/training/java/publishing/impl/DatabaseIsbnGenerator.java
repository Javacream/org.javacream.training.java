package org.javacream.training.java.publishing.impl;

import org.javacream.training.java.publishing.api.IsbnGenerator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Qualifier(IsbnGenerator.Strategies.SEQUENCE)
public class DatabaseIsbnGenerator implements IsbnGenerator {

	@Value("${isbngenerator.prefix}")
	private String prefix;
	@Value("${isbngenerator.suffix}")
	private String suffix;
	private int counter = 42;

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	@Override
	public String next() {
		int nextInt = ++counter;
		int positivenextInt = Math.abs(nextInt);
		return prefix + positivenextInt + suffix;
	}

}
