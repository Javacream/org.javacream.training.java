package org.javacream.training.java;

import org.junit.Test;

import static org.junit.Assert.*;

public class PeopleControllerTest {

    @Test
    public void create() {
        PeopleController pc = new PeopleController();
        Person p = pc.create("A", "B", 100, 10.0);
        assertEquals("A", p.getLastname());
    }

    @Test
    public void findById() {
        PeopleController pc = new PeopleController();
        Person p = pc.create("A", "B", 100, 10.0);
        Person searchResult = pc.findById(p.getId());
        assertTrue(p == searchResult);
        Person searchResult2 = pc.findById(-12345);
        assertNull(searchResult2);
    }

    @Test
    public void update() {
        PeopleController pc = new PeopleController();
        Person p = pc.create("A", "B", 100, 10.0);
        Address a = new Address("C", "D");
        pc.update(p.getId(), a);
        Person searchResult = pc.findById(p.getId());
        assertTrue(p.getAddress() == a);

    }

    @Test
    public void deleteById() {
        PeopleController pc = new PeopleController();
        Person p = pc.create("A", "B", 100, 10.0);
        Person searchResult = pc.findById(p.getId());
        assertTrue(p == searchResult);
        pc.deleteById(p.getId());
        searchResult = pc.findById(p.getId());
        assertNull(searchResult);
    }
}