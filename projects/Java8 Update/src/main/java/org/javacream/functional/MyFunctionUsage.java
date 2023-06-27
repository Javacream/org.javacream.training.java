package org.javacream.functional;

public class MyFunctionUsage {
    public static void main(String[] args) {
        MyFunction myFunction = (String param1, Integer param2) -> {
            System.out.println("param1=" + param1 + ", param2=" + param2);
            return true;
        };
        System.out.println(myFunction.fn("Hugo", 42));
    }



}

class MyFunctionImpl implements MyFunction{

    @Override
    public boolean fn(String p1, Integer p2) {
        return false;
    }
}
