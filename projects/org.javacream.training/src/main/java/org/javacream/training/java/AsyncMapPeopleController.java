package org.javacream.training.java;

import org.apache.commons.lang3.SerializationUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class AsyncMapPeopleController implements AsyncPeopleController {

    private Map<Integer, Person> peopleMap = new HashMap<>();
    private Integer counter = 0;
    @Override
    public CompletableFuture<Person> create(String lastname, String firstname, Integer height, Double weight){
        return CompletableFuture.supplyAsync(() -> {
            counter++;
            Person p = new Person(counter, lastname, firstname, height, weight);
            peopleMap.put(counter, p);
            return p;
        });
    }
    @Override
    public CompletableFuture<Person> findById(Integer id){
        return CompletableFuture.supplyAsync(() -> {
            Person p = peopleMap.get(id);
            return SerializationUtils.clone(p);
        });
    }
    @Override
    public CompletableFuture<Void> update(Integer id, Address newAddress){
        return CompletableFuture.runAsync(() -> {
            Person p = peopleMap.get(id);
            if (p != null){
                p.setAddress(newAddress);
            }

        });
    }
    @Override
    public CompletableFuture<Void> deleteById(Integer id){
        return CompletableFuture.runAsync(() -> {
            peopleMap.remove(id);
        });
    }

}
