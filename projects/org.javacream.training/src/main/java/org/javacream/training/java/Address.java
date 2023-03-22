package org.javacream.training.java;

import java.io.Serializable;
import java.util.Objects;

public class Address implements Serializable {
    public void setCity(String city) {
        this.city = city;
    }

    public Address(){

    }
    public void setStreet(String street) {
        this.street = street;
    }

    private String city;
    private String street;

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(city, address.city) && Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street);
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
