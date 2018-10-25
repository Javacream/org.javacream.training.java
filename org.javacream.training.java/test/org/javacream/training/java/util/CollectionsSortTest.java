package org.javacream.training.java.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

public class CollectionsSortTest
{
	@Test
	public void sortStringList()
	{
		ArrayList<String> list = new ArrayList<String>();
		list.add("Hugo");
		list.add("Emil");
		list.add("Zvonimir");
		list.add("Hugo");
		Assert.assertEquals(4, list.size());
		Assert.assertEquals("Hugo", list.get(0));
		Collections.sort(list);
		Assert.assertEquals("Emil", list.get(0));
		Collections.reverse(list);
		Assert.assertEquals("Zvonimir", list.get(0));
	}

	@Test
	public void testDouble()
	{
		// TODO...
		double d1 = Math.sqrt(2.0);
		double d2 = Math.sqrt(2.0);
		if (d1 > d2)
		{
			System.out.println("##### GREATER");
		}
		if (d1 < d2)
		{
			System.out.println("##### LESS");
		}
		if (d1 == d2)
		{
			System.out.println("##### EQUAL");
		}

	}

	@Test
	public void sortStringListBySecondLetter()
	{
		ArrayList<String> list = new ArrayList<String>();
		list.add("Hugo");
		list.add("Emil");
		list.add("Zvonimir");
		list.add("Hugo");
		Assert.assertEquals(4, list.size());
		Assert.assertEquals("Hugo", list.get(0));
		Collections.sort(list, new StringSecondLetterComparator(true));
		Assert.assertEquals("Emil", list.get(0));
		Collections.sort(list, new StringSecondLetterComparator(false));
		Assert.assertEquals("Zvonimir", list.get(0));
		
	}
	@Test
	public void sortSet()
	{
		HashSet<String> set = new HashSet<String>();
		set.add("Hugo");
		set.add("Emil");
		set.add("Zvonimir");
		set.add("Hugo");
		Assert.assertEquals(3, set.size());
		//Assert.assertEquals("Hugo", set.get(0));
		ArrayList<String> toSort = new ArrayList<String>(set);
		Collections.sort(toSort, new StringSecondLetterComparator(true));
		Assert.assertEquals("Emil", toSort.get(0));
		Collections.sort(toSort, new StringSecondLetterComparator(false));
		Assert.assertEquals("Zvonimir", toSort.get(0));
	}

	
	@Test
	public void sortCoordinateList()
	{
		ArrayList<Coordinate> list = new ArrayList<Coordinate>();
		Coordinate coordinate = new Coordinate(42, 2, 3);
		list.add(coordinate);
		list.add(new Coordinate(1, 2, 3));
		list.add(new Coordinate(3, 2, 3));
		list.add(new Coordinate(2, 2, 3));
		Assert.assertEquals(4, list.size());
		Assert.assertEquals(42, list.get(0).getX(), 1e-9);
		Collections.sort(list);
		Assert.assertEquals(1, list.get(0).getX(), 1e-9);
	}
}

class Coordinate implements Comparable<Coordinate>
{
	private double x, y, z;

	public double getX()
	{
		return x;
	}

	public double getY()
	{
		return y;
	}

	public double getZ()
	{
		return z;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(z);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Coordinate other = (Coordinate) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		if (Double.doubleToLongBits(z) != Double.doubleToLongBits(other.z))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Coordinate [x=" + x + ", y=" + y + ", z=" + z + "]";
	}

	public Coordinate(int x, int y, int z)
	{
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double distance()
	{
		return Math.sqrt(x * x + y * y + z * z);
	}

	@Override
	public int compareTo(Coordinate o)

	{

		if (1000 * this.distance() - 1000 * o.distance() > 0)
		{
			return 1;
		} else if (1000 * this.distance() - 1000 * o.distance() < 0)
		{
			return -1;
		} else
		{
			return 0;
		}
	}

}

class StringSecondLetterComparator implements Comparator<String>
{

	private boolean direction;

	public StringSecondLetterComparator(boolean direction)
	{
		super();
		this.direction = direction;
	}

	@Override
	public int compare(String o1, String o2)
	{
		Character c1 = o1.charAt(1);
		Character c2 = o2.charAt(1);
		if (direction)
		{
			return c1.compareTo(c2);
		}else {
			return -c1.compareTo(c2);
		}
	}

}