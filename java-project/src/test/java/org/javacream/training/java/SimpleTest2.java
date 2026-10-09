package org.javacream.training.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleTest2 {
	@Test
	public void firstTest() {
		var result = true;
		Assertions.assertTrue(result);
	}
	@Test
	public void realTest() {
		var expectedResult = 4;
		String testString = "Hugo";
		var result = testString.length();
		Assertions.assertEquals(expectedResult, result);
	}
}
