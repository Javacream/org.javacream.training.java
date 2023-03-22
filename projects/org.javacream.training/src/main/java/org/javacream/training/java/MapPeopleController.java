package org.javacream.training.java;

import org.apache.commons.lang3.SerializationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class MapPeopleController implements PeopleController {

    private Map<Integer, Person> peopleMap = new HashMap<>();
    Logger logger = LoggerFactory.getLogger(MapPeopleController.class);
    private Integer counter = 0;
    @Override
    public Person create(String lastname, String firstname, Integer height, Double weight){
        //logger.info("create a new Person");
        counter++;
        Person p = new Person(counter, lastname, firstname, height, weight);
        peopleMap.put(counter, p);
        return p;
    }
    @Override
    public Person findById(Integer id){
        Person p = peopleMap.get(id);
        //return SerializationUtils.clone(p);
        return p;
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
