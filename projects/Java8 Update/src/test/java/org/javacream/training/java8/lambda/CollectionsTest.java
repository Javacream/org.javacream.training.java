package org.javacream.training.java8.lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CollectionsTest {
    @Test
    public void testListIteration(){
        List<String> names = new ArrayList<>();
        names.add("Emil");
        names.add("Fritz");
        names.forEach((s) -> System.out.println(s));
    }
}
