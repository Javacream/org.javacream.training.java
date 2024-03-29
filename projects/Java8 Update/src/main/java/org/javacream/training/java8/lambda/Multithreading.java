package org.javacream.training.java8.lambda;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Multithreading {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> System.out.println("Hello"));
        executorService.submit(() -> System.out.println("World"));
        executorService.shutdown();

    }
}
