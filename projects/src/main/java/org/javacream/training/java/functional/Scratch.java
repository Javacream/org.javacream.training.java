package org.javacream.training.java.functional;

//public Top Level-Klasse
public class Scratch {

    public void doSomething(){
        var dif1 = new DemoInterface1(){
            @Override
            public Integer work(String s) {
                return s.length();
            }
        };
        var dif2 = new DemoInterface2(){
            @Override
            public Integer foo(String s) {
                return null;
            }
            @Override
            public Integer goo(String s) {
                return null;
            }
        };

        DemoInterface1 dif1_1 = s -> s.length() ;
        //DemoInterface2 dif1_1 = s -> s.length() ;
        Runnable r = ()-> System.out.println("Hello");
    }


}

@FunctionalInterface
interface DemoInterface1{
    Integer work(String s);
}
//@FunctionalInterface
interface DemoInterface2{
    Integer foo(String s);
    Integer goo(String s);
}
