package org.javacream.training.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadingExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task 1");
            System.out.println(Thread.currentThread());
        });
        executorService.submit(() -> {
            System.out.println("task 2");
            System.out.println(Thread.currentThread());

        });
        executorService.submit(() -> {
            System.out.println("task 3");
            System.out.println(Thread.currentThread());

        });
        executorService.submit(() -> {
            System.out.println("task 4");
            System.out.println(Thread.currentThread());

        });
        System.out.println(Thread.currentThread());
        System.out.println("finished main");
    }
}
