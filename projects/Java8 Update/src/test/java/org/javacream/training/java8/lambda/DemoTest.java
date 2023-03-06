package org.javacream.training.java8.lambda;


import org.junit.jupiter.api.Test;

public class DemoTest {

    @Test public void test(){
        DemoImpl di = new DemoImpl();
        di.doDemo("");
        DemoImpl.InnerDemoImpl innerDi = di.new InnerDemoImpl();
    }
}
