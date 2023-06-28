package org.javacream.streaming;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamExampleTests {

    @Test public void testDistinct(){
        Data.names.stream().distinct().forEach(System.out::println);
    }
    @Test public void testFlatMap(){
        Data.numbers.stream().flatMap(e -> e.stream()).forEach(System.out::println);
    }
    @Test public void testReduce(){
        System.out.println((Data.numbers.stream().flatMap(e -> e.stream()).reduce(0, (old, value) -> old+value)));
    }
}

