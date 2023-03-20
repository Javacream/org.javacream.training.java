package org.javacream.training.java;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    @Test public void creatingAPersonWithLastnameSawitzkiCreatesAPersonWithLastnameSawitzki(){
        final String EXPECTED_LASTNAME = "Sawitzki";
        Person p = new Person(EXPECTED_LASTNAME, "X", 183, 81.1);
        //System.out.println(p.getLastname());
        Assert.assertEquals(EXPECTED_LASTNAME, p.getLastname());
    }
    @Test public void creatingAPersonWithFirstnameRainerCreatesAPersonWithFirstnameRainer(){
        final String EXPECTED_FIRSTNAME = "Rainer";
        Person p = new Person("", EXPECTED_FIRSTNAME, 183, 81.1);
        //System.out.println(p.getLastname());
        Assert.assertEquals(EXPECTED_FIRSTNAME, p.getFirstname());
    }

    @Test
    public void testIntroduce(){
        final String LASTNAME = "Sawitzki";
        final String FIRSTNAME = "Rainer";
        final Integer HEIGHT = 183;
        final Double WEIGHT = 81.1;
        final String EXPECTED_INTRODUCTION = "Person: lastname=Sawitzki, firstname=Rainer, height=183, weight=81.1";
        Person p = new Person(LASTNAME, FIRSTNAME, HEIGHT, WEIGHT);
        Assert.assertEquals(EXPECTED_INTRODUCTION, p.introduce());

    }
}