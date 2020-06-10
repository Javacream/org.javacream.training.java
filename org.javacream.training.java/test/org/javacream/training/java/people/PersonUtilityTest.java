package org.javacream.training.java.people;

import org.javacream.training.java.util.Address;
import org.junit.Assert;
import org.junit.Test;

public class PersonUtilityTest {
	
	@Test public void testEncodeOk() {
		String expectedCsv = "Sawitzki,Rainer,183,79.9,u,München,Marienplatz";
		Person person = new Person("Sawitzki", "Rainer", 79.9, 183, new Address("München", "Marienplatz"));
		String createdCsv = PersonUtility.encode(person);
		Assert.assertEquals(expectedCsv, createdCsv);
	}

}
