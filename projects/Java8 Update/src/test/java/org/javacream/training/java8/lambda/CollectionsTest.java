package org.javacream.training.java8.lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionsTest {
    @Test
    public void testListIteration() {
        List<String> names = new ArrayList<>();
        names.add("Emil");
        names.add("Fritz");
        Stream<String> namesStream = names.stream();
        defineWorkflow1(namesStream);
    }

    private void defineWorkflow1(Stream<String> stream){
        //filter - final operation = Iteration
        Predicate<String> predicate = (s) -> s.startsWith("E");
        Consumer<String> consumer = System.out::println;

        Stream<String> filteredStream = stream.filter(predicate);
        filteredStream.forEach(consumer);
    }
    private void defineWorkflow1_b(Stream<String> stream){
        //filter - final operation = Iteration
        Stream<String> filteredStream = stream.filter((s) -> s.startsWith("E"));
        filteredStream.forEach(System.out::println);
    }
    private void defineWorkflow1_c(Stream<String> stream){
        //filter - final operation = Iteration
        stream.filter((s) -> s.startsWith("E")).forEach(System.out::println);
    }


    private void defineWorkflow2(Stream<String> stream){
        //filter - final operation = Ergebnis-Liste
        Stream<String> filteredStream = stream.filter(null);
//        ArrayList<String> result = new ArrayList<>();
//        filteredStream.forEach(null); //Conusmer: result.add(element)
        List<String> result = filteredStream.collect(Collectors.toList());
    }
    private void defineWorkflow3(Stream<String> stream){
        //filter - transform - final operation = Ergebnis-Liste
        Stream<String> filteredStream = stream.filter(s -> s.startsWith("E"));
        Stream<Integer> transformedStream = filteredStream.map(s -> s.length());
        List<Integer> result = transformedStream.collect(Collectors.toList());
    }


}
