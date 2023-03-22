package org.javacream.training.java;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class JacksonTest {

    @Test public void writeJson() throws JsonProcessingException {
        Person p = new Person(42, "Sawitzki", "Rainer", 100, 10.0);
        p.setAddress(new Address("München", "Marienplatz"));
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(p);
        System.out.println(json);
    }
    @Test public void readJson() throws JsonProcessingException {
        String json = "[{\"lastname\":\"Sawitzki\",\"firstname\":\"Rainer\",\"height\":100,\"weight\":10.0,\"address\":{\"city\":\"München\",\"street\":\"Marienplatz\"},\"id\":42}, {\"lastname\":\"Sawitzki\",\"firstname\":\"Rainer\",\"height\":100,\"weight\":10.0,\"address\":{\"city\":\"München\",\"street\":\"Marienplatz\"},\"id\":43}]";
        ObjectMapper objectMapper = new ObjectMapper();
        Person[] people = objectMapper.readValue(json, Person[].class);
        Arrays.asList(people).forEach(System.out::println);
    }
    //
}
