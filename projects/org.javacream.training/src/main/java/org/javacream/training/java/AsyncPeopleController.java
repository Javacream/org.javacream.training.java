package org.javacream.training.java;

import java.util.concurrent.CompletableFuture;

public interface AsyncPeopleController {
    CompletableFuture<Person> create(String lastname, String firstname, Integer height, Double weight);

    CompletableFuture<Person> findById(Integer id);

    CompletableFuture<Void> update(Integer id, Address newAddress);

    CompletableFuture<Void> deleteById(Integer id);

    public static AsyncPeopleController getInstance(){
        return new AsyncMapPeopleController();
    }
}
