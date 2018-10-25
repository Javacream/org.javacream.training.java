package org.javacream.training.java.oop;

import org.javacream.training.java.oop.orchester.api.Orchester;
import org.junit.Test;

public class OrchesterTest
{

	@Test public void testOrchester() {
		Orchester o = new Orchester();
		o.concert();
	}
}
