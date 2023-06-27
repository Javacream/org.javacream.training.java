package org.javacream.oop;

public class TopLevelWithInnerClasses {
    private String data;
    private static String staticData;
    public void doSomething(){
        System.out.println(this.data);
    }
    //public | protected | | private
    class Inner{
        private String inner;
        private void innerDoSomething(){
            System.out.println(this.inner);
            System.out.println(TopLevelWithInnerClasses.this.data);
            System.out.println(TopLevelWithInnerClasses.staticData);
            //Abkürzung, möglich falls keine Namenskollisionen vorhanden sind
            System.out.println(inner);
            System.out.println(data);
            System.out.println(staticData);

        }
    }
    static class StaticInner{
        private String inner;
        private void innerDoSomething(){
            System.out.println(this.inner);
            System.out.println(TopLevelWithInnerClasses.staticData);
            //Abkürzung, möglich falls keine Namenskollisionen vorhanden sind
            System.out.println(inner);
            System.out.println(staticData);

        }
    }


}
