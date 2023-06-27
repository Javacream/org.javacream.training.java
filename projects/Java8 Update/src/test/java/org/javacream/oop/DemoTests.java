package org.javacream.oop;

import org.junit.jupiter.api.Test;

public class DemoTests {

    public void playWithInnerClasses(){
        TopLevelWithInnerClasses instance = new TopLevelWithInnerClasses();
        TopLevelWithInnerClasses.Inner innerInstance = instance.new Inner();
        TopLevelWithInnerClasses.StaticInner staticInnerInstance = new TopLevelWithInnerClasses.StaticInner();
    }

    @Test
    public void playWithMethodClasses(){
        ClassWithMethodClasses instance = new ClassWithMethodClasses();
        instance.methodWithClassDefinition();
    }

}



