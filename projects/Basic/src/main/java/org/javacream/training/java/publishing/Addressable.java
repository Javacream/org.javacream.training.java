package org.javacream.training.java.publishing;

public interface Addressable {
    String name="Hugo";
    Address getAddress();
    default String getFormattedAddress(){
        Address a = getAddress();
        return a.getCity() + " " + a.getStreet();
    }
    default boolean isValid(){
        return true;
    }
}
