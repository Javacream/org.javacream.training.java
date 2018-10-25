package org.javacream.training.java.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

public class Collections
{

	@Test public void iterationVariants(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("Hugo");
		list.add("Emil");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		for (String element: list) {
			System.out.println(element);
		}
		for (Iterator<String> iterator = list.iterator(); iterator.hasNext();)
		{
			System.out.println(iterator.next());
			
		}
		
		String[] array = {"Hugo", "Emil"};
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		for (String element: array) {
			System.out.println(element);
		}
//		for (Iterator<String> iterator = array.iterator(); iterator.hasNext();)
//		{
//			System.out.println(iterator.next());
//			
//		}
		HashSet<String> set = new HashSet<String>();
		set.add("Hugo");
		set.add("Emil");
//		for (int i = 0; i < set.size(); i++) {
//			System.out.println(set.get(i));
//		}
		for (String element: set) {
			System.out.println(element);
		}
		for (Iterator<String> iterator = set.iterator(); iterator.hasNext();)
		{
			System.out.println(iterator.next());
			
		}

	}
	@Test public void testStringList() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Hugo");
		list.add("Emil");
		list.add("Fritz");
		list.add("Hugo");
		Assert.assertEquals(4, list.size());
		
		Assert.assertTrue(list.contains("Hugo"));
		Assert.assertFalse(list.contains("Rainer"));
		list.remove("Hugo");
		Assert.assertEquals(3, list.size());
		Assert.assertTrue(list.contains("Hugo"));
		list.remove("Hugo");
		Assert.assertEquals(2, list.size());
		Assert.assertFalse(list.contains("Hugo"));
	}

	@Test public void testCoordinateNoHashList() {
		ArrayList<CoordinateNoHash> list = new ArrayList<CoordinateNoHash>();
		CoordinateNoHash coordinate = new CoordinateNoHash(1, 2, 3);
		list.add(coordinate);
		list.add(new CoordinateNoHash(2, 2, 3));
		list.add(new CoordinateNoHash(3, 2, 3));
		list.add(new CoordinateNoHash(1, 2, 3));
		Assert.assertEquals(4, list.size());
		
		Assert.assertFalse(list.contains(new CoordinateNoHash(1, 2, 3)));
		Assert.assertFalse(list.contains(new CoordinateNoHash(58, 59, 60)));
		Assert.assertTrue(list.contains(coordinate));
		list.remove(new CoordinateNoHash(1, 2, 3));
		Assert.assertEquals(4, list.size());
		list.remove(coordinate);
		Assert.assertEquals(3, list.size());
		Assert.assertFalse(list.contains(coordinate));
	}

	
	@Test public void testStringSet() {
		HashSet<String> set = new HashSet<String>();
		set.add("Hugo");
		set.add("Emil");
		set.add("Fritz");
		set.add("Hugo");
		Assert.assertEquals(3, set.size());
		
		Assert.assertTrue(set.contains("Hugo"));
		Assert.assertFalse(set.contains("Rainer"));
		set.remove("Hugo");
		Assert.assertEquals(2, set.size());
		Assert.assertFalse(set.contains("Hugo"));
		
	}
	@Test public void testCoordinateNoHashSet() {
		HashSet<CoordinateNoHash> set = new HashSet<CoordinateNoHash>();
		CoordinateNoHash coordinate = new CoordinateNoHash(1, 2, 3);
		set.add(coordinate);
		set.add(new CoordinateNoHash(2, 2, 3));
		set.add(new CoordinateNoHash(3, 2, 3));
		set.add(new CoordinateNoHash(1, 2, 3));
		Assert.assertEquals(4, set.size());
	}

	@Test public void testCoordinateHashSet() {
		HashSet<CoordinateHash> set = new HashSet<CoordinateHash>();
		CoordinateHash coordinate = new CoordinateHash(1, 2, 3);
		set.add(coordinate);
		set.add(new CoordinateHash(2, 2, 3));
		set.add(new CoordinateHash(3, 2, 3));
		set.add(new CoordinateHash(1, 2, 3));
		Assert.assertEquals(3, set.size());
	}
	@Test public void testCoordinateCommunistHashSet() {
		HashSet<CoordinateCommunistHash> set = new HashSet<CoordinateCommunistHash>();
		CoordinateCommunistHash coordinate = new CoordinateCommunistHash(1, 2, 3);
		set.add(coordinate);
		set.add(new CoordinateCommunistHash(2, 2, 3));
		set.add(new CoordinateCommunistHash(3, 2, 3));
		set.add(new CoordinateCommunistHash(1, 2, 3));
		Assert.assertEquals(1, set.size());
	}
	
	@Test public void testIntegerStringMap() {
		HashMap<Integer, String> postalCodes = new HashMap<Integer, String>();
		postalCodes.put(81373, "München");
		postalCodes.put(83607, "Holzkircha");
		Assert.assertEquals(2, postalCodes.size());
		Assert.assertEquals("Holzkircha", postalCodes.get(83607));
		postalCodes.put(83607, "Holzkirchen");
		Assert.assertEquals(2, postalCodes.size());
		Assert.assertEquals("Holzkirchen", postalCodes.get(83607));
		postalCodes.remove(83607);
		Assert.assertEquals(1, postalCodes.size());
		Assert.assertNull(postalCodes.get(83607));
		for (Integer key: postalCodes.keySet()) {
			System.out.println(postalCodes.get(key));
		}
	
		HashMap<String, ArrayList<Integer>> reversePostalCodes = new HashMap<String, ArrayList<Integer>>();
		//Add München PLZ, first...
		//TODO: Hilfsfunktion?
		ArrayList<Integer> postalCodesForCity = reversePostalCodes.get("München");
		if (postalCodesForCity == null) {
			postalCodesForCity = new ArrayList<Integer>();
			reversePostalCodes.put("München", postalCodesForCity);
		}
		postalCodesForCity.add(81373);
	}

	@Test public void testCoordianteHashStringMap() {
		HashMap<CoordinateHash, String> toolsInSpace = new HashMap<CoordinateHash, String>();
		toolsInSpace.put(new CoordinateHash(1,2,3), "Schraubenzieher");
		toolsInSpace.put(new CoordinateHash(1,2,4), "Hammer");
		//...
		Assert.assertEquals(toolsInSpace.get(new CoordinateHash(1,2,4)), "Hammer");
	}
	@Test public void testCoordianteNoHashStringMap() {
		HashMap<CoordinateNoHash, String> toolsInSpace = new HashMap<CoordinateNoHash, String>();
		CoordinateNoHash coordinate = new CoordinateNoHash(1,2,3);
		toolsInSpace.put(coordinate, "Schraubenzieher");
		
		toolsInSpace.put(new CoordinateNoHash(1,2,4), "Hammer");
		//...
		Assert.assertEquals(toolsInSpace.get(new CoordinateNoHash(1,2,4)), null);
		Assert.assertEquals(toolsInSpace.get(coordinate), "Schraubenzieher");
		
	}
	
}

class CoordinateNoHash{
	private int x, y, z;


	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public int getZ()
	{
		return z;
	}

	public CoordinateNoHash(int x, int y, int z)
	{
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public String toString()
	{
		return "CoordinateNoHash [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
	
}

class CoordinateHash{
	private int x, y, z;

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		result = prime * result + z;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CoordinateHash other = (CoordinateHash) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		if (z != other.z)
			return false;
		return true;
	}

	public int getZ()
	{
		return z;
	}

	public CoordinateHash(int x, int y, int z)
	{
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public String toString()
	{
		return "CoordinateHash [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
	
}

class CoordinateCommunistHash{
	private int x, y, z;

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	@Override
	public int hashCode()
	{
		return 1;
	}

	@Override
	public boolean equals(Object obj)
	{
		return true;
	}

	public int getZ()
	{
		return z;
	}

	public CoordinateCommunistHash(int x, int y, int z)
	{
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public String toString()
	{
		return "CoordinateNoHash [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
}
