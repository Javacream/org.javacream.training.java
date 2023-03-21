package org.javacream.training.java;

public class Student extends Person {
    private String university;

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public Student(String lastname, String firstname, Integer height, Double weight, String university) {
        super(lastname, firstname, height, weight);
        this.university = university;
    }

    @Override //Überschreiben einer Methode
    public String introduce() {
        return super.introduce() + ", i am a student!";
    }
    public String introduce(boolean b) {//Überladen einer Methoden-Signatur, der Identifier einer Java-Methode wird aus dem Namen und den Parameter-Typen gebildet
        return super.introduce() + ", i am a student!";
    }
}
