package org.javacream.training.java.oop;

import org.javacream.training.java.oop.orchester.Orchester;
import org.junit.Test;

public class OrchesterTest
{

	@Test public void testOrchester() {
		Orchester o = new Orchester();
		o.concert();
	}
}
