package org.javacream.training.java;

import org.junit.Test;

public class PeopleTest {
  @Test public void testPeople(){
      Person p1 = new Person("A", "B", 100, 10.0);
      Student s1 = new Student("C", "D", 100, 10.0, "LMU");
      Person p2 = new Student("E", "F", 100, 10.0, "LMU");//rein akademisch
      printIntro(p1);
      printIntro(s1);
      printIntro(p2);
      Student s2 = s1;
      s2 = (Student) p2;
      //s2 = (Student) p1;

  }

  private void printIntro(Person p){//Polymorphie: Der Parameter bleibt vom Typ erhalten
      System.out.println(p.introduce());
  }

}


