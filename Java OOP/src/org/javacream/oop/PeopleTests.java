package org.javacream.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PeopleTests {

	@Test
	public void testPerson() {
		var lastname = "TestLastname";
		var firstname = "TestFirstname";
		var height = 199;
		var p = new Person(lastname, firstname, height);
		Assertions.assertEquals(lastname, p.getLastname());
		Assertions.assertEquals(firstname, p.getFirstname());
		Assertions.assertEquals(height, p.getHeight());
	}
	@Test
	public void testPersonInfo() {
		var lastname = "TestLastname";
		var firstname = "TestFirstname";
		var height = 199;
		var expected_info = "Person(lastname=TestLastname, firstname=TestFirstname, height=199)";
		var p = new Person(lastname, firstname, height);
		Assertions.assertEquals(expected_info, p.info());
	}
}
