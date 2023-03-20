package org.javacream.training.java;

import java.util.Objects;

public class Person {

    private String lastname;
    private String firstname;
    private Integer height;
    private Double weight;
    private Person partner;
    public String introduce(){
        return "Person: lastname=" + this.lastname + ", firstname=" + this.firstname + ", height=" + this.height + ", weight=" + this.weight;
    }

    public Person(String lastname, String firstname, Integer height, Double weight) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.height = height;
        this.weight = weight;
    }


    public Boolean marry(Person newPartner){
        if (newPartner != null && newPartner != this && newPartner.partner == null && this.partner == null) {
            this.partner = newPartner;
            newPartner.partner = this;
            return true;
        } else {
            return false;
        }
    }

    public Boolean divorce(){
        if (this.partner != null) {
            this.partner.partner = null;
            this.partner = null;
            return true;
        } else {
            return false;
        }
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(lastname, person.lastname) && Objects.equals(firstname, person.firstname) && Objects.equals(height, person.height) && Objects.equals(weight, person.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastname, firstname, height, weight);
    }
}
