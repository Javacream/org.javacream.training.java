package org.javacream.training.java.basic;

import org.junit.Assert;
import org.junit.Test;

public class ResponderTest
{

	@Test
	public void testPingResponseWithOk()
	{

		// Parameter des Tests
		final String responderMessage = "Ok";

		// Erwartetes Ergebnis
		final String expectedPingResult = "Ok";

		// Das zu testende Objekt erzeugen
		final Responder responder = new Responder(responderMessage);

		// Zu testende Funktion aufrufen

		String result = responder.ping();

		// Eigentliche Test durch Assertions
		Assert.assertEquals(expectedPingResult, result);
	}

}
