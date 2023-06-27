package org.javacream.oop;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultithreadingSample {
    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    public void doSomethingWithClassDefinition(){
        String data = "declared in doSomething";
        class MyRunnable implements Runnable{

            @Override
            public void run() {
                System.out.println("in run, data=" + data);
            }
        }
        MyRunnable r = new MyRunnable();
        executorService.submit(r);
    }


    public void doSomethingWithAnonymousClassDefinition(){
        String data = "declared in doSomething";
        Runnable r = new Runnable(){

            @Override
            public void run() {
                System.out.println("in run, data=" + data);
            }
        };
        executorService.submit(r);
    }
    public void doSomethingWithAnonymousClassDefinitionCompact(){
        String data = "declared in doSomething";
        executorService.submit(new Runnable(){

            @Override
            public void run() {
                System.out.println("in run, data=" + data);
            }
        });
    }

    public static void main(String[] args) {
        new MultithreadingSample().doSomethingWithAnonymousClassDefinitionCompact();
    }


}
