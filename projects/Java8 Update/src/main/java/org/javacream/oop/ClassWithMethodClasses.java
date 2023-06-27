package org.javacream.oop;

public class ClassWithMethodClasses {
    private String data;

    public void doSomething(){
        System.out.println(this.data);
    }

    public void methodWithClassDefinition(){
        String methodData = "Demo";
        class MethodClass1{

        }
        class MethodClass2{
            private String method2Data;
            public void inMethodClass(){
                System.out.println(methodData);
            }
        }

        MethodClass2 instance = new MethodClass2();
        //Closure: Die Rückgabe-Instanz hat immer noch Zugriff auf die "loakle" Variable method2Data
        instance.inMethodClass();
    }
}