package org.javacream.training.java8.lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class CollectionsTest {
    @Test
    public void testListIteration(){
        List<String> names = new ArrayList<>();
        names.add("Emil");
        names.add("Fritz");

        Consumer<String> consumer = (s) -> System.out.println(s);
        Demo d = (s) -> System.out.println(s);
        //consumer = d; Syntaktisch nicht korrekt, obwohl exakt dieselben Ausrücke zugeweisen wurden
        Consumer<String> consumer2 = System.out::println;
        Demo d2 = System.out::println;

        Consumer<String> consumer3 = this::demo;
        Demo d3 = this::demo;


        names.forEach(consumer);
        names.forEach(System.out::println);
    }

    private void demo(String s){
        //...
    }

    interface Demo{
        void egal(String s);
    }
}
