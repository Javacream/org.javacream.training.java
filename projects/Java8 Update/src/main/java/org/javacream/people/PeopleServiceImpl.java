package org.javacream.people;

import java.util.Objects;

public class PeopleServiceImpl implements PeopleService{
    private String name;
    private Double weight;
//############### Generated Code Start
    public PeopleServiceImpl(String name, Double weight) {
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
        PeopleServiceImpl that = (PeopleServiceImpl) o;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getWeight(), that.getWeight());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getWeight());
    }

    @Override
    public String toString() {
        return "PeopleServiceImpl{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
//############### Generated Code End

}
