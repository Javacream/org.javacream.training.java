package org.javacream.training.java8.lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
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
        Stream<String> filteredStream = stream.filter(null);
        filteredStream.forEach(null);
    }
    private void defineWorkflow2(Stream<String> stream){
        //filter - final operation = Ergebnis-Liste
        Stream<String> filteredStream = stream.filter(null);
//        ArrayList<String> result = new ArrayList<>();
//        filteredStream.forEach(null); //Conusmer: result.add(element)
        List<String> result = filteredStream.collect(Collectors.toList());
    }
}
