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


}
