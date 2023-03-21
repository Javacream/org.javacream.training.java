package org.javacream.training.java;

public class Person implements Addressable{

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
    public Person(Integer id, String lastname, String firstname, Integer height, Double weight) {
        this(lastname, firstname, height, weight);
        this.id = id;
    }


    @Override
    public String toString() {
        return "Person{" +
                "lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", partner=" + partner +
                ", address=" + address +
                ", id=" + id +
                '}';
    }

    public final Boolean marry(Person newPartner){
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
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    private Address address;

    public Integer getId() {
        return id;
    }

    private Integer id;
}
