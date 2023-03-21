package org.javacream.training.java;

import com.sun.nio.sctp.PeerAddressChangeNotification;
import org.junit.Test;

public class FunctionalTest {


    @Test public void testPersonIntroducer(){
        Person p = new Person("A", "B", 100, 10.0);
        class ConsolePersonIntroducer implements PersonIntroducer{
            @Override
            public void introducePerson(Person p) {
                System.out.println(p.introduce());
            }
        }
        PersonIntroducer pi = new ConsolePersonIntroducer();
        pi.introducePerson(p);
        }
    interface PersonIntroducer{
        public void introducePerson(Person p);
    }
}
