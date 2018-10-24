package org.javacream.training.java.basic;

import org.junit.Assert;
import org.junit.Test;

public class PersonDemoTest
{

	@Test
	public void testPeopleCreation()
	{
		Person p1 = new Person("Sawitzki", "Rainer", 183, 'm'); //Java: "": String, '': Character
		Person p2 = new Person("Sawitzki", "Helga", 177, 'f');
		Person p3 = new Person("Sawitzki", "Rainer", 183, 'm'); //Java: "": String, '': Character
		System.out.println("Finished Test");
		
		Address a1 = new Address("München", "Marienplatz");
		Address a2 = new Address("Berlin", "Alexanderplatz");
		Address a3 = new Address("München", "Marienplatz");
		
		
		String s1 = new String("Hugo");
		String s2 = new String("Hugo");
		
		Assert.assertFalse((s1 == s2));
		Assert.assertTrue((s1.equals(s2)));
		
		Assert.assertFalse((p1 == p3));
		Assert.assertFalse((p1.equals(p3)));
		Assert.assertFalse((p1 == p2));
		Assert.assertFalse((p1.equals(p2)));

		Assert.assertFalse((a1 == a3));
		Assert.assertTrue((a1.equals(a3)));
		Assert.assertFalse((a1 == a2));
		Assert.assertFalse((a1.equals(a2)));

		
	}
}
