package org.javacream.training.java.functional;

//public Top Level-Klasse
public class Scratch {
    private String attr = "Hugo";
    private static String staticAttr = "Emil";
    class Inner{
        private String attr;
        public void inInner(){
            System.out.println(attr);
            System.out.println(Scratch.this.attr);
        }
    }
    static class StaticInner{
        private String attr;
        public void inInner(){
            System.out.println(attr);
            System.out.println(staticAttr);
        }
    }

    public void doSomething(){
        var demo = 42;
        class MethodClass{
            private String attr;
            public void inInner(){
                System.out.println(attr);
                System.out.println(Scratch.this.attr);
                System.out.println(demo);
            }
        }
        var m = new MethodClass();
        class DemoInterface1Impl implements DemoInterface1{

            @Override
            public Integer work(String s) {
                return s.length();
            }
        }
        class DemoInterface2Impl implements DemoInterface2{

            @Override
            public Integer foo(String s) {
                return null;
            }

            @Override
            public Integer goo(String s) {
                return null;
            }
        }

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
    }


}
//n non-public classes
class Demo1{

}

interface DemoInterface1{
    Integer work(String s);
}
interface DemoInterface2{
    Integer foo(String s);
    Integer goo(String s);
}
