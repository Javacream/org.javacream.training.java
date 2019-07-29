package org.javacream.training.java.demo;

import java.util.Date;

import org.junit.Test;

public class InvoiceTest {

	@Test
	public void testEncapsulation() {
		Invoice invoice = new Invoice(4711, 19.99, new Date());
		System.out.println(invoice);
		invoice.setDescription("a sample description");
		System.out.println(invoice);
	}
}
