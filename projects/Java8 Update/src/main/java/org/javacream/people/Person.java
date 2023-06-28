package org.javacream.people;

import java.util.Objects;

public class Person {
    private String name;
    private Double weight;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    private Address address;
    //############### Generated Code Start
    public Person(String name, Double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person that = (Person) o;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getWeight(), that.getWeight());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getWeight());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
//############### Generated Code End


}
