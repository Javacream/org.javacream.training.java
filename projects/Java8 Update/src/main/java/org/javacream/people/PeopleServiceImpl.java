package org.javacream.people;

import java.util.Objects;

public class PeopleServiceImpl implements PeopleService{
    @Override
    public Person create(String name, Double weight) {
        Person p = new Person(name, weight);
        return p;
    }
}
