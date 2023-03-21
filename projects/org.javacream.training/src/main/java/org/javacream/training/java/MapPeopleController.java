package org.javacream.training.java;

import java.util.HashMap;
import java.util.Map;

public class MapPeopleController implements PeopleController {

    private Map<Integer, Person> peopleMap = new HashMap<>();
    private Integer counter = 0;
    @Override
    public Person create(String lastname, String firstname, Integer height, Double weight){
        counter++;
        Person p = new Person(counter, lastname, firstname, height, weight);
        peopleMap.put(counter, p);
        return p;
    }
    @Override
    public Person findById(Integer id){
        return peopleMap.get(id);
    }
    @Override
    public void update(Integer id, Address newAddress){
        Person p = peopleMap.get(id);
        if (p != null){
            p.setAddress(newAddress);
        }
    }
    @Override
    public void deleteById(Integer id){
        peopleMap.remove(id);
    }

}