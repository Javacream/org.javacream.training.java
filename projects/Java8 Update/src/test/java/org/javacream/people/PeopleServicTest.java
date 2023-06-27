package org.javacream.people;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PeopleServicTest {
    @Test public void createWithMustermannAnd66CreatesPerson(){
        final String NAME = "Mustermann";
        final Double WEIGHT = 66.0;
        PeopleServiceImpl service = new PeopleServiceImpl();
        Person p = service.create(NAME, WEIGHT);
        Assertions.assertEquals(NAME, p.getName());
        Assertions.assertEquals(WEIGHT, p.getWeight());
    }
    @Test public void createWithMustermannCreatesPersonWithDefaultWeight(){
        final String NAME = "Mustermann";
        final Double WEIGHT = 80.3;
        PeopleServiceImpl service = new PeopleServiceImpl();
        Person p = service.create(NAME);
        Assertions.assertEquals(NAME, p.getName());
        Assertions.assertEquals(WEIGHT, p.getWeight());
    }
}
