package org.javacream.training.java;

import com.sun.nio.sctp.PeerAddressChangeNotification;
import org.junit.Test;

public class FunctionalTest {


    @Test public void testPersonIntroducer(){
        Person p = new Person("A", "B", 100, 10.0);
        PersonIntroducer pi = System.out::println;
        pi.introducePerson(p);
        }
    interface PersonIntroducer{
        public void introducePerson(Person p);
    }
}
