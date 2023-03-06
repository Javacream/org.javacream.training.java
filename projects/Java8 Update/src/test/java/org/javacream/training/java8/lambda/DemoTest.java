package org.javacream.training.java8.lambda;


import org.junit.jupiter.api.Test;

public class DemoTest {

    @Test public void testDemoWithAnonymousClass(){
        Demo demo = new Demo(){
            @Override
            public void doDemo(String s) {
                System.out.println(s);
            }

            @Override
            public void doDemo2(String s) {

            }
        };
    }

}
