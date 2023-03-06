package org.javacream.training.java8.lambda;

public class DemoImpl implements Demo{
    private int value = 9;
    @Override
    public void doDemo(String s) {
        System.out.println(s);
    }

    public void classInMethod() {
        String variable = "method";
        class MethodDemoImpl implements Demo{
            @Override
            public void doDemo(String s) {
                System.out.println(value + " " + s + " " + variable) ;
            }
        }
        MethodDemoImpl mdi = new MethodDemoImpl();
        mdi.doDemo(variable);

    }
    public void anonymousClassInMethod() {
        String variable = "method";
        Demo demo = new Demo(){
            @Override
            public void doDemo(String s) {
                System.out.println(value + " " + s + " " + variable) ;
            }
        };
        demo.doDemo(variable);

    }




    class InnerDemoImpl implements Demo{
        @Override
        public void doDemo(String s) {
            System.out.println(value + " " + s);
        }
    }


}
class AnotherDemoImpl implements Demo{
    @Override
    public void doDemo(String s) {
        System.out.println(s);
    }
}

