package org.javacream.training.java;

public class Company implements Addressable{
    private String name;

    private Address address;

    @Override
    public Address getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company(String name) {
        this.name = name;
    }
}
