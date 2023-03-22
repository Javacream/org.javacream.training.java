package org.javacream.training.java;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddressTest {

    @Test
    public void testEquality(){
        Address a1 = new Address("München", "Marianplatz");
        Address a2 = new Address("München", "Marianplatz");
        Address a3 = new Address("Berlin", "Alexanderplatz");

        assertFalse(a1 == a2);
        assertTrue(a1.equals(a2));
        assertFalse(a3.equals(a2));


    }
}