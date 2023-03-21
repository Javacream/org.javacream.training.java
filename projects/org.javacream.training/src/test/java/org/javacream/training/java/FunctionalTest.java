package org.javacream.training.java;

import com.sun.nio.sctp.PeerAddressChangeNotification;
import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalTest {


    @Test public void testPersonIntroducer(){
        Person p = new Person("A", "B", 100, 10.0);
        PersonIntroducer pi = System.out::println;
        pi.introducePerson(p);
        }
    interface PersonIntroducer{
        public void introducePerson(Person p);
    }

    @Test public void testJavaUtilFunctions(){
        Function<String, Integer> f1 = (String s) -> {return s.length();};
        Function<String, Integer> f2 = (s) -> {return s.length();};
        Function<String, Integer> f3 = s -> {return s.length();};
        Function<String, Integer> f4 = s -> s.length();
        Integer result = f1.apply("Hugo");
        System.out.println(result);
        Consumer<String> c = System.out::println;
        c.accept("hugo");

        Supplier<String> supplier = () -> {return "Hugo";};
        String supplierResult = supplier.get();
        System.out.println(supplierResult);

        Predicate<String> predicate = (s) -> s.startsWith("H");
        Boolean b = predicate.test("Hugo");
        System.out.println(b);
    }
}
