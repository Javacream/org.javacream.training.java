package org.javacream.training.java;

public class Person {

    private String lastname;
    private String firstname;
    private Integer height;
    private Double weight;

    public String introduce(){
        return "Person: lastname=" + this.lastname;
    }

}
