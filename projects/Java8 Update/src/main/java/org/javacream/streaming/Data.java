package org.javacream.streaming;

import org.javacream.people.Address;
import org.javacream.people.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data {

    public static List<String> names = Arrays.asList(new String[]{"Hugo", "Emil", "Fritz", "Eduard", "Hugo"});
    public static List<List<Integer>> numbers = new ArrayList<>();
    public static List<Person> people = new ArrayList<>();

    static {
        Person p1 = new Person("Sawitzki", 81.1);
        Person p2 = new Person("Meier", 79.2);
        Person p3 = new Person("Mustermnn", 66.6);

        Address a1 = new Address("München", "Marienplatz");
        Address a2 = new Address("Berlin", "Alexanderplatz");
        p1.setAddress(a1);
        p2.setAddress(a2);
        p3.setAddress(a1);
        people.add(p1);
        people.add(p2);
        people.add(p3);

        List<Integer> e1 = Arrays.asList(new Integer[]{1,2});
        List<Integer> e2 = Arrays.asList(new Integer[]{47,11});
        numbers.add(e1);
        numbers.add(e2);

    }
}
