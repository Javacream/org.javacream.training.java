package org.javacream.training.java.functional;

import org.junit.jupiter.api.Test;

import java.util.List;

public class FunctionalDemoTest {

    @Test public void doListTest(){
        List<String> names = List.of("Hugo", "Emil");
        names.forEach((String s) -> {
            System.out.println(s);
        });

        names.forEach(s  -> System.out.println(s));

    }
}
