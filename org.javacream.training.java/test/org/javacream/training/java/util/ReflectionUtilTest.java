package org.javacream.training.java.util;

import org.javacream.training.java.academies.University;
import org.javacream.training.java.people.api.Person;
import org.javacream.training.java.people.api.Student;
import org.junit.Test;

public class ReflectionUtilTest {

	@Test public void testPerson() {
		Person person = new Person("Sawitzki", "Rainer", 79.9, 183, new Address("München", "Marienplatz"));
		ReflectionUtility.inspect(person);
		ReflectionUtility.dumpFields(person);
	}
	@Test public void testStudent() {
		Student student = new Student("Sawitzki", "Rainer", 79.9, 183, new Address("München", "Marienplatz"), new University("LMU"));
		ReflectionUtility.inspect(student);
		ReflectionUtility.dumpFields(student);
	}
}
