package org.javacream.training.java8.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest {
    public void scratch(){
        List<String> names = new ArrayList<>();
        names.add("Hugo");
        List objects = names;
        objects.add(42);
        for (String s: names){

        }

    }

    interface Demo<T, R>{
        R doIt(T o);

    }

    class DemoGenericImpl implements Demo{

        @Override
        public Object doIt(Object o) {
            return null;
        }
    }

    class DemoImpl implements Demo<Integer, String>{
        @Override
        public String doIt(Integer o) {
            return null;
        }

    }
}
