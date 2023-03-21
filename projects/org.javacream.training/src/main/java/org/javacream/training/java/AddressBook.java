package org.javacream.training.java;

import java.util.HashMap;
import java.util.Map;

public class AddressBook {
    private Map<Address, Addressable> addresses = new HashMap<>();

    public void add(Addressable a){
        addresses.put(a.getAddress(), a);//Hinweis: Eigentlich müsste Map<Address, List<Address>> sein
    }

    public Addressable findByAddress(Address a){
        return addresses.get(a);
    }
}
