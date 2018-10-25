package org.javacream.training.java.util;

import org.junit.Assert;
import org.junit.Test;

public class NumberTests
{

	@Test public void testInteger() {
		int i = 5;
		Integer j = 42;
		int k = i;
		k = j;
		j = k;
		
		DemoInteger di = new DemoInteger();
		Assert.assertTrue(di.getI() == 0);
		Assert.assertTrue(di.getJ() == null);
	}
	
	@Test (expected=NullPointerException.class) public void testIntegerAsIntUnsafe() {
		DemoInteger di = new DemoInteger();
		di.getJasIntUnsafe();
	}
	@Test  public void testIntegerAsIntSafe() {
		DemoInteger di = new DemoInteger();
		Assert.assertTrue(di.getJasIntSafe() == 0);
	}
	
	@Test public void testParse() {
		String numberAsString = "2";
		Object result = 4 + numberAsString;
		Assert.assertEquals("42", result);
		result = 4 + Integer.parseInt(numberAsString);
		Assert.assertEquals(6, result);
		Integer i1 = 4;
		Integer i2 = 2;
		result = i1 + i2;
		Assert.assertEquals(6, result);
		result = i1.toString() + i2.toString();
		Assert.assertEquals("42", result);
		result = "" + i1 + i2;
		Assert.assertEquals("42", result);
		result = "" + (i1 + i2);
		Assert.assertEquals("6", result);
		int i3 = 4;
		int i4 = 2;
		result = i3 + i4;
		//result = i3.toString() + i4.toString();
		result = Integer.toString(i1) + Integer.toString(i2);
		
		
		
		
		
	}
}

class DemoInteger{
	private int i;
	private Integer j;
	public int getI()
	{
		return i;
	}
	public Integer getJ()
	{
		return j;
	}
	public int getJasIntUnsafe()
	{
		return j;
	}
	public int getJasIntSafe()
	{
		if (j == null) {
			return 0;
		}else {
			return j;
		}
	}
	
}
