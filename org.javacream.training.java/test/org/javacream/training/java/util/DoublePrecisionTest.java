package org.javacream.training.java.util;

import java.math.BigDecimal;

import org.junit.Test;

public class DoublePrecisionTest
{

	@Test
	public void testPrecision()
	{
		double total = 0.0;
		total += 20.1;
		total += 21.8;
		System.out.println(total);
	
		BigDecimal bd1 = new BigDecimal("20.1");
		BigDecimal bd2 = new BigDecimal("21.8");
		BigDecimal result = bd1.add(bd2);
		System.out.println(result.doubleValue());
		
	}
}
