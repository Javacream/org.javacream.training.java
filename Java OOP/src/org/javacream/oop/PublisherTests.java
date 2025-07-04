package org.javacream.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PublisherTests {

	@Test public void testPublisher() {
		var publisher = new Publisher("TEST");
		Assertions.assertEquals("TEST", publisher.getName());
	}
}
