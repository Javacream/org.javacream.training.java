package org.javacream.training.java;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    @Test public void creatingAPersonWithLastnameSawitzkiCreatesAPersonWithLastnameSawitzki(){
        String EXPECTED_LASTNAME = "Sawitzki";
        Person p = new Person(EXPECTED_LASTNAME, "X", 183, 81.1);
        //System.out.println(p.getLastname());
        Assert.assertEquals(EXPECTED_LASTNAME, p.getLastname());
    }
    @Test public void creatingAPersonWithFirstnameRainerCreatesAPersonWithFirstnameRainer(){
        String EXPECTED_FIRSTNAME = "Rainer";
        Person p = new Person("", EXPECTED_FIRSTNAME, 183, 81.1);
        //System.out.println(p.getLastname());
        Assert.assertEquals(EXPECTED_FIRSTNAME, p.getFirstname());
    }

}