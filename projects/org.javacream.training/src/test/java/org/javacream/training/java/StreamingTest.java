package org.javacream.training.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamingTest {
    @Test
    public void testListStreaming(){
        List<String> names = new ArrayList<>();
        names.add("Hugo");
        names.add("Zvonimir");
        names.add("Franz");
        names.add("Helga");
        names.add("Hilde");
        names.add("Egon");

/*        for (int i = 0; i < names.size(); i++){
            System.out.println(names.get(i));
        }
        for (String name: names){
            System.out.println(name);
        }*/
        Stream<String> stream = names.stream();
        //stream.forEach(s -> System.out.println(s));
        //stream.forEach(System.out::println);
        //Pipeline: filter - transform - iteration | aggregation
        Stream<String> filtered = stream.filter(s -> s.startsWith("H"));
        Stream<Integer> transformed = filtered.map(s -> s.length());
        transformed.forEach(System.out::println);

        names.stream().filter(s -> s.startsWith("H")).map(s -> s.length()).forEach(System.out::println);


    }
}
