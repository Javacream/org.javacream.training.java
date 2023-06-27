package org.javacream.people;

public interface PeopleService {
    public Person create(String name, Double weight);
    public default Person create(String name) {
        return this.create(name, 80.3);
    }

}
