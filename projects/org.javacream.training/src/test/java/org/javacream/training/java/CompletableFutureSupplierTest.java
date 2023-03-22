package org.javacream.training.java;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureSupplierTest {

    @Test public void testIt() throws ExecutionException, InterruptedException {
        CompletableFuture<String> result = doSomethingAsyn();
        String s = result.get();
        System.out.println(s);
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
