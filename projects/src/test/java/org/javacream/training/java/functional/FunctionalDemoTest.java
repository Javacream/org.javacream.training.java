package org.javacream.training.java.functional;

import org.junit.jupiter.api.Test;
import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.function.Consumer;

public class FunctionalDemoTest {

    @Test public void doListTest(){
        List<String> names = List.of("Hugo", "Emil");
        names.forEach((String s) -> {
            System.out.println(s);
        });

        names.forEach(s  -> System.out.println(s));

    }
    @Test public void doListTestVerbose(){
        List<String> names = List.of("Hugo", "Emil");
        names.forEach((String s) -> {
            System.out.println(s);
        });
        Consumer<String> c = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        names.forEach(c);

        Consumer<String> c2 = (s) -> System.out.println(s);
        names.forEach(c2);

        String message = "Hello";
        System.out.println(message);
        System.out.println("Hello");
    }
}
