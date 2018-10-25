package org.javacream.training.java.oop;

import java.util.List;

import org.javacream.training.java.oop.orchester.Instrument;
import org.javacream.training.java.oop.orchester.helper.InstrumentsFromPropertiesReader;
import org.junit.Assert;
import org.junit.Test;

public class InstrumentsFromPropertiesReaderTest
{

	@Test public void testReader() {
		InstrumentsFromPropertiesReader reader = new InstrumentsFromPropertiesReader();
		List<Instrument> result = reader.readInstrumentsFromProperties();
		Assert.assertEquals(6, result.size());
	}
}
