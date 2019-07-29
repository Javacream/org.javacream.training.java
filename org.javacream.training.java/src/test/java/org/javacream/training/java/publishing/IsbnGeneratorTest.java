package org.javacream.training.java.publishing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IsbnGeneratorTest {

	private IsbnGenerator isbnGenerator;
	
	@Before
	public void setUp() {
		isbnGenerator = new IsbnGenerator();
	}
	
	@Test
	public void isbnGeneratorGeneratesIsbn() {
		String isbn = isbnGenerator.next();
		Assert.assertNotNull(isbn);
	}
	@Test
	public void generatedIsbnStartsWithIsbn() {
		String isbn = isbnGenerator.next();
		Assert.assertTrue(isbn.startsWith("ISBN:"));
	}
	@Test
	public void generatedIsbnStartsWithDe() {
		String isbn = isbnGenerator.next();
		Assert.assertTrue(isbn.endsWith("-de"));
	}
	@Test
	public void generatedIsbnsAreUnique() {
		String isbn1 = isbnGenerator.next();
		String isbn2 = isbnGenerator.next();
		Assert.assertFalse(isbn1.equals(isbn2));
	}

	@Test
	public void generatedIsbnsHasIntegerInTheMiddle() {
		String isbn = isbnGenerator.next();
		String middle = isbn.substring(5, isbn.length() - 3);
		Integer.parseInt(middle);
	}
	@Test
	public void generatedIsbnsHasPositiveIntegerInTheMiddle() {
		String isbn = isbnGenerator.next();
		String middle = isbn.substring(5, isbn.length() - 3);
		int middleAsInt = Integer.parseInt(middle);
		Assert.assertTrue(middleAsInt > 0);
	}
	

}
