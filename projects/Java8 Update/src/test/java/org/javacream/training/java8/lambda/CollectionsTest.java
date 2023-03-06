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

        names.forEach(consumer);
    }
}
