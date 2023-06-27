package org.javacream.oop;

public class Tests {

    public void playWithInnerClasses(){
        TopLevelWithInnerClasses instance = new TopLevelWithInnerClasses();
        TopLevelWithInnerClasses.Inner innerInstance = instance.new Inner();
        TopLevelWithInnerClasses.StaticInner staticInnerInstance = new TopLevelWithInnerClasses.StaticInner();
    }

}



