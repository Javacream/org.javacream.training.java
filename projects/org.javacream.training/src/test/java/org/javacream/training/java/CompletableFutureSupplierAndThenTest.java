package org.javacream.training.java;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureSupplierAndThenTest {

    @Test public void testIt() throws ExecutionException, InterruptedException {
        CompletableFuture<String> result = doSomethingAsyn();
        result.thenAccept(System.out::println);
        Thread.sleep(2000);
    }

    private CompletableFuture<String> doSomethingAsyn(){
        CompletableFuture<String> result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
                return "Hello Threads!";
            } catch (InterruptedException e) {
                e.printStackTrace();
                return e.getMessage();
            }
        });
        return result;
    }
}
