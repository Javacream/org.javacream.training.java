package org.javacream.training.java.demo.classes;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaScratch {

	public void demo() {
		Consumer<String> c = s -> System.out.println(s);
		Consumer<String> c2 = (s) -> System.out.println(s);
		Consumer<String> c3 = (s) -> {System.out.println(s);};
		Consumer<String> c4 = (String s) -> {System.out.println(s);};
		Consumer<String> c5 = Demo::printString;
		Consumer<String> c5a = (s) ->  Demo.printString(s);
	
		Demo demo = new Demo();
		Consumer<String> c6 = demo::instancePrintString;
		
		Predicate<String> p = s -> s.startsWith("A");
		Predicate<String> p2 = (String s) -> {return s.startsWith("A");};
		Predicate<String> p3 = Demo::checkString;
		Predicate<String> p4 = demo::instanceCheck;
		//Predicate<Integer> p5 = demo::instanceCheckString;
		Predicate<Integer> p5 = demo::instanceCheck;
		//Predicate<Object> p6 = demo::instanceCheck;

		
		//() -> {return 42;} = "Ein Lambda-Ausdruck, der keinen Parameter entgegen nimmt und ein Integer zurückliefert"
		Supplier<Integer> s = () -> {return 42;};
		s.get();
		PowerProvider pp = () -> {return 42;};
		pp.power();
 		//s = pp;  //Compiler FGehler: Typen sind nicht passend
	}
	
	
}
class Demo{
	static public void printString (String s) {
		System.out.println(s);
	}
	static public boolean checkString (String s) {
		return s.startsWith("A");
	}

	public void instancePrintString (String s) {
		System.out.println(s);
	}
	public boolean instanceCheck (String s) {
		return s.startsWith("A");
	}
	public boolean instanceCheck (Integer i) {
		return i > 42;
	}

}
