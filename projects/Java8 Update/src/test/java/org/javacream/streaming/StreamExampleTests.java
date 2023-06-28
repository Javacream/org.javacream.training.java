package org.javacream.streaming;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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

    @Test public void collectDistinct(){
        //ArrayList<String> result = new ArrayList<>();
        //Data.names.stream().distinct().forEach(e -> result.add(e));
        List<String> result = Data.names.stream().distinct().collect(Collectors.toList());
        result.forEach(System.out::println);
    }
    @Test public void testJoining(){
        System.out.println(Data.data.stream().map(n -> n.toString()).collect(Collectors.joining("#", "*", "~")));
    }
    @Test public void testSummarizing(){
        System.out.println(Data.data.stream().collect(Collectors.summarizingDouble(d -> d)));
    }
    @Test public void testGrouping(){
        System.out.println(Data.people.stream().collect(Collectors.groupingBy(person -> person.getAddress().getCity())));
    }

}

