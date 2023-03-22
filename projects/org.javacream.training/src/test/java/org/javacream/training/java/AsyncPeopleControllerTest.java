package org.javacream.training.java;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;

public class AsyncPeopleControllerTest {
    @Test
    public void testSequence(){
        AsyncPeopleController peopleController = AsyncPeopleController.getInstance();
        CompletableFuture<Person> createdPerson = peopleController.create("Hu", "Go", 100, 10.0);
        CompletableFuture<Person> found = createdPerson.thenCompose((person) -> peopleController.findById(person.getId()));
        CompletableFuture<Void> deleted = createdPerson.thenCompose((person) -> peopleController.deleteById(person.getId()));
        deleted.thenAccept((v) -> System.out.println("done"));
    }
    @Test
    public void testSequenceCompact(){
        AsyncPeopleController peopleController = AsyncPeopleController.getInstance();
        peopleController.create("Hu", "Go", 100, 10.0).thenCompose((person) -> peopleController.findById(person.getId())).thenCompose((person) -> peopleController.deleteById(person.getId())).thenAccept((v) -> System.out.println("done"));
    }
}
