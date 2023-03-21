package org.javacream.training.java;

public class Student extends Person {
    private String university;
    public Student(String lastname, String firstname, Integer height, Double weight, String university) {
        super(lastname, firstname, height, weight);
        this.university = university;
    }

    @Override
    public String introduce() {
        return super.introduce();
    }
}
