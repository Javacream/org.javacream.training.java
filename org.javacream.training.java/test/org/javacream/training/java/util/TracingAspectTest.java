package org.javacream.training.java.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TracingAspectTest {

	@Test public void testList() {
		List<String> names = new ArrayList<String>();
		names = TracingAspect.trace(names);
		names.add("Hugo");
		names.add("Emil");
		System.out.println(names.size());
		
	}
}
