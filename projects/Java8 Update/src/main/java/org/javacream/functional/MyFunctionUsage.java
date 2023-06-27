package org.javacream.functional;

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
        //MyFunction f = af; Compiler Fehler, cast ist nicht möglich
        System.out.println(myFunction.fn("Hugo", 42));
    }
}

