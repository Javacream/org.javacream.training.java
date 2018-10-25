package org.javacream.training.java.util;

import java.util.StringTokenizer;

import org.junit.Assert;
import org.junit.Test;

public class StringTests
{

	@Test public void testString() {
		String toTest = "Hugo";
		Character c = toTest.charAt(1);
		Assert.assertTrue('u' ==  c);
		String added = toTest.concat("!");
		Assert.assertEquals("Hugo", toTest);
		Assert.assertEquals("Hugo!", added);
		
	}
	
	@Test public void testStringBuilder() {
		StringBuilder sb = new StringBuilder();
		sb.append("Hello");
		sb.append(" ").append("World");
		Assert.assertEquals("Hello World", sb.toString());
	}
	
	@Test public void testStringTokenizer() {
		String sentence = "Hello World and Goodbye Moon";
		StringTokenizer stringTokenizer = new StringTokenizer(sentence, " ");
		while(stringTokenizer.hasMoreTokens()) {
			System.out.println(stringTokenizer.nextToken());
		}
	}
}
