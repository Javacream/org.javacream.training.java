package org.javacream.streaming;

import java.util.Arrays;
import java.util.stream.Stream;

public class First {
    public static void main(String[] args) {
        new First();
    }

    {
        String[] names = {"Hugo", "Emil", "Fritz"};
        workflow(Arrays.stream(names);
    }

    public void workflow(Stream<String> stringStream){
        stringStream.forEach(System.out::println);

    }
}
