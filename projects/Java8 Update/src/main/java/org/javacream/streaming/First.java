package org.javacream.streaming;

import java.util.Arrays;
import java.util.stream.Stream;

public class First {
    public static void main(String[] args) {
        new First();
    }

    {
        String[] names = {"Hugo", "Emil", "Fritz", "Eduard"};
        workflowCompact(Arrays.stream(names));
    }

    public void workflow(Stream<String> stringStream){
        Stream<String> filteredStream = stringStream.filter(s -> s.startsWith("E"));
        Stream<Integer> transformedStream = filteredStream.map(s -> s.length());//Type Inference des Compilers
        transformedStream.forEach(System.out::println);
        //stringStream.forEach(System.out::println);
    }
    public void workflowCompact(Stream<String> stringStream){
        stringStream.filter(s -> s.startsWith("E")).map(s -> s.length()).forEach(System.out::println);
    }
}
