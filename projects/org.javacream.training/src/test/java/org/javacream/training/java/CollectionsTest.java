package org.javacream.training.java;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class CollectionsTest {

    @Test public void testStringList(){
        String s1 = "Hello";
        String s2 = "World";
        List<String> strings = new ArrayList<>();
        strings.add(s1);
        strings.add(s2);
        strings.add(s1);
        Assert.assertEquals(3, strings.size());
        Assert.assertEquals("Hello", strings.get(0));
        Assert.assertEquals("World", strings.get(1));
        for(String s: strings){
            System.out.println(s);
        }
    }
    @Test public void testStringSet(){
        String s1 = "Hello";
        String s2 = "World";
        Set<String> strings = new HashSet<>();
        strings.add(s1);
        strings.add(s2);
        strings.add(s1);
        Assert.assertEquals(2, strings.size());
        //Assert.assertEquals("Hello", strings.get(0));
        //Assert.assertEquals("World", strings.get(1));
        for(String s: strings){
            System.out.println(s);
        }
    }

    @Test public void testMap(){
        Map<Integer, String> postalCodeToCity = new HashMap<>();
        postalCodeToCity.put(81371, "München");
        postalCodeToCity.put(30000, "Berlin");
        postalCodeToCity.put(40000, "Hamburg");
        Assert.assertEquals("Berlin", postalCodeToCity.get(30000));
        Assert.assertNull(postalCodeToCity.get(12345));
        for (Integer i: postalCodeToCity.keySet()){
            System.out.println(i + ":" + postalCodeToCity.get(i));
        }


    }

    @Test public void testAddressList(){
        Address a1 = new Address("A", "B");
        Address a2 = new Address("C", "D");
        Address a3 = new Address("A", "B");
        List<Address> addresses = new ArrayList<>();
        addresses.add(a1);
        addresses.add(a2);
        addresses.add(a3);
        Assert.assertEquals(3, addresses.size());
        Assert.assertEquals(a1, addresses.get(0));
        Assert.assertEquals(a2, addresses.get(1));
        for(Address a: addresses){
            System.out.println(a);
        }
    }
    @Test public void testAddressSet(){
        Address a1 = new Address("A", "B");
        Address a2 = new Address("C", "D");
        Address a3 = new Address("A", "B");
        Set<Address> addresses = new HashSet<>();
        addresses.add(a1);
        addresses.add(a2);
        addresses.add(a3);
        Assert.assertEquals(2, addresses.size());
        //Assert.assertEquals("Hello", addresses.get(0));
        //Assert.assertEquals("World", addresses.get(1));
        for(Address a: addresses){
            System.out.println(a);
        }
    }
    @Test public void testPersonList(){
        Person p1 = new Person("A", "B", 100, 10.0);
        Person p2 = new Person("C", "D", 100, 10.0);
        Person p3 = new Person("A", "B", 100, 10.0);
        List<Person> people = new ArrayList<>();
        people.add(p1);
        people.add(p2);
        people.add(p3);
        Assert.assertEquals(3, people.size());
        Assert.assertEquals(p1, people.get(0));
        Assert.assertEquals(p2, people.get(1));
        for(Person p: people){
            System.out.println(p);
        }
    }
    @Test public void testPersonSet(){
        Person p1 = new Person("A", "B", 100, 10.0);
        Person p2 = new Person("C", "D", 100, 10.0);
        Person p3 = new Person("A", "B", 100, 10.0);
        Set<Person> people = new HashSet<>();
        people.add(p1);
        people.add(p2);
        people.add(p3);
        Assert.assertEquals(3, people.size());
        //Assert.assertEquals("Hello", strings.get(0));
        //Assert.assertEquals("World", strings.get(1));
        for(Person p: people){
            System.out.println(p);
        }
    }



}
