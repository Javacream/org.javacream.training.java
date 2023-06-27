package org.javacream.functional;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultithreadingSample {
    private ExecutorService executorService = Executors.newSingleThreadExecutor();


    public void doSomethingWithFunctionDefinition(){
        String data = "declared in doSomething";
        Runnable r = () -> {
                System.out.println("in run, data=" + data);
        };
        executorService.submit(r);
    }
    public void doSomethingWithFunctionDefinitionCompact(){
        String data = "declared in doSomething";
        executorService.submit(() -> {
                System.out.println("in run, data=" + data);
        });
    }

    public static void main(String[] args) {
        new MultithreadingSample().doSomethingWithFunctionDefinitionCompact();
    }


}
