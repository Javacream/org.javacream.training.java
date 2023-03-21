package org.javacream.training.java;

public interface PeopleController {
    Person create(String lastname, String firstname, Integer height, Double weight);

    Person findById(Integer id);

    void update(Integer id, Address newAddress);

    void deleteById(Integer id);

    public static PeopleController getInstance(){
        return new MapPeopleController();
    }
}
