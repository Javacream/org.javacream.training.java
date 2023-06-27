package org.javacream.functional;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultithreadingSample {
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();


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
