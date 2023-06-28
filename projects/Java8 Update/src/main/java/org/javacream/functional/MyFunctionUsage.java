package org.javacream.functional;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MyFunctionUsage {
    public static void main(String[] args) {

        Consumer<String> c = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("anonymous: " + s);
            }
        };

        c.accept("Hugo");

        Consumer<String> lambdaC = (s) -> System.out.println("lambda: " + s);
        lambdaC.accept("Emil");

        Consumer<String> methodReferenceC = System.out::println;
        methodReferenceC.accept("method reference: Egon");

        //Predicate<String> test = System.out::println;
        String name = "Fridolin";
        Supplier<Integer> s = name::length;
        System.out.println(s.get());


    }


}

