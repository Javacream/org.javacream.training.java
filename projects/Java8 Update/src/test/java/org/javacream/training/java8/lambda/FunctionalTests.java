package org.javacream.training.java8.lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.function.Predicate;

public class FunctionalTests<s> {
    @Test public void testList(){
        //Streaming-API
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();
        for (String n: names){
            if (n.startsWith("E")) {
                result.add(n);
            }
        }
        result = new ArrayList<>();
        for (String n: names){
            if (this.check(n)) {
                result.add(n);
            }
        }

        result = new ArrayList<>();
        for (String n: names){
            if (this.checkString.test(n)) {
                result.add(n);
            }
        }



    }
    private Predicate<String> checkString= s -> s.startsWith("E");
    private boolean check(String s){
        return s.startsWith("E");
    }
    private boolean checkMaxLength(String s, int max){
        return s.length() >= max;
    }


}
