package org.javacream.training.java.publishing;

import org.javacream.training.java.publishing.api.IsbnGenerator;
import org.javacream.training.java.publishing.impl.RandomIsbnGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IsbnGeneratorTest {
	private final String TEST_PREFIX = "ISBN";
	private final String TEST_SUFFIX = "-de";
	private IsbnGenerator isbnGenerator;
	
	@Before
	public void setUp() {
		RandomIsbnGenerator randomIsbnGenerator = new RandomIsbnGenerator();
		randomIsbnGenerator.setPrefix(TEST_PREFIX);
		randomIsbnGenerator.setSuffix(TEST_SUFFIX);
		isbnGenerator = randomIsbnGenerator;
	}
	
	@Test
	public void isbnGeneratorGeneratesIsbn() {
		String isbn = isbnGenerator.next();
		Assert.assertNotNull(isbn);
	}
	@Test
	public void generatedIsbnStartsWithIsbn() {
		String isbn = isbnGenerator.next();
		Assert.assertTrue(isbn.startsWith(TEST_PREFIX));
	}
	@Test
	public void generatedIsbnStartsWithDe() {
		String isbn = isbnGenerator.next();
		Assert.assertTrue(isbn.endsWith(TEST_SUFFIX));
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
