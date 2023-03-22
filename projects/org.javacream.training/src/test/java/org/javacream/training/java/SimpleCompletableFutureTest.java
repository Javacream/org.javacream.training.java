package org.javacream.training.java;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleCompletableFutureTest {

    ExecutorService executorService = Executors.newFixedThreadPool(1);
    @Test public void testIt() throws ExecutionException, InterruptedException {
        CompletableFuture<String> result = doSomethingAsyn();
        String s = result.get();
        System.out.println(s);
    }

    private CompletableFuture<String> doSomethingAsyn(){
        CompletableFuture<String> result = new CompletableFuture<>();
        executorService.submit(() -> {
            try {
                Thread.sleep(1000);
                result.complete("Hello Threads!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        return result;

    }
}
