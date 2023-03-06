package org.javacream.training.java8.lambda;


import org.junit.jupiter.api.Test;

public class DemoTest {

    @Test public void testDemoWithAnonymousClass(){
        Demo demo = new Demo(){
            @Override
            public void doDemo(String s) {
                System.out.println(s);
            }
        };
    }

    @Test public void testDemoWithLambda(){
        Demo demo = (String s) -> {
                System.out.println(s);
            };
    }
    @Test public void testDemoWithLambdaCompact(){
        Demo demo = (String s) -> System.out.println(s);
        Demo demo2 = s -> System.out.println(s); //Type Inference: Der Typ von s wird vom Compiler aus der Schnittstelle entnommen

        //Typ-Prüfungen
        //Demo demo3 = (Integer s) -> System.out.println(s); //Compiler Fehler, Parameter-Typ passt nicht
        //Demo demo4 = (String s) -> return 42; //Compiler Fehler, Rückgabe-Typ passt nicht

        //Syntax
        Demo demo4 = s -> {System.out.println(s);};
        Demo demo5 = (s) -> {System.out.println(s);};

    }

}
