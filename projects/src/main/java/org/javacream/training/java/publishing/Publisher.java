package org.javacream.training.java.publishing;

import java.util.HashSet;
import java.util.Set;

public class Publisher {
    private String name;
    private Set<Book> books;

    public Publisher(String name) {
        this.name = name;
        books = Set.of();
    }
}
