package org.javacream.people;

public class PeopleServiceTestDriver implements PeopleService{
    private static Person DEFAULT_PERSON = new Person ("Mustermann", 77.7);
    @Override
    public Person create(String name, Double weight) {
        return DEFAULT_PERSON;
    }

}
