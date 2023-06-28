package org.javacream.functional;

import java.util.function.BiFunction;
import java.util.function.Predicate;

public class MyFunctionUsage {
    public static void main(String[] args) {
        MyFunction myFunction = (param1, param2) -> {
            return param1.length() > param2;
        };
        MyFunction myFunctionTypeInference = (param1, param2) -> {
            return param1.length() > param2;
        };
        MyFunction myFunctionTypeInferenceCompact = (param1, param2) -> param1.length() > param2;//Ohne Block: implizites return des letzten Ausdrucks
        AnotherFunction af = (param1, param2) -> param1.length() > param2;
        BiFunction<String, Integer, Boolean> bf = (param1, param2) -> param1.length() > param2;
        //MyFunction f = af; Compiler Fehler, cast ist nicht möglich
        System.out.println(myFunction.fn("Hugo", 42));
        System.out.println(bf.apply("Hugo", 42));
        Predicate<String> p = (s) -> s.length() == 4;
        p.test("Hugo");

        BiFunction<String, Integer, Boolean> bf2 = new BiFunction<String, Integer, Boolean>() {
            @Override
            public Boolean apply(String param1, Integer param2) {
                return param1.length() > param2;
            }
        };


    }
}

